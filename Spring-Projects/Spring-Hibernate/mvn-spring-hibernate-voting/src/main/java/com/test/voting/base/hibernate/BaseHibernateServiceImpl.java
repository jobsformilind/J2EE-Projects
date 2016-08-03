package com.test.voting.base.hibernate;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.voting.base.BaseDao;
import com.test.voting.base.BaseService;

public class BaseHibernateServiceImpl<T> implements BaseService<T> {

	@Autowired
	protected BaseDao<T> baseDao;

	public Class<T> getType() {
		return baseDao.getType();
	}

	public Serializable add(T t) {
		return baseDao.add(t);
	}

	public void update(T t) {
		baseDao.update(t);
	}

	public void delete(T t) {
		baseDao.delete(t);
	}

	public List<T> find(String hql) {
		return baseDao.find(hql);
	}

	public T findById(Serializable id) {
		return baseDao.findById(id);
	}

	public List<T> findAll(String propertyName, Object value) {
		return baseDao.findAll(propertyName, value);
	}

	public List<T> findByExample(T t) {
		return baseDao.findByExample(t);
	}
}
