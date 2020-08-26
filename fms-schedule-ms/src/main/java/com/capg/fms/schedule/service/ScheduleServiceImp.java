package com.capg.fms.schedule.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capg.fms.schedule.exceptions.ScheduleAlreadyExistsException;
import com.capg.fms.schedule.exceptions.ScheduledFlightNotFoundException;
import com.capg.fms.schedule.model.Flight;
import com.capg.fms.schedule.model.Schedule;
import com.capg.fms.schedule.model.ScheduledFlight;
import com.capg.fms.schedule.model.ScheduledFlightList;
import com.capg.fms.schedule.repo.IScheduleRepo;
/***************************************************************
-Author                : Nagendra 
-Created/Modified Date : 15/08/2020
-Description           : ScheduleService class for 
						  Schedule Management system
*******************************************************************/
@Service
public class ScheduleServiceImp implements IScheduleService {

	@Autowired
	IScheduleRepo repo;

	@Autowired
	RestTemplate restTemplate;

	/**
	   * This method is used to process Add Schedule Flights. 
	   * @param  flightNumber,ScheduedFlight : A  variable and an object  
	   * @return String  : This returns String message,else else throws exception
	 **/
	@Override
	public ScheduledFlight addScheduleFlight(long flightNumber, ScheduledFlight scheduledFlight)
			throws ScheduleAlreadyExistsException, ScheduledFlightNotFoundException {

		Flight flightRest = restTemplate.getForObject("http://localhost:8090/flight/get/flightNumber/" + flightNumber,
				Flight.class);

		System.out.println(flightRest);
		if (flightNumber != flightRest.getFlightNumber()) {
			throw new ScheduledFlightNotFoundException("Flight NOt Found");
		}
		scheduledFlight.setFlightNumber(flightRest.getFlightNumber());

		scheduledFlight.getSchedule().setArrivalTime(LocalDateTime.now().minusHours(3));
		scheduledFlight.getSchedule().setDepartureTime(LocalDateTime.now());

		if (repo.existsById(scheduledFlight.getScheduledFlightId())) {

			throw new ScheduleAlreadyExistsException("ScheduledFlightId already exists");

		}

		return repo.save(scheduledFlight);
	}
	
	/**
	   * This method is used to  View Schedule Flight. 
	   * @param  Scheduled Flight Id : a variable  
	   * @return String  : returns that particualr Scheduled Flight
	 **/

	@Override
	public ScheduledFlight viewScheduledFlight(int scheduleId) {

		if (!repo.existsById(scheduleId)) {
			throw new ScheduledFlightNotFoundException("Scheduled Flight not found");
		}
		return repo.findById(scheduleId).get();
	}

	/**
	   * This method is used to  View Schedule Flights. 
	   * @return   : returns all the Scheduled flights from List 
	 **/
	
	@Override
	public ScheduledFlightList viewScheduledFlights() {

		return new ScheduledFlightList(repo.findAll());
	}

	/**
	   * This method is used to  Delete a Scheduled Flight. 
	   * @param  Scheduled Flight Id : a variable  
	   * @return String  : returns that particualr Scheduled Flight
	 **/
	
	@Override
	public void deleteScheduledFlight(int scheduledFlightId) {
		if (!repo.existsById(scheduledFlightId)) {

			throw new ScheduledFlightNotFoundException("Scheduled Flight not found");

		}
		repo.deleteById(scheduledFlightId);
	}

	/**
	   * This method is used to Modify a Scheduled Flight. 
	   * @param   : Variables present in Scheduled Flight  
	   * @return String  : returns that particualr Scheduled Flight
	 **/
	
	@Override
	public ScheduledFlight modifyScheduledFlight(int scheduledFlightId, int availableSeats, long flightNumber,
			Schedule schedule) {

		if (!repo.existsById(scheduledFlightId)) {
			throw new ScheduledFlightNotFoundException("Scheduled Flight not found");
		}
		ScheduledFlight scheduledFlight = repo.getOne(scheduledFlightId);
		scheduledFlight.setAvailableSeats(availableSeats);
		scheduledFlight.setFlightNumber(flightNumber);
		scheduledFlight.setSchedule(schedule);
		repo.save(scheduledFlight);

		return scheduledFlight;
	}

}
