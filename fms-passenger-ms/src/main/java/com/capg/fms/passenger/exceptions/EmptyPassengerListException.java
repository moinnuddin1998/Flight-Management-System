package com.capg.fms.passenger.exceptions;



	
	
	import org.springframework.http.HttpStatus;
    import org.springframework.web.bind.annotation.ResponseStatus;

	@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "Passenger list is Empty", value = HttpStatus.NOT_FOUND)
	public class EmptyPassengerListException extends RuntimeException{
			public EmptyPassengerListException(String message)
		{
			super(message);
		}
	}

