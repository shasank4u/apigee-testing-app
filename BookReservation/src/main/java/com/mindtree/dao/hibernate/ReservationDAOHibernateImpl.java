package com.mindtree.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.mindtree.dao.ReservationDAO;
import com.mindtree.entity.Reservation;
import com.mindtree.exception.DaoException;

@Repository
public class ReservationDAOHibernateImpl extends GenericDaoHibernateImpl<Reservation, Integer> implements ReservationDAO {

	@Override
	public void addNewReservation(Reservation reservation) throws DaoException {
		addEntity(reservation);

	}

}
