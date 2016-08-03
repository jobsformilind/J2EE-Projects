package com.test.voting.interceptor;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.Validator;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.test.voting.base.BaseService;

public class ValidationInterceptor implements MethodInterceptor {
	@Autowired
	private Validator validator;

	public Object invoke(MethodInvocation invocation) throws Throwable {
		Set<ConstraintViolation<?>> violations = new HashSet<ConstraintViolation<?>>();
		Object target = invocation.getThis();
		Object[] args = invocation.getArguments();
		if(target instanceof BaseService && ArrayUtils.isNotEmpty(args)) {
			
		}
		
		
		Method iMethod = invocation.getMethod();
		Method method = getDeclaredMethod(target.getClass(), iMethod.getName(), iMethod.getParameterTypes());
		Parameter[] parameters = method.getParameters();

		for (int count = 0; count < parameters.length; count++) {
			Parameter param = parameters[count];
			if (param.isAnnotationPresent(Valid.class)) {
				violations.addAll(validator.validate(args[count]));
			}
		}
		if (!violations.isEmpty()) {
			throw new ConstraintViolationException(violations);
		}
		return invocation.proceed();
	}

	private Method getDeclaredMethod(Class<?> clazz, String name, Class<?>... parameterTypes) {
		Method method = null;
		while (clazz != null) {
			try {
				method = clazz.getDeclaredMethod(name, parameterTypes);
				if (method != null) {
					break;
				}
			} catch (NoSuchMethodException e) {
				// Ignore
			} catch (SecurityException e) {
				e.printStackTrace();
			}
			clazz = clazz.getSuperclass();
		}
		return method;
	}
}
