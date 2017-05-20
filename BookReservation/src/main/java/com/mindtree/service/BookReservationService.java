package com.mindtree.service;



import java.util.Date;
import java.util.List;

import com.mindtree.entity.Book;
import com.mindtree.entity.Reservation;
import com.mindtree.exception.ServiceException;

/**
 * 
 * @author spulipaka
 *
 */

public interface BookReservationService {
	/**
	 * adds new book to the data base 
	 * @param book
	 * @throws ServiceException 
	 */
	void addBook(Book book) throws ServiceException;
	
	/**
	 * deletes the the book 
	 * @param book
	 * @throws ServiceException
	 */
	
	void deleteBook(Book book) throws ServiceException;
	
	/**
	 * gets the object from hibernate session 
	 * @param Id
	 * @return
	 * @throws SecurityException
	 */
	Book findById(Integer Id) throws ServiceException;
	
	/**
	 * adds new book reservation 
	 * @param reservation
	 * @throws ServiceException
	 */
	void addNewReserVation(Reservation  reservation) throws ServiceException;
	
	/**
	 * gets all the books reserved on that date 
	 * @param reservationDate
	 * @return
	 * @throws ServiceException 
	 */
	
	List<Book> getAllBookByReservationDt(Date reservationDate) throws ServiceException;
	
	
	/**
	 * gets all the books reserved between the dates
	 * @param reservationDate
	 * @return
	 * @throws ServiceException 
	 */
	
	List<Book> getAllBookBetweenDts(Date startDate, Date endDate) throws ServiceException;
	/**
	 * gets all the books of expiration date
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws ServiceException
	 */
	
	List<Book> getAllBookByExpirationDt(Date expirationDate) throws ServiceException;
	
	/**
	 * gets all the books expired between the dates
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws ServiceException
	 */
	
	List<Book> getAllBooksByExpirationBetweenDates(Date startDate, Date endDate) throws ServiceException;
	
}
