package com.capg.fms.passenger.service;

import com.capg.fms.passenger.model.Passenger;
import com.capg.fms.passenger.model.PassengerList;

public interface PassengerService {
	

	Passenger addPassenger(Passenger passenger);
    boolean deletePassenger(long passengerNumber);
	Passenger getPassenger(long passengerNumber);
	PassengerList getAllPassengers();
	Passenger updatePassenger(Passenger passenger);
	public long getCountOfPassenger();
	
	boolean validatePassengerName(String passengerName);
	boolean validatePassengerNumber(long passengerNumber);
	boolean validatePassengerAge(int passengerAge);
	boolean validatePassengerUIN(long passengerUIN);
	
	
	
	
	
	
	
}