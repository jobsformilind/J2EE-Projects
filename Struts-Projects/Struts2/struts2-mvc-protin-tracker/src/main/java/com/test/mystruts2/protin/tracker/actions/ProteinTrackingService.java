package com.test.mystruts2.protin.tracker.actions;

public class ProteinTrackingService {
	private ProteinData proteinData;

	public ProteinTrackingService(ProteinData proteinData) {
		this.proteinData = proteinData;
	}

	public void add(int enteredProtein) {
		proteinData.setTotal(enteredProtein + proteinData.getTotal());
	}

}
