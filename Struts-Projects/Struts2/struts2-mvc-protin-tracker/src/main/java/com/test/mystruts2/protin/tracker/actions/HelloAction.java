package com.test.mystruts2.protin.tracker.actions;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class HelloAction extends ActionSupport implements Action {

	private static final long serialVersionUID = 1L;
	private String message;

	public String execute() throws Exception {
		setMessage("Hello World..");
		return SUCCESS;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
