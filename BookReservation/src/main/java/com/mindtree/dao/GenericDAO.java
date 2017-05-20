package com.mindtree.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.mindtree.exception.DaoException;

public interface GenericDAO<T, ID> {

	public void addEntity(T entity) throws DaoException;
	public T getEntity(Class<?> clazz,ID id) throws DaoException;
	public List<T> getAllEntities(Class<?> clazz) throws DaoException;
	public List<T> getByQuery(String query) throws DaoException;
	
	void delete(T entity) throws DaoException;
	

	
	 /**
     *
     * 
     * @return Session
     * @throws HibernateException
     */
     Session getSession() throws HibernateException;
}
