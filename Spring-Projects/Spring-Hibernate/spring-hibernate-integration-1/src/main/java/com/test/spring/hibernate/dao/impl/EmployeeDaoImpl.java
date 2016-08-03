package com.test.spring.hibernate.dao.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.test.spring.hibernate.base.BaseHibernateDaoImpl;
import com.test.spring.hibernate.dao.EmployeeDao;
import com.test.spring.hibernate.domain.Employee;

@Repository
@Transactional
public class EmployeeDaoImpl extends BaseHibernateDaoImpl<Employee>implements EmployeeDao {
	
}
