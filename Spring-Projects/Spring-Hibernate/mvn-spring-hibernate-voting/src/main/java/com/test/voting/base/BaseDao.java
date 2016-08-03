package com.test.voting.base;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {

	Class<T> getType();

	Serializable add(T t);

	void update(T t);

	void delete(T t);

	T findById(Serializable id);

	List<T> findAll(String propertyName, Object value);

	List<T> findByExample(T t);

	List<T> find(String hql);

	List<T> findSQL(String hql, Class<T> T);

	List<T> findSQL(String hql);

	List<T> find(String hql, Object[] param);

	List<T> find(String hql, List<Object> param);

	List<T> find(String hql, Object[] param, Integer page, Integer rows);

	List<T> find(String hql, List<Object> param, Integer page, Integer rows);

	T get(Class<T> c, Serializable id);

	T get(String hql, Object[] param);

	T get(String hql, List<Object> param);

	Long count(String hql);

	Long count(String hql, Object[] param);

	Long count(String hql, List<Object> param);

	Integer executeHql(String hql);

	Integer executeHql(String hql, Object[] param);

	Integer executeHql(String hql, List<Object> param);

}