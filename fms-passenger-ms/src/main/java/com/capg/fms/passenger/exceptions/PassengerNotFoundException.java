package com.capg.fms.passenger.exceptions;


	import org.springframework.http.HttpStatus;
	import org.springframework.web.bind.annotation.ResponseStatus;

	@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "Passengeer Not Found", value = HttpStatus.NOT_FOUND)
	public class PassengerNotFoundException extends RuntimeException {
	public PassengerNotFoundException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}

	}

	
	
	
	

