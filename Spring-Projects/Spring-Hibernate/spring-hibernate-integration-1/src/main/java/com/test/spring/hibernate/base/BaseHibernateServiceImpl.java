package com.test.spring.hibernate.base;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.spring.base.BaseDao;
import com.test.spring.base.BaseService;

public class BaseHibernateServiceImpl<T> implements BaseService<T> {

	@Autowired
	protected BaseDao<T> baseDao;

	public Class<T> getType() {
		return baseDao.getType();
	}

	public Serializable insert(T t) {
		return baseDao.insert(t);
	}

	public void update(T t) {
		baseDao.update(t);
	}

	public void delete(T t) {
		baseDao.delete(t);
	}
}
