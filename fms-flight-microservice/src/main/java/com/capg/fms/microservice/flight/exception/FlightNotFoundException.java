package com.capg.fms.microservice.flight.exception;

public class FlightNotFoundException extends RuntimeException {

	public FlightNotFoundException(String message) {
		super(message);
	}
	
}
