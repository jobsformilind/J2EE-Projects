package com.test.voting.base;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T> {

	Class<T> getType();

	Serializable add(T t);

	void update(T t);

	void delete(T t);

	List<T> find(String hql);

	T findById(Serializable id);

	List<T> findAll(String propertyName, Object value);

	List<T> findByExample(T t);

}
