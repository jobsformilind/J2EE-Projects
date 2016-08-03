package com.test.spring.hibernate.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.test.spring.hibernate.base.BaseHibernateServiceImpl;
import com.test.spring.hibernate.domain.Employee;
import com.test.spring.hibernate.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl extends BaseHibernateServiceImpl<Employee>implements EmployeeService {

}
