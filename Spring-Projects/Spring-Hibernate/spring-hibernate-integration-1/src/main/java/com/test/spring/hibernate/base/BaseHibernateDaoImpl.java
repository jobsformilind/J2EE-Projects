package com.test.spring.hibernate.base;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.test.spring.base.BaseDao;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class BaseHibernateDaoImpl<T> implements BaseDao<T> {

	@Autowired
	private SessionFactory sessionFactory;
	private Class<T> type;

	public BaseHibernateDaoImpl() {
		Type genericType = getClass().getGenericSuperclass();
		Type[] types = ((ParameterizedType) genericType).getActualTypeArguments();
		this.type = ((Class) types[0]);
	}

	public Class<T> getType() {
		return this.type;
	}

	public Serializable insert(T t) {
		return getCurrentSession().save(t);
	}

	public void update(T t) {
		getCurrentSession().merge(t);
	}

	public void saveOrUpdate(T t) {
		getCurrentSession().saveOrUpdate(t);
	}

	public void delete(T t) {
		getCurrentSession().delete(t);
	}

	public List<T> find(String hql) {
		return this.getCurrentSession().createQuery(hql).list();
	}

	public List<T> findSQL(String hql, Class<T> T) {
		return this.getCurrentSession().createSQLQuery(hql).addEntity(T).list();
	}

	public List<T> findSQL(String hql) {
		return this.getCurrentSession().createSQLQuery(hql).list();
	}

	public List<T> find(String hql, Object[] param) {
		Query query = this.getCurrentSession().createQuery(hql);
		if (ArrayUtils.isNotEmpty(param)) {
			for (int count = 0; count < param.length; count++) {
				query.setParameter(count, param[count]);
			}
		}
		return query.list();
	}

	public List<T> find(String hql, List<Object> param) {
		Query query = this.getCurrentSession().createQuery(hql);
		if (CollectionUtils.isNotEmpty(param)) {
			for (int count = 0; count < param.size(); count++) {
				query.setParameter(count, param.get(count));
			}
		}
		return query.list();
	}

	public List<T> find(String hql, Object[] param, Integer page, Integer rows) {
		if (page == null || page < 1) {
			page = 1;
		}
		if (rows == null || rows < 1) {
			rows = 10;
		}
		Query query = this.getCurrentSession().createQuery(hql);
		if (ArrayUtils.isNotEmpty(param)) {
			for (int count = 0; count < param.length; count++) {
				query.setParameter(count, param[count]);
			}
		}
		return query.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	public List<T> find(String hql, List<Object> param, Integer page, Integer rows) {
		if (page == null || page < 1) {
			page = 1;
		}
		if (rows == null || rows < 1) {
			rows = 10;
		}
		Query query = this.getCurrentSession().createQuery(hql);
		if (CollectionUtils.isNotEmpty(param)) {
			for (int count = 0; count < param.size(); count++) {
				query.setParameter(count, param.get(count));
			}
		}
		return query.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	public T get(Class<T> c, Serializable id) {
		return (T) this.getCurrentSession().get(c, id);
	}

	public T get(String hql, Object[] param) {
		List<T> list = this.find(hql, param);
		if (CollectionUtils.isNotEmpty(list)) {
			return list.get(0);
		} else {
			return null;
		}
	}

	public T get(String hql, List<Object> param) {
		List<T> list = this.find(hql, param);
		if (CollectionUtils.isNotEmpty(list)) {
			return list.get(0);
		} else {
			return null;
		}
	}

	public Long count(String hql) {
		return (Long) this.getCurrentSession().createQuery(hql).uniqueResult();
	}

	public Long count(String hql, Object[] param) {
		Query query = this.getCurrentSession().createQuery(hql);
		if (ArrayUtils.isNotEmpty(param)) {
			for (int count = 0; count < param.length; count++) {
				query.setParameter(count, param[count]);
			}
		}
		return (Long) query.uniqueResult();
	}

	public Long count(String hql, List<Object> param) {
		Query query = this.getCurrentSession().createQuery(hql);
		if (CollectionUtils.isNotEmpty(param)) {
			for (int count = 0; count < param.size(); count++) {
				query.setParameter(count, param.get(count));
			}
		}
		return (Long) query.uniqueResult();
	}

	public Integer executeHql(String hql) {
		return this.getCurrentSession().createQuery(hql).executeUpdate();
	}

	public Integer executeHql(String hql, Object[] param) {
		Query query = this.getCurrentSession().createQuery(hql);
		if (ArrayUtils.isNotEmpty(param)) {
			for (int count = 0; count < param.length; count++) {
				query.setParameter(count, param[count]);
			}
		}
		return query.executeUpdate();
	}

	public Integer executeHql(String hql, List<Object> param) {
		Query query = this.getCurrentSession().createQuery(hql);
		if (CollectionUtils.isNotEmpty(param)) {
			for (int count = 0; count < param.size(); count++) {
				query.setParameter(count, param.get(count));
			}
		}
		return query.executeUpdate();
	}

	public Session getCurrentSession() {
		Session session = null;
		try {
			session = getSessionFactory().getCurrentSession();
		} catch (HibernateException e) {
			System.out.println("***ERRRRRRORRRR***: No database session. Creating new one.");
			System.err.println(ExceptionUtils.getStackTrace(e));
			session = getSessionFactory().openSession();
		}
		return session;
	}

	public final SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public final void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
