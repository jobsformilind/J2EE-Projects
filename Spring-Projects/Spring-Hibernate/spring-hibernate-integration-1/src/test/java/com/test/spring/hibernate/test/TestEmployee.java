package com.test.spring.hibernate.test;

import java.io.Serializable;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.spring.hibernate.domain.Employee;
import com.test.spring.hibernate.service.EmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:**/*.context.xml")
public class TestEmployee {

	@Autowired
	private EmployeeService service;

	@Test
	public void testInsert() {
		Employee entity = new Employee();
		entity.setName("John");
		entity.setSalary(15000.50F);
		Serializable obj = this.service.insert(entity);
		Assert.assertNotNull("Entity must be inserted.", obj);
	}

}
