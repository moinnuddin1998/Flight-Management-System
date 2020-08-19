package com.capg.fms.microservice.flight.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capg.fms.microservice.flight.exception.FlightAlreadyExistException;
import com.capg.fms.microservice.flight.exception.FlightNotFoundException;

@ControllerAdvice
@RestController
public class FlightErrorController {

	@ExceptionHandler(FlightNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = " Flight Not Found", code = HttpStatus.NOT_FOUND)
	public void ScheduleNotFoundException() {

	}
	@ExceptionHandler(com.capg.fms.microservice.flight.exception.InvalidInputException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = " InvalidInputexception")
	public void InvalidInputException() {
		
	}

	@ExceptionHandler(FlightAlreadyExistException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = " Flight Already Exists")
	public void scheduleAlreadyExistsException() {
		
	}
	
}