package com.capg.fms.schedule.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capg.fms.schedule.exceptions.ScheduledFlightNotFoundException;
import com.capg.fms.schedule.model.ErrorResponse;


@RestControllerAdvice
public class ScheduleErrorController {

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = { ScheduledFlightNotFoundException.class })
	public ErrorResponse handleStudentAlreadyExistsException(Exception ex, HttpServletRequest req) {

		return new ErrorResponse(new Date(), ex.getMessage(), HttpStatus.BAD_REQUEST.getReasonPhrase(),
				HttpStatus.BAD_REQUEST.value(), req.getRequestURL().toString());

	}

	
}
