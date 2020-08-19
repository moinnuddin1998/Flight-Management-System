package com.capg.fms.microservice.flight.service;

import java.util.List;

import com.capg.fms.microservice.flight.model.FlightBean;

public interface IFlightService {
	
	
	public FlightBean addFlight(FlightBean flight);
	
	public void deleteFlight(long flightNumber);
	
	public List<FlightBean> getAllFlights();
	
	 public FlightBean getFlightById(long flightNumber);
	 
	 public FlightBean modifyFlight(FlightBean flight);

}
