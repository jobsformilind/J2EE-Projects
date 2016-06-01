package com.test.struts2.protin.tracker.actions;

import com.opensymphony.xwork2.ActionSupport;

public class HelloWorldAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String message;

	public String execute() throws Exception {
		setMessage("Hello World !!");
		return SUCCESS;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
