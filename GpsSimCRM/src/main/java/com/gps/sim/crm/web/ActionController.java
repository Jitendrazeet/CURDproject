package com.gps.sim.crm.web;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.gps.sim.crm.model.Enquiry;
import com.gps.sim.crm.model.Module;
import com.gps.sim.crm.model.Status;
import com.gps.sim.crm.model.User;
import com.gps.sim.crm.service.CRMService;

@Controller
@SessionAttributes("logInUser")
public class ActionController {

	@Autowired
	CRMService crmService;
	private static final Logger LOGGER = Logger.getLogger(ActionController.class);

	@RequestMapping("/LogInValidate")
	public ModelAndView logInValidator(User User) {
		User UserDao = crmService.logInValidator(User);
		ModelAndView model = new ModelAndView("LogIn");
		User.getLogInId();
		if (User.getPassword().isEmpty() || User.getLogInId().isEmpty()) {
			model.addObject("errorMsg", "Fields are empty");
		} else if (!User.getPassword().equals(UserDao.getPassword())) {
			model.addObject("errorMsg", "Password is incorrect...");
		} else {
			User userLoad = null;
			userLoad = crmService.getDetails(User.getLogInId());
			model = new ModelAndView("home");
			model.addObject("logInUser", userLoad);
		}
		return model;
	}

	@RequestMapping("/LogOut")
	public ModelAndView UserLogOut(SessionStatus session) {

		ModelAndView model = new ModelAndView("home");
		session.setComplete();
		model.addObject("errorMsg", "Log Out !!");
		return model;
	}

	@RequestMapping(value = "/postEnquiry", method = RequestMethod.POST)
	public ModelAndView postEnquiry(@RequestParam("module") String moduleId, @RequestParam("message") String message,
			HttpSession session) {
		Enquiry enquiry = new Enquiry();
		List<Module> modules = crmService.getModule();
		Module module = null;
		for (Module m : modules) {
			if (m.getId() == Integer.parseInt(moduleId)) {
				module = m;
				break;
			}
		}
		enquiry.setMessage(message.trim());
		User user = (User) session.getAttribute("logInUser");
		enquiry.setPostedBy(user);
		enquiry.setPostedOn(new Date());
		enquiry.setStatus(Status.SUBMITTED.name());
		enquiry.setModule(module);
		crmService.postEnquiry(enquiry);
		ModelAndView model = new ModelAndView("myQuerys");
		model.addObject("ModuleList", crmService.getModule());
		model.addObject("errorMsg", "SuccesFully Post !!");
		return model;

	}

	@RequestMapping(value = "/myQuerysPage", method = RequestMethod.GET)
	public final ModelAndView myQuerys() {
		LOGGER.debug("myQuerys Controller called...");
		ModelAndView model = new ModelAndView("myQuerys");
		model.addObject("ModuleList", crmService.getModule());
		return model;
	}
}
