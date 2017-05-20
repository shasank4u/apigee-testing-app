package com.mindtree.dao.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.dao.BookDAO;
import com.mindtree.entity.Book;
import com.mindtree.exception.DaoException;

@Repository
public class BookDAOHibernateImpl extends GenericDaoHibernateImpl<Book, Integer> implements BookDAO{

	@Override
	public void addBook(Book book) throws DaoException {
		addEntity(book);
		
	}

	@Override
	public void deleteBook(Book book) throws DaoException {
		delete(book);
		
	}

	@Override
	public Book findById(Integer Id) throws DaoException {
		return getEntity(Book.class, Id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> findAllByDate(Date referenceDate) throws DaoException {
		StringBuffer query = new StringBuffer(
		        "SELECT DISTINCT r.book FROM Reservation r "
		        + "WHERE   DATE_FORMAT(r.reservationDate, '%Y-%m-%d')  =  DATE_FORMAT(:referenceDate, '%Y-%m-%d') ");
		        

		Query q = getSession().createQuery(query.toString());
		q.setParameter("referenceDate", referenceDate);
		

		return q.list();
		
	}

	@Override
	public List<Book> findAllByBetweenDates(Date startDate, Date endDate) throws DaoException {
		StringBuffer query = new StringBuffer(
		        "SELECT DISTINCT r.book FROM Reservation r "
		        + "WHERE   DATE_FORMAT(r.reservationDate, '%Y-%m-%d')  between  DATE_FORMAT(:startDate, '%Y-%m-%d') AND   DATE_FORMAT(:endDate, '%Y-%m-%d')");
		        

		Query q = getSession().createQuery(query.toString());
		q.setParameter("startDate", startDate);
		q.setParameter("endDate", endDate);
		
		return q.list();
	}

	@Override
	public List<Book> findAllByExpirationDate(Date expirationDt) throws DaoException {
		StringBuffer query = new StringBuffer(
		        "SELECT DISTINCT r.book FROM Reservation r "
		        + "WHERE   DATE_FORMAT(r.expirationDate, '%Y-%m-%d')  =  DATE_FORMAT(:expirationDt, '%Y-%m-%d') ");
		        

		Query q = getSession().createQuery(query.toString());
		q.setParameter("expirationDt", expirationDt);
		return q.list();
	}

	@Override
	public List<Book> findAllByExpirationBetweenDate(Date startDate, Date endDate) throws DaoException {
		StringBuffer query = new StringBuffer(
		        "SELECT DISTINCT r.book FROM Reservation r "
		        + "WHERE   DATE_FORMAT(r.expirationDate, '%Y-%m-%d')  between  DATE_FORMAT(:startDate, '%Y-%m-%d') AND   DATE_FORMAT(:endDate, '%Y-%m-%d')");
		        

		Query q = getSession().createQuery(query.toString());
		q.setParameter("startDate", startDate);
		q.setParameter("endDate", endDate);
		
		return q.list();
		
	}

	

}
