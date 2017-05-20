package com.mindtree.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


/**
 * 
 * @author spulipaka
 *
 */
@Entity
@Table( name = "book_reservation") 
public class Reservation {
	
	private Integer id; 
	private Book book;
	private Integer visitorId;
	private Date reservationDate;
	private Date expirationDate;
	
	
	
	@GenericGenerator(name = "generator", strategy = "identity")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false) 
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
	
	@Column(name = "visitor_id",nullable = false) 
	public Integer getVisitorId() {
		return visitorId;
	}
	public void setVisitorId(Integer visitorId) {
		this.visitorId = visitorId;
	}
	
	@Column(name = "reservation_date",nullable = false) 
	public Date getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}
	
	@Column(name = "expiration_date",nullable = false)
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + ((expirationDate == null) ? 0 : expirationDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((reservationDate == null) ? 0 : reservationDate.hashCode());
		result = prime * result + ((visitorId == null) ? 0 : visitorId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (expirationDate == null) {
			if (other.expirationDate != null)
				return false;
		} else if (!expirationDate.equals(other.expirationDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (reservationDate == null) {
			if (other.reservationDate != null)
				return false;
		} else if (!reservationDate.equals(other.reservationDate))
			return false;
		if (visitorId == null) {
			if (other.visitorId != null)
				return false;
		} else if (!visitorId.equals(other.visitorId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Reservation [id=" + id + ", visitorId=" + visitorId + ", reservationDate=" + reservationDate
				+ ", expirationDate=" + expirationDate + "]";
	}
	
	
	

}
