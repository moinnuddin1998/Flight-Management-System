package com.capg.fms.microservice.flight.exception;

public class InvalidInputException extends RuntimeException {

	public InvalidInputException(String message) {
		super(message);
	}
}
