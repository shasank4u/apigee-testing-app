package com.mindtree.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.dao.BookDAO;
import com.mindtree.dao.ReservationDAO;
import com.mindtree.entity.Book;
import com.mindtree.entity.Reservation;
import com.mindtree.exception.DaoException;
import com.mindtree.exception.ServiceException;

/**
 * 
 * @author spulipaka
 *
 */

@Service
public  class BookReservationServiceImpl implements BookReservationService {
	
	@Autowired
	private BookDAO bookDAO;
	
	@Autowired
	private ReservationDAO reservationDAO;
	
	@Override
	public void addBook(Book book) throws ServiceException {
		
		try {
			bookDAO.addBook(book);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(),e);		
	}

}

	@Override
	public void deleteBook(Book book) throws ServiceException {
		try {
			bookDAO.deleteBook(book);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(),e);	
		}
	}

	@Override
	public Book findById(Integer Id) throws ServiceException {
		
		try {
			return bookDAO.findById(Id);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(),e);
		}
	}

	@Override
	public void addNewReserVation(Reservation reservation) throws ServiceException {
		try {
			reservationDAO.addNewReservation(reservation);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(),e);
		}
		
	}

	@Override
	public List<Book> getAllBookByReservationDt(Date reservationDate) throws ServiceException {
		
		try {
			return bookDAO.findAllByDate(reservationDate);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(),e);
		}
	}

	@Override
	public List<Book> getAllBookBetweenDts(Date startDate, Date endDate) throws ServiceException {
		
		try {
			return bookDAO.findAllByBetweenDates(startDate, endDate);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(),e);
		}
	}

	@Override
	public List<Book> getAllBookByExpirationDt(Date expirationDt) throws ServiceException {
		
		try {
			return bookDAO.findAllByExpirationDate(expirationDt);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(),e);
		}
	}

	@Override
	public List<Book> getAllBooksByExpirationBetweenDates(Date startDate, Date endDate) throws ServiceException {
		
		try {
			return bookDAO.findAllByExpirationBetweenDate(startDate, endDate);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(),e);
		}
	}
}