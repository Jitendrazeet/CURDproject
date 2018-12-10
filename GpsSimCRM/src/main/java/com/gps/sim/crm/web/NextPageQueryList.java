package com.gps.sim.crm.web;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.gps.sim.crm.model.Enquiry;
import com.gps.sim.crm.service.CRMService;

@Controller
@SessionAttributes("pageCounter")
public class NextPageQueryList {

	@Autowired
	CRMService crmService;
	private static final Logger LOGGER = Logger.getLogger(NextPageQueryList.class);

	@RequestMapping(value = "/nextPagelistOfQuery", method = RequestMethod.GET)
	public final ModelAndView nextPagelistOfQuery(HttpSession session) {

		int setResult = 4;
		int count;
		try {
			count = (int) session.getAttribute("pageCounter");
		} catch (Exception e) {
			count = 1;

		}

		System.out.println("count" + count);
		int setStart = count * setResult;
		LOGGER.debug("list Of Query Page Controller called...");
		ModelAndView model = new ModelAndView("listOfQuerys");
		model.addObject("ListOfQueries", crmService.getInquiries(setStart, setResult));
		count = count + 1;
		model.addObject("pageCounter", count);
		for (Enquiry enquiry : crmService.getInquiries(setStart, setResult)) {

			model.addObject("GetPostedOn", enquiry.getPostedOn());
			System.out.println(enquiry.getPostedOn());
		}

		return model;
	}

	@RequestMapping(value = "/previousPagelistOfQuery", method = RequestMethod.GET)
	public final ModelAndView prePagelistOfQuery(HttpSession session) {
		int setResult = 4;
		int count;
		try {
			count = (int) session.getAttribute("pageCounter");
		} catch (Exception e) {
			count = 1;
		}
		System.out.println("count" + count);
		int setStart = count * setResult;
		LOGGER.debug("list Of Query Page Controller called...");
		ModelAndView model = new ModelAndView("listOfQuerys");
		model.addObject("ListOfQueries", crmService.getInquiries(setStart, setResult));
		count = count - 1;
		model.addObject("pageCounter", count);
		System.out.println("Count... : " + count);
		System.out.println("start.." + setStart);
		return model;
	}

	@RequestMapping(value = "/openQuery", method = RequestMethod.GET)
	public final ModelAndView openQuery() {
		LOGGER.debug("Open Query Page Controller called...");
		ModelAndView model = new ModelAndView("openQuery");
		return model;
	}

	@RequestMapping("/popUpAssignTo/{userId}")
	public ModelAndView assignedTo(@PathVariable("userId") String userId) {

		ModelAndView model = new ModelAndView("UpdateContact");
		// model.addObject("contactDetails",
		// contactService.getContactDetails(contactId));
		return model;
	}

}
