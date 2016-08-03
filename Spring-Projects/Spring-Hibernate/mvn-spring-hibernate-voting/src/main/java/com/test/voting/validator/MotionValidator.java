package com.test.voting.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.test.voting.domain.Motion;

@Component
public class MotionValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		System.out.println("------------ Inside supports method :" + clazz.getName());
		return Motion.class.equals(clazz);
	}

	public void validate(Object object, Errors errors) {
		System.out.println("------------ Inside validate method");
		ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
		Motion motion = (Motion) object;
		if (motion.getStatus() == 0) {
			errors.rejectValue("status", "Rejected from validator for status : " + motion.getStatus());
		}
	}
	/*
	 * public <T> Set<ConstraintViolation<T>> validate(T object, Class<?>...
	 * groups) { System.out.println("------------ Inside validate method: " +
	 * object); return null; }
	 * 
	 * public <T> Set<ConstraintViolation<T>> validateProperty(T object, String
	 * propertyName, Class<?>... groups) { System.out.println(
	 * "------------ Inside validateProperty method: " + propertyName); return
	 * null; }
	 * 
	 * public <T> Set<ConstraintViolation<T>> validateValue(Class<T> beanType,
	 * String propertyName, Object value, Class<?>... groups) {
	 * System.out.println("------------ Inside validateValue method: " +
	 * propertyName); return null; }
	 * 
	 * public BeanDescriptor getConstraintsForClass(Class<?> clazz) {
	 * System.out.println("------------ Inside getConstraintsForClass method: "
	 * + clazz); return null; }
	 * 
	 * public <T> T unwrap(Class<T> type) { System.out.println(
	 * "------------ Inside unwrap method: " + type); return null; }
	 * 
	 * public ExecutableValidator forExecutables() { System.out.println(
	 * "------------ Inside forExecutables method.."); return null; }
	 * 
	 */}
