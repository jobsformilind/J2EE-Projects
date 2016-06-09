package com.test.mystruts2.protin.tracker.actions;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.CustomValidator;

public class AddProteinAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	private int enteredProtein;
	private ProteinData proteinData;
	private Map<String, Object> session;
	private boolean postBack;

	@Action("add-protein-input")
	public String input() throws Exception {
		return "add-protein";
	}

	@Action("add-protein")
	public String execute() throws Exception {
		ensureProteinData();
		ProteinTrackingService service = new ProteinTrackingService(proteinData);
		service.add(enteredProtein);
		return SUCCESS;
	}

/*	public void validate() {
		if (!postBack) {
			return;
		}
		if (enteredProtein <= 0) {
			addFieldError("enteredProtein", "Value must be greater than zero.");
		}
	}
*/
	public int getEnteredProtein() {
		return enteredProtein;
	}

	//@IntRangeFieldValidator(type=ValidatorType.FIELD, min="1", message="Entered protein must be greater than zero.")
	@CustomValidator(type = "addProteinFieldValidator")
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

	public boolean isPostBack() {
		return postBack;
	}

	public void setPostBack(boolean postBack) {
		this.postBack = postBack;
	}
}
