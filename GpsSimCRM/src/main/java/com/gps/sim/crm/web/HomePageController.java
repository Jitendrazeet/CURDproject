package com.gps.sim.crm.web;

import org.apache.log4j.Logger;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * HomePage controller class to display welcome page, login page, new user
 * registration page & logout
 * 
 * @author GPS
 *
 */
@ControllerAdvice
@Controller
public class HomePageController {

	private static final Logger LOGGER = Logger.getLogger(HomePageController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public final ModelAndView defualtPage() {
		LOGGER.debug("Home Page Controller called...");
		ModelAndView model = new ModelAndView("home");
		return model;
	}

	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public final ModelAndView customerLogin() {
		LOGGER.debug("Home Page Controller called...");
		ModelAndView model = new ModelAndView("LogIn");
		return model;
	}

	@RequestMapping(value = "/homePage", method = RequestMethod.GET)
	public final ModelAndView home() {
		LOGGER.debug("Home Page Controller called...");
		ModelAndView model = new ModelAndView("home");
		return model;
	}

	@RequestMapping(value = "/signUpPage", method = RequestMethod.GET)
	public final ModelAndView signUp() {
		LOGGER.debug("Home Page Controller called...");
		ModelAndView model = new ModelAndView("signUp");
		return model;
	}

	@RequestMapping(value = "/myPage", method = RequestMethod.GET)
	public final ModelAndView myProfile() {
		LOGGER.debug("Home Page Controller called...");
		ModelAndView model = new ModelAndView("myPage");
		return model;
	}

	@ExceptionHandler(value = RuntimeException.class)
	public final ModelAndView globalException(HttpRequest request, Exception ex) {
		LOGGER.debug("Globale Exception Page Home Page Controller  called ");
		ModelAndView model = new ModelAndView("home");
		LOGGER.error("Problem in URI : " + request.getURI() + " Threw An Exception :" + ex);
		model.addObject("errorMsg", "Problem !! Contact Administrator ");
		return model;

	}

}