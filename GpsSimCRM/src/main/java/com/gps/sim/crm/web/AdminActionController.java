package com.gps.sim.crm.web;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.gps.sim.crm.exception.ExceptionHandler;
import com.gps.sim.crm.model.Enquiry;
import com.gps.sim.crm.model.Status;
import com.gps.sim.crm.model.User;
import com.gps.sim.crm.service.CRMService;

@Controller
@SessionAttributes("GetPostedOn")
public class AdminActionController {

	@Autowired
	CRMService crmService;
	private static final Logger LOGGER = Logger.getLogger(AdminActionController.class);

	@RequestMapping(value = "/listOfQuery", method = RequestMethod.GET)
	public final ModelAndView listOfQuery(HttpSession sesssion) {
		sesssion.removeAttribute("pageCounter");
		int setFirstRow = 0;
		int setResult = 4;
		LOGGER.debug("list Of Query Page Controller called...");
		ModelAndView model = new ModelAndView("listOfQuerys");
		model.addObject("ListOfQueries", crmService.getInquiries(setFirstRow, setResult));

		return model;
	}

	@RequestMapping(value = "openDashBoard/{postedOn}", method = RequestMethod.GET)
	public final ModelAndView openQuery(@PathVariable("postedOn") String postedOn) {
		LOGGER.info("Open Query To Resolve Problem for Id :" + postedOn);
		Enquiry enqDetails = crmService.getPostedDetails(postedOn);
		LOGGER.debug("Open Query Page Controller called...");
		ModelAndView model = new ModelAndView("openQuery");
		model.addObject("GetPostedOn", postedOn);
		model.addObject("EnquiryDetails", enqDetails);
		// String moduleName = enqDetails.getModule().getName();
		// LOGGER.debug("Open Query Page Controller called Module List :" +
		// moduleName);
		// model.addObject("moduleName", moduleName);
		model.addObject("AssignToList", crmService.getUsersByRoleId(2));

		return model;
	}

	@RequestMapping(value = "openDashBoard/assignToUser", method = RequestMethod.POST)
	public final String assignToUser(@RequestParam("assignedTo") String assignedTo, HttpSession sesssion) {
		LOGGER.info("Asssign To User Controller Call  @RequestParam " + assignedTo);
		Enquiry enquiry = new Enquiry();
		User user = new User();
		ModelAndView model = new ModelAndView("listOfQuerys");
	try {
			Date getDateOn = (Date) sesssion.getAttribute("GetPostedOn");
			LOGGER.debug("Value from Session Of GetPosted On is :" + getDateOn);
			enquiry.setPostedOn(getDateOn);
			user.setLogInId(assignedTo);
			enquiry.setAssignedTo(user);
			enquiry.setStatus(Status.ACCEPTED.name());
			model.addObject("errorMsg", "Assigned To " + enquiry.getAssignedTo().getLogInId());
			crmService.assignTo(enquiry);
			LOGGER.debug("Value of Assinged user is:" + enquiry.getAssignedTo());
		} catch (ExceptionHandler rt) {
			
		
		 rt.handleException(rt, rt.getMessage());
		}
		return "redirect:/listOfQuery";

	}

}
