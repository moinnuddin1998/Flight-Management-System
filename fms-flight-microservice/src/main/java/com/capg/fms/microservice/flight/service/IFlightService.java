package com.capg.fms.microservice.flight.service;

import java.util.List;

import com.capg.fms.microservice.flight.model.Flight;

public interface IFlightService {
	
	
	public Flight addFlight(Flight flight);
	
	public void deleteFlight(long flightNumber);
	
	public List<Flight> getAllFlights();
	
	 public Flight getFlightById(long flightNumber);
	 
	 public Flight modifyFlight(Flight flight);

}
