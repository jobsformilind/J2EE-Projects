package com.test.mystruts2.protin.tracker.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class AddProteinAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	private int enteredProtein;
	private ProteinData proteinData;
	private Map<String, Object> session;

	public String execute() throws Exception {
		ensureProteinData();
		ProteinTrackingService service = new ProteinTrackingService(proteinData);
		service.add(enteredProtein);
		return SUCCESS;
	}

	public int getEnteredProtein() {
		return enteredProtein;
	}

	public void setEnteredProtein(int enteredProtein) {
		this.enteredProtein = enteredProtein;
	}

	public ProteinData getProteinData() {
		return proteinData;
	}

	public void setProteinData(ProteinData proteinData) {
		this.proteinData = proteinData;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	private void ensureProteinData() {
		proteinData = (ProteinData) session.get("PROTEIN_DATA");
		if (proteinData == null) {
			proteinData = new ProteinData();
			proteinData.setGoal(300);
			proteinData.setTotal(0);
			session.put("PROTEIN_DATA", proteinData);
		}
	}

	public void resetTotal() {
		proteinData.setTotal(0);
	}
}
