package com.capg.fms.passenger.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.ALREADY_REPORTED,reason = "Passenger Already Exist",value = HttpStatus.ALREADY_REPORTED)
public class PassengerAlreadyExistException  extends RuntimeException {
	public PassengerAlreadyExistException(String message)
	{
		super(message);
	}
}
