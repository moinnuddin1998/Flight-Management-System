package com.capg.fms.passenger.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.fms.passenger.exceptions.InvalidInputException;
import com.capg.fms.passenger.exceptions.PassengerAlreadyExistException;
import com.capg.fms.passenger.exceptions.PassengerNotFoundException;
import com.capg.fms.passenger.model.Passenger;
import com.capg.fms.passenger.model.PassengerList;
import com.capg.fms.passenger.repository.PassengerRepo;
@Service
public class PassengerServiceImpl implements PassengerService {
	
	@Autowired
	PassengerRepo passengerRepo;

	@Override
	@Transactional
     public Passenger addPassenger(Passenger passenger) {
			
			  if(passengerRepo.existsById(passenger.getPassengerNumber())) { throw new
			  PassengerAlreadyExistException("Passenger with Number: "
			  +passenger.getPassengerNumber()+" is already exist"); }
			 
		return passengerRepo.save(passenger);
	}

	@Override
	@Transactional
	public boolean deletePassenger(long passengerNumber) {
		
		
		if(!passengerRepo.existsById(passengerNumber)) 
		{	
		   throw new PassengerNotFoundException("Passenger with Num "+passengerNumber+" Not Found");
		}
		
		passengerRepo.deleteById(passengerNumber);
		
		return !passengerRepo.existsById(passengerNumber);
	}
	
	@Override
	@Transactional
	public Passenger getPassenger(long passengerNumber) {
		
		
		if(!passengerRepo.existsById(passengerNumber)) 
		{	
		   throw new PassengerNotFoundException("Passenger with Num "+passengerNumber+" Not Found");
		}
		
		return passengerRepo.getOne(passengerNumber);
	}

	@Override
	@Transactional
	public PassengerList getAllPassengers() {
	
		return new PassengerList(passengerRepo.findAll());
	}
	
	@Override
	@Transactional
	public Passenger updatePassenger(Passenger passenger) {
		if(!passengerRepo.existsById(passenger.getPassengerNumber()))
			throw new PassengerNotFoundException("Passenger with Num : " +passenger.getPassengerNumber()+" Not Found");
	
		
		Passenger newPassenger=passengerRepo.getOne(passenger.getPassengerNumber());
		
		newPassenger.setPassengerName(passenger.getPassengerName());
		newPassenger.setPassengerAge(passenger.getPassengerAge());
		newPassenger.setPassengerUIN(passenger.getPassengerUIN());
		newPassenger.setLuggage(passenger.getLuggage());

	passengerRepo.save(newPassenger);
		return newPassenger;	
	}
	

	@Override
	@Transactional
	public long getCountOfPassenger() {
		
		return passengerRepo.count();
	}

	@Override
	@Transactional
	public boolean validatePassengerName(String passengerName) {	
		if (!passengerName.matches("[a-zA-Z]+")) {
			throw new InvalidInputException("Name should contain alphabets only");
			}
	        return true;
	}

	@Override
	@Transactional
	public boolean validatePassengerNumber(long passengerNumber) {
		
		
		
      String str = Long.toString(passengerNumber);
  	
		if (!(str.length() == 10 && str.charAt(0) != 0)) {
			throw new InvalidInputException("Passenger number should be of 10 digits");
		}
		
		
		return true;
	}

	@Override
	@Transactional
	public boolean validatePassengerAge(int passengerAge) {
		String age =  Long.toString(passengerAge);
		if (!(age.length() == 2 && age.charAt(0) != 0)) {
			throw new InvalidInputException("Age should be between 10 and 99 only ");
		}
		
		
		return true;
	}

	@Override
	public boolean validatePassengerUIN(long passengerUIN) {
		String str = Long.toString(passengerUIN);
		if (!(str.length() == 12 && str.charAt(0) != 0)) {
			throw new InvalidInputException("Passenger UIN should be of 12 digits");
		}
		return true;
	}

	
}
