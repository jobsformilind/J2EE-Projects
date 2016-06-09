package com.test.mystruts2.protin.tracker.actions;

import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;

public class AddProteinFieldValidator extends FieldValidatorSupport {

	private String domainName;

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public void validate(Object object) throws ValidationException {
		String fieldName = getFieldName();
		Object objValue = this.getFieldValue(fieldName, object);
		System.out.println("custom validator invoked for value : " + objValue);
		int value = (Integer) objValue;
		if (value <= 0) {
			addFieldError(fieldName, object);
		}
	}
}
