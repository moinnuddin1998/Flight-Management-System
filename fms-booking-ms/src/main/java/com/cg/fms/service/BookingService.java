package com.cg.fms.service;

import java.math.BigInteger;
import java.util.List;

import com.cg.fms.dto.Booking;
import com.cg.fms.dto.Passenger;
import com.cg.fms.exception.InvalidBookingException;


/**
 * @author nitesh
 *
 */
public interface BookingService {
	
		
		public abstract Booking addBooking(Booking booking) throws InvalidBookingException;
		
		public abstract Booking modifyBooking(Booking booking) throws InvalidBookingException;
		
		public abstract Booking viewBooking(BigInteger bookingId) throws InvalidBookingException;
		
		public abstract List<Booking> viewBookingbyUserId(BigInteger userId) throws InvalidBookingException;
		
		public abstract void cancelBooking(BigInteger bookingId) throws InvalidBookingException;
		
		public abstract void validateBooking(Booking booking) throws InvalidBookingException;
		
		public abstract void validatePassenger(Passenger passenger) throws InvalidBookingException;

}
