package com.capg.fms.passenger.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.capg.fms.passenger.exceptions.EmptyPassengerListException;
import com.capg.fms.passenger.exceptions.InvalidInputException;
import com.capg.fms.passenger.exceptions.PassengerAlreadyExistException;
import com.capg.fms.passenger.exceptions.PassengerNotFoundException;
import com.capg.fms.passenger.model.Passenger;
import com.capg.fms.passenger.model.PassengerList;
import com.capg.fms.passenger.repository.PassengerRepo;

/****************************************************************************************************************************
- File Name        : PassengerServiceImpl.java 
- Author           : Capgemini 
- Creation Date    : 11/08/2020
- Modified Date    : 17/08/2020
****************************************************************************************************************************/

@Service
@Transactional
public class PassengerServiceImpl implements PassengerService {

	@Autowired
	PassengerRepo passengerRepo;
	
	

	Logger logger = LoggerFactory.getLogger(PassengerServiceImpl.class);
	
	/****************************************************************************************************************************
	  - Method Name         : addPassenger
	  - Author              : Capgemini 
	  - Creation Date       : 11/08/2020
	  - Description         : Method to add Passenger
	 ****************************************************************************************************************************/
	
	@Override
	public Passenger addPassenger(Passenger passenger) {
		if (passengerRepo.existsById(passenger.getPassengerNum())) {
			throw new PassengerAlreadyExistException(
					"Passenger with Number: " + passenger.getPassengerNum() + " is Already Exist");
			}
		
		logger.info("Passenger Added Successfully");
		return passengerRepo.save(passenger);
	}

	/****************************************************************************************************************************
	  - Method Name         : deletePassenger
	  - Author              : Capgemini 
	  - Creation Date       : 13/08/2020
	  - Description         : Method to delete Passenger
	 ****************************************************************************************************************************/
	
	@Override
	public boolean deletePassenger(long passengerNum) {
		if (!passengerRepo.existsById(passengerNum)) {
			throw new PassengerNotFoundException("Passenger with Number " + passengerNum + " Not Found");
		}
		
		passengerRepo.deleteById(passengerNum);
		logger.info("Passenger Deleted Successfully");
		return !passengerRepo.existsById(passengerNum);
	}

	/****************************************************************************************************************************
	  - Method Name         : getPassenger
	  - Author              : Capgemini 
	  - Creation Date       : 15/08/2020
	  - Description         : Method to get passenger details
	 ****************************************************************************************************************************/
	
	@Override
	public Passenger getPassenger(long passengerNum) {
		if (!passengerRepo.existsById(passengerNum)) {
			throw new PassengerNotFoundException("Passenger with Number " + passengerNum + " Not Exist");
		}
		logger.info("Passenger details of" + passengerNum +"are shown");
		return passengerRepo.getOne(passengerNum);

	}

	/****************************************************************************************************************************
	  - Method Name         : getAllPassengers
	  - Author              : Capgemini 
	  - Creation Date       : 12/08/2020
	  - Description         : Method to get List of all Passengers
	 ****************************************************************************************************************************/
	
	@Override
	public PassengerList getAllPassengers() {
		if (passengerRepo.count() == 0) {
			throw new EmptyPassengerListException("No Passenger Found in Passenger Database");
		}
		
		logger.info("Passenger List is shown");
		return new PassengerList(passengerRepo.findAll());
	}

	/****************************************************************************************************************************
	  - Method Name         : updatePassenger
	  - Author              : Capgemini 
	  - Creation Date       : 14/08/2020
	  - Description         : Method to Update Passenger
	 ****************************************************************************************************************************/
	
	@Override
	public Passenger updatePassenger(Passenger passenger) {
		if (!passengerRepo.existsById(passenger.getPassengerNum())) {
			throw new PassengerNotFoundException(
					"Passenger with Number : " + passenger.getPassengerNum() + " Not Present");}
		
		Passenger newPassenger = passengerRepo.getOne(passenger.getPassengerNum());
		newPassenger.setPassengerName(passenger.getPassengerName());
		newPassenger.setPassengerAge(passenger.getPassengerAge());
		newPassenger.setPassengerUIN(passenger.getPassengerUIN());
		newPassenger.setLuggage(passenger.getLuggage());

		passengerRepo.save(newPassenger);
		logger.info("Passenger Updated Successfully");
		return newPassenger;
	}

	/****************************************************************************************************************************
	  - Method Name         : valiadtePassengerNumber
	  - Author              : Capgemini 
	  - Creation Date       : 11/08/2020
	  - Description         : This method is used to validate Passenger Number
	 ****************************************************************************************************************************/
	
	@Override
	public boolean validatePassengerNumber(long passengerNum) {
		String s = Long.toString(passengerNum);
		if (!(s.length() == 10 && s.charAt(0) != 0)) {
			throw new InvalidInputException("Passenger number should be of 10 digits");
		}
		return true;
	}

	/****************************************************************************************************************************
	  - Method Name         : validatePassengerUIN
	  - Author              : Capgemini 
	  - Creation Date       : 11/08/2020
	  - Description         : This method is used to validate Passenger UIN
	 ****************************************************************************************************************************/
	
	@Override
	public boolean validatePassengerUIN(long passengerUIN) {
		String s = Long.toString(passengerUIN);
		if (!(s.length() == 12 && s.charAt(0) != 0)) {
			throw new InvalidInputException("Passenger UIN should be of 12 digits");
		}
		return true;
	}

	/****************************************************************************************************************************
	  - Method Name         : validatePassengerName
	  - Author              : Capgemini 
	  - Creation Date       : 11/08/2020
	  - Description         : This method is used to Validate Passenger Name
	 ****************************************************************************************************************************/
	
	@Override
	public boolean validatePassengerName(String passengerName) {
		if (!passengerName.matches("[a-zA-Z]+")) {
			throw new InvalidInputException("Name should contain alphabets only");
		}
		return true;
	}
	/****************************************************************************************************************************
	  - Method Name         : validatePassengerAge
	  - Author              : Capgemini 
	  - Creation Date       : 11/08/2020
	  - Description         : This method is used to validate Passenger Age
	 ****************************************************************************************************************************/
	

	@Override
	public boolean validatePassengerAge(int passengerAge) {
		String age = Integer.toString(passengerAge);
		if (!(age.length() == 2 && age.charAt(0) != 0)) {
			throw new InvalidInputException("Age should be between 10 and 99 only ");
		}
		return true;
	}

	/****************************************************************************************************************************
	  - Method Name         : validateLuggage
	  - Author              : Capgemini 
	  - Creation Date       : 11/08/2020
	  - Description         : This method is used to validate Passenger Luggage
	 ****************************************************************************************************************************/
	
	@Override
	public boolean validateLuggage(int luggage) {
		String age = Integer.toString(luggage);
		if (!(age.length() == 1 && age.charAt(0) != 0)) {
			throw new InvalidInputException("Luggage should be between 1kg to 9 kgs only ");
		}
		return true;

	}
}
