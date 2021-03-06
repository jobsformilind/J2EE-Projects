package com.test.spring.aop.aspect.objectadd;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DemoAspect extends CallTracker {

	@Before("execution(void advicedMethod())")
	public void logException() {
		trackCall();
	}
}
