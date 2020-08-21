package com.capg.fms.microservice.flight.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capg.fms.microservice.flight.model.Flight;
import com.capg.fms.microservice.flight.service.FlightServiceImpl;

@RestController
@RequestMapping("/flight")
public class FightController {
	@Autowired
	FlightServiceImpl flightServiceImpl;
	 
	@PostMapping("/add")
	@ResponseStatus(code=HttpStatus.CREATED)
     public Flight addFlight(@RequestBody Flight flight)throws Exception{
		return flightServiceImpl.addFlight(flight);
	}
	@DeleteMapping("/deleteById/{flightNumber}")
	public String Flight (@PathVariable long flightNumber) throws Exception{
		flightServiceImpl.deleteFlight(flightNumber);
		return "your flight is deleted successfully" ;
	}
	
	@PutMapping("/modify")
	public Flight modifyFlight(@RequestBody Flight flight) throws Exception{
		return flightServiceImpl.modifyFlight(flight);
	}
	@GetMapping("/all")
	public List<Flight> getAllFlight() throws Exception{
		return flightServiceImpl.getAllFlights();
	}
	@GetMapping("/get/flightNumber/{flightNumber}")
	public Flight getFlightById(@PathVariable("flightNumber") long flightNumber) throws Exception{
		return flightServiceImpl.getFlightById(flightNumber);
	}
	@ExceptionHandler(Exception.class)
	public String inValid(Exception e) {
		return e.getMessage();  
	}

}