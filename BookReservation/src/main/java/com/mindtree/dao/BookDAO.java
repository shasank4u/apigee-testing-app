package com.mindtree.dao;


import java.util.Date;
import java.util.List;

import com.mindtree.entity.Book;
import com.mindtree.exception.DaoException;
/**
 * 
 * @author spulipaka
 *
 */

public interface BookDAO  {

	public void addBook(Book book) throws DaoException;
	public void deleteBook(Book book) throws DaoException;
	public Book findById(Integer Id) throws DaoException;
	public List<Book> findAllByDate(Date referenceDate) throws DaoException;
	public List<Book> findAllByBetweenDates(Date startDate, Date endDate) throws DaoException;
	public List<Book> findAllByExpirationDate(Date expirationDt) throws DaoException;
	public List<Book> findAllByExpirationBetweenDate(Date startDate, Date endDate) throws DaoException;
}
