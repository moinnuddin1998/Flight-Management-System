package com.capg.fms.microservice.flight.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.fms.microservice.flight.exception.FlightAlreadyExistException;
import com.capg.fms.microservice.flight.exception.FlightNotFoundException;
import com.capg.fms.microservice.flight.exception.InvalidInputException;
import com.capg.fms.microservice.flight.model.FlightBean;
import com.capg.fms.microservice.flight.repo.FlightRepo;
@Service
public class FlightServiceImpl implements IFlightService {
	
	@Autowired
	
	FlightRepo  flightRepo;
	
	@Override
	@Transactional
	 public FlightBean addFlight (FlightBean flight) {
		  System.out.println(flight);
		  if(flightRepo.existsById(flight.getFlightNumber())) {
			 throw new FlightAlreadyExistException("Flight Already Exits");
		  }
		 return flightRepo.save(flight);
	  }	
	@Override
	public void deleteFlight(long flightNumber) {
		 if(!flightRepo.existsById(flightNumber)) {
			 throw new FlightNotFoundException("flightNumber with "+flightNumber+" is NOT FOUND");
		 }
		 flightRepo.deleteById(flightNumber);
	 }

	@Override
	public List<FlightBean> getAllFlights() {
		// TODO Auto-generated method stub
		return flightRepo.findAll();
	}

	@Override
	public FlightBean getFlightById(long flightNumber) {
			// TODO Auto-generated method stub
			if (!flightRepo.existsById(flightNumber)) {
				throw new FlightNotFoundException(" Flight not found");
			}
			return flightRepo.findById(flightNumber).get();
		}

	public FlightBean modifyFlight(FlightBean flight) {
		if(!flightRepo.existsById(flight.getFlightNumber()))
			throw new FlightNotFoundException("flight with Num : " +flight.getFlightNumber()+" Not Found");
	
		FlightBean newFlight=flightRepo.getOne(flight.getFlightNumber());
		
		newFlight.setFlightModel(flight.getFlightModel());
		newFlight.setCarrierName(flight.getCarrierName());
		newFlight.setSeatCapacity(flight.getSeatCapacity());
		

	flightRepo.save(newFlight);
		return newFlight;	
	}
	
		
	}

	
	


