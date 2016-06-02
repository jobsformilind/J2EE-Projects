package com.test.mystruts2.protin.tracker.actions;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class AddGoalAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;
	private int goal;

	public String execute() throws Exception {
		ProteinData proteinData = ensureProteinData();
		goal = proteinData.getGoal();
		return SUCCESS;
	}

	@Action("add-goal-save")
	public String save() throws Exception {
		ProteinData proteinData = ensureProteinData();
		proteinData.setGoal(goal);
		return "add-goal";
	}

	public int getGoal() {
		return goal;
	}

	public void setGoal(int goal) {
		this.goal = goal;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	private ProteinData ensureProteinData() {
		ProteinData proteinData = (ProteinData) session.get("PROTEIN_DATA");
		if (proteinData == null) {
			proteinData = new ProteinData();
			proteinData.setGoal(300);
			proteinData.setTotal(0);
			session.put("PROTEIN_DATA", proteinData);
		}
		return proteinData;
	}
}
