package com.cg.fms.exception;

/**
 * @author nitesh
 *
 */
public class InvalidBookingException extends Exception{
	
	
	private static final long serialVersionUID = 1L;
	
	public InvalidBookingException(){
	}
	
	public InvalidBookingException(String message){
		super(message);
	}

}