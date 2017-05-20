package com.mindtree.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.stereotype.Repository;

import com.mindtree.dao.GenericDAO;

import com.mindtree.exception.DaoException;

@Repository
public class GenericDaoHibernateImpl<T,ID> implements GenericDAO<T, ID> {
	
	@Autowired
	protected SessionFactory sessionFactory;

	@Override
	public void addEntity(T entity) throws DaoException {
		try {
			Session session = getSession();
			session.save(entity);
			session.flush();
		} catch (DataAccessException e) {
			throw new DaoException(e.getMessage(),e);
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getEntity(Class<?> clazz, ID id) throws DaoException {
		  return (T) clazz.cast(getSession().get(clazz, (Serializable) id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAllEntities(Class<?> clazz) throws DaoException {
		try {
			Query queryObject = getSession().createQuery("FROM " + clazz.getName());
			List<T> result = queryObject.list();
			return result;
		} catch (DataAccessException e) {
			throw new DaoException(e.getMessage(),e);
            
		}
	}

	@Override
	public List<T> getByQuery(String query) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Session getSession() throws HibernateException {
		
		return sessionFactory.openSession();
	}

	@Override
	public void delete(T entity) throws DaoException {
		
		try {
			Session session = getSession();

			session.evict(entity);
			session.delete(entity);
			session.flush();

		} catch (DataAccessException e) {

			throw new DaoException(e.getMessage(),e);
		}
		
	}



}
