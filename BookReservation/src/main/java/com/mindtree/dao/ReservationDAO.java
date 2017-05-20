package com.mindtree.dao;


import com.mindtree.entity.Reservation;
import com.mindtree.exception.DaoException;

/**
 * 
 * @author spulipaka
 *
 */
public interface ReservationDAO {
	public void addNewReservation(Reservation reservation) throws DaoException;

}
