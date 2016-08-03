package com.test.spring.base;

import java.io.Serializable;

public interface BaseDao<T> {

	Class<T> getType();

	Serializable insert(T t);

	void update(T t);

	void delete(T t);

}