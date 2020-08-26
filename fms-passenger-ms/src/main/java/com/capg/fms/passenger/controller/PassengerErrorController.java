package com.capg.fms.passenger.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capg.fms.passenger.exceptions.EmptyPassengerListException;
import com.capg.fms.passenger.exceptions.InvalidInputException;
import com.capg.fms.passenger.exceptions.PassengerNotFoundException;
import com.capg.fms.passenger.exceptions.PassengerAlreadyExistException;

/****************************************************************************************************************************
- File Name        : PassengerErrorController.java 
- Author           : Capgemini 
- Creation Date    : 11/08/2020
- Updated Date     : 13/08/2020
- Description      : This Controller class act as an end point to manage and handle the entire Exceptions
****************************************************************************************************************************/

@RestController
@ControllerAdvice
public class PassengerErrorController {

	/****************************************************************************************************************************
	  - Method Name         : handlePassengerAlreadyExistException
	  - Author              : Capgemini 
	  - Creation Date       : 11/08/2020
	  - Description         : This method handles the PassengerAlreadyExistException
	 ****************************************************************************************************************************/
	
	@ResponseStatus(code = HttpStatus.ALREADY_REPORTED, reason = "Passenger Already Exist", value = HttpStatus.ALREADY_REPORTED)
	@ExceptionHandler(PassengerAlreadyExistException.class)
	public void handlePassengerAlreadyExistException() {
//		To handle Passenger Already Exist Exception
	}

	/****************************************************************************************************************************
	  - Method Name         : handlePassengerNotFoundException
	  - Author              : Capgemini 
	  - Creation Date       : 13/08/2020
	  - Description         : This method handles the PassengerNotFoundException
	 ****************************************************************************************************************************/
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Passengeer Not Found", value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(PassengerNotFoundException.class)
	public void handlePassengerNotFoundException() {
//		To handle Passenger Not Found ExistException
	}

	/****************************************************************************************************************************
	  - Method Name         : handleEmptyPassengerListException
	  - Author              : Capgemini 
	  - Creation Date       : 12/08/2020
	  - Description         : This method handles the EmptyPassengerListException
	 ****************************************************************************************************************************/
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Passenger list is Empty", value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(EmptyPassengerListException.class)
	public void handleEmptyPassengerListException() {
//		To handle Empty Passenger List Exception
	}

	/****************************************************************************************************************************
	  - Method Name         : handleInvaliInputtException
	  - Author              : Capgemini 
	  - Creation Date       : 11/08/2020
	  - Description         : This method handles the handleInvaliInputtException
	 ****************************************************************************************************************************/
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Invalid input", value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidInputException.class)
	public void handleInvaliInputtException() {
//		to handle Invalid Input Exception
	}

}
