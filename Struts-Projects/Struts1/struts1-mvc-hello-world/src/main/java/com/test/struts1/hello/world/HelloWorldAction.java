package com.test.struts1.hello.world;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class HelloWorldAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Entering form : " + form);
		if (form != null) {
			HelloWorldActionForm helloWorldForm = (HelloWorldActionForm) form;
			helloWorldForm.setMessage("Hello World! Struts");
		}
		System.out.println("Exiting form : " + form);
		return mapping.findForward("success");
	}

}
