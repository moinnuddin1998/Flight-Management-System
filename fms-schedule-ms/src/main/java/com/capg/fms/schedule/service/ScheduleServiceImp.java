package com.capg.fms.schedule.service;

import java.time.LocalDateTime;
import java.util.Random;

import javax.print.attribute.standard.SheetCollate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capg.fms.schedule.exceptions.ScheduleAlreadyExistsException;
import com.capg.fms.schedule.exceptions.ScheduledFlightNotFoundException;
import com.capg.fms.schedule.model.Airport;
import com.capg.fms.schedule.model.Schedule;
import com.capg.fms.schedule.model.ScheduledFlight;
import com.capg.fms.schedule.model.ScheduledFlightList;
import com.capg.fms.schedule.repo.IScheduleRepo;

@Service
public class ScheduleServiceImp implements IScheduleService {

	@Autowired
	IScheduleRepo repo;
	
	
	
	  @Autowired RestTemplate restTemplate;
	 

	
	@Override
	public ScheduledFlight addScheduleFlight(ScheduledFlight scheduledFlight) {
		ScheduledFlight scheduled=new ScheduledFlight();
		Schedule sch = new Schedule();
		//schedule.setScheduledFlightId(Integer.parseInt((String.valueOf(Math.abs(new Random().nextLong())).substring(0, 6))));
		//schedule.getSchedule().setArrivalTime(LocalDateTime.now());

		
		  String sourceAirportName = scheduledFlight.getSchedule().getSourceAirport();
		  String destinationAirportName =
		  scheduledFlight.getSchedule().getDestinationAirport();
		  
		  Airport sourceAirport =restTemplate.getForObject("http://localhost:8089/airport/airportname/" +sch.getSourceAirport(), Airport.class);
		  Airport destinationAirport = restTemplate.getForObject("http://localhost:8089/airport/airportname/" +destinationAirportName, Airport.class);
			
		//	 String name=sourceAirport.getAirportName();
	//	 String name1 = destinationAirport.getAirportName();
		//	 sch.setSourceAirport(name);
		//	  scheduled.setSchedule(sch); 
			//  sch.setDestinationAirport(name1);
			//  scheduled.setSchedule(sch);
			 		  if (repo.existsById(scheduledFlight.getScheduledFlightId())) {
		  
		  throw new ScheduleAlreadyExistsException("ScheduledFlightId already exists");
		  
		  }
		 
		
		return repo.save(scheduledFlight);
	}

	@Override
	public ScheduledFlight viewScheduledFlight(int scheduleId) {

		if (!repo.existsById(scheduleId)) {
			throw new ScheduledFlightNotFoundException("Scheduled Flight not found");
		}
		return repo.findById(scheduleId).get();
	}

	@Override
	public ScheduledFlightList viewScheduledFlights() {

		return new ScheduledFlightList(repo.findAll());
	}

	@Override
	public void deleteScheduledFlight(int scheduledFlightId) {
		if (!repo.existsById(scheduledFlightId)) {
			
		
			
			throw new ScheduledFlightNotFoundException("Scheduled Flight not found");
			
		}
	repo.deleteById(scheduledFlightId);
	}
		

	

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
