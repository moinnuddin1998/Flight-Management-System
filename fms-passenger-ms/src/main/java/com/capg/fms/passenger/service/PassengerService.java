package com.capg.fms.passenger.service;



import com.capg.fms.passenger.model.Passenger;
import com.capg.fms.passenger.model.PassengerList;

/****************************************************************************************************************************
- File Name        : IPassengerService.java 
- Author           : Capgemini 
- Creation Date    : 11/08/2020
- Modified Date    : 15/08/2020
****************************************************************************************************************************/

public interface PassengerService {

	Passenger addPassenger(Passenger passenger);

	boolean deletePassenger(long passengerNum);

	Passenger getPassenger(long passengerNum);

	PassengerList getAllPassengers();

	Passenger updatePassenger(Passenger passenger);

	boolean validatePassengerUIN(long passengerUIN);

	boolean validatePassengerNumber(long passengerNum);

	boolean validatePassengerName(String passengerName);

	boolean validatePassengerAge(int passengerAge);
	
	boolean validateLuggage(int luggage);
}
