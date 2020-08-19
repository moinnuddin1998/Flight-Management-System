package com.capg.fms.schedule.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capg.fms.schedule.exceptions.ScheduledFlightNotFoundException;


@ControllerAdvice
@RestController
public class ScheduleErrorController {

	@ExceptionHandler(ScheduledFlightNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "Scheduled Flight Not Found",code = HttpStatus.NOT_FOUND)
	public void ScheduleNotFoundException() {
		
		
		
	}
	
}
