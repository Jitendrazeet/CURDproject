package com.gps.sim.crm.exception;

import org.springframework.web.servlet.ModelAndView;

@SuppressWarnings("serial")
public class ExceptionHandler extends RuntimeException {
	private String view;

//	public ExceptionHandler(String view) {
//		this.view = view;
//	}
	public ExceptionHandler(String msg) {
		super(msg);
	}
	

	public ModelAndView handleException(RuntimeException rt, String... val) {
		ModelAndView model = null;
		if (rt instanceof RuntimeException) {
			model = new ModelAndView(view);
			model.addObject("errorMsg",val);
		}

		return model;
	}
}
