package com.mindtree.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.mindtree.entity.Book;
import com.mindtree.entity.Reservation;
import com.mindtree.exception.ServiceException;
import com.mindtree.service.BookReservationService;





@RestController
public class BookReservationController {
	
	@Autowired
	private BookReservationService bookReservationService;
	
	
	@RequestMapping(value = "/getBookByReserveDt/{reservationDate}", method = RequestMethod.GET)
    public ResponseEntity<List<Book>> listAllBooksByReservationDate(@PathVariable("reservationDate") String reservationDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		List<Book> books = new ArrayList<>();
		 try {
			Date reservationDt = formatter.parse(reservationDate);
			books = bookReservationService.getAllBookByReservationDt(reservationDt);
		} catch (ParseException | ServiceException e) {
			e.printStackTrace();
			 return new ResponseEntity<List<Book>>(books, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
        
        if(books!=null && books.isEmpty()){
            return new ResponseEntity<List<Book>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
    }
	
	
	@RequestMapping(value = "/getBookByBetweenRsvDt", method = RequestMethod.GET)
    public ResponseEntity<List<Book>> listAllBooksBetweenReservationDate( @RequestParam(value = "startDate", required = true) String startDate,
            @RequestParam(value = "endDate", required = true) String endDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		List<Book> books = new ArrayList<>();
		 try {
			Date stDate = formatter.parse(startDate);
			Date enDate = formatter.parse(endDate);
			books = bookReservationService.getAllBookBetweenDts(stDate, enDate);
		} catch (ParseException | ServiceException e) {
			e.printStackTrace();
			 return new ResponseEntity<List<Book>>(books, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
        
        if(books!=null && books.isEmpty()){
            return new ResponseEntity<List<Book>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/getBookByExpirationDt/{expirationDt}", method = RequestMethod.GET)
    public ResponseEntity<List<Book>> listAllBooksByExpirationDate(@PathVariable("expirationDt") String expirationDt) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		List<Book> books = new ArrayList<>();
		 try {
			Date expDate = formatter.parse(expirationDt);
			books = bookReservationService.getAllBookByExpirationDt(expDate);
		} catch (ParseException | ServiceException e) {
			e.printStackTrace();
			 return new ResponseEntity<List<Book>>(books, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
        
        if(books!=null && books.isEmpty()){
            return new ResponseEntity<List<Book>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
    }
	
	
	@RequestMapping(value = "/getBookByBetweenExpDt", method = RequestMethod.GET)
    public ResponseEntity<List<Book>> listAllBooksBetweenExpirationDate( @RequestParam(value = "startDate", required = true) String startDate,
            @RequestParam(value = "endDate", required = true) String endDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		List<Book> books = new ArrayList<>();
		 try {
			Date stDate = formatter.parse(startDate);
			Date enDate = formatter.parse(endDate);
			books = bookReservationService.getAllBooksByExpirationBetweenDates(stDate, enDate);
		} catch (ParseException | ServiceException e) {
			e.printStackTrace();
			 return new ResponseEntity<List<Book>>(books, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
        
        if(books!=null && books.isEmpty()){
            return new ResponseEntity<List<Book>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
    }
	
	   @RequestMapping(value = "/addBook", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<List<Book>> addBook(@RequestBody  List<Book> books) {
		  
		   if(books != null && !books.isEmpty()){
			   for (Book book : books){
				   try {
					bookReservationService.addBook(book);
				} catch (ServiceException e) {
					 return new ResponseEntity<List<Book>>(books, HttpStatus.INTERNAL_SERVER_ERROR);
				}
			   }
		   }
	      
	        return new ResponseEntity<List<Book>>(books, HttpStatus.OK);	     
	    }
	   
	   @RequestMapping(value = "/deleteBook", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	   @ResponseBody
	    public String deleteBook(@RequestBody  List<Book> books) {
		   HashMap<Object, String> result = new HashMap<>();
		   if(books != null && !books.isEmpty()){
			   for (Book book : books){
				   try {
					if(book != null && book.getId() != null){
						Book persistedBook = bookReservationService.findById(book.getId());
						bookReservationService.deleteBook(persistedBook);
					}
					
					result.put(book, "Deleted Successfully");
				} catch (ServiceException e) {
					result.put(book, "Failed To Delete");
					new Gson().toJson(result);
				}
			   }
		   }
	      
	        return new Gson().toJson(result);	     
	    }
	   
	   
	   @RequestMapping(value = "/addReservation", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	   @ResponseBody
	    public String addReservation(@RequestBody  List<Reservation> reservations) {
		HashMap<String, String> result = new HashMap<>();
		if (reservations != null && !reservations.isEmpty()) {
			for (Reservation reservation : reservations) {
				try {
					if(reservation.getVisitorId() !=null){
					reservation.setReservationDate(new Date());
					reservation.setExpirationDate(DateUtils.addDays(new Date(), 7));
					bookReservationService.addNewReserVation(reservation);
					result.put(reservation.toString(), "Added Successfully");
					}else {
						result.put(reservation.toString(), "Visitor Id is null ");
						return new Gson().toJson(result);
					}
						
				} catch (ServiceException e) {
					result.put(reservation.toString(), "Failed to add");
					return new Gson().toJson(result);
				}
			}
		}

		return new Gson().toJson(result);
	    }
   
	  
}
