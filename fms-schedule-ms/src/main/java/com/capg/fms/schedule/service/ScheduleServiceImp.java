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
import com.capg.fms.schedule.model.Flight;
import com.capg.fms.schedule.model.Schedule;
import com.capg.fms.schedule.model.ScheduledFlight;
import com.capg.fms.schedule.model.ScheduledFlightList;
import com.capg.fms.schedule.repo.IScheduleRepo;

@Service
public class ScheduleServiceImp implements IScheduleService {

	@Autowired
	IScheduleRepo repo;

	@Autowired
	RestTemplate restTemplate;

	@Override
	public ScheduledFlight addScheduleFlight(ScheduledFlight scheduledFlight) throws ScheduleAlreadyExistsException {

		
		  long flightNumber = scheduledFlight.getFlightNumber();
		  
		//  Flight flight =restTemplate.getForObject("http://localhost:8090/flight/get/flightNumber/" + flightNumber,Flight.class);
		  
		/*
		 * Flight flightRest =
		 * restTemplate.getForObject("http://localhost:8090/flight/get/flightNumber/"
		 * +flightNumber , Flight.class);
		 * 
		 * 
		 * System.out.println(flightRest);
		 * scheduledFlight.setFlightNumber(flightRest.getFlightNumber());
		 */
		 		
		/*
		 * String sourceAirportName = scheduledFlight.getSchedule().getSourceAirport();
		 * 
		 * String destinationAirportName =
		 * scheduledFlight.getSchedule().getDestinationAirport();
		 * 
		 * Airport sourceAirport = restTemplate
		 * .getForObject("http://localhost:8089/airport/airportname/" +
		 * sourceAirportName, Airport.class); //
		 * System.out.println(sourceAirport.getAirportName()); //
		 * scheduledFlight.getSchedule().setSourceAirport(sourceAirport.getAirportName()
		 * );
		 * 
		 * Airport destinationAirport = restTemplate
		 * .getForObject("http://localhost:8089/airport/airportname/" +
		 * destinationAirportName, Airport.class);
		 */		// scheduledFlight.getSchedule().setDestinationAirport(destinationAirport.
		// getAirportName());
		// System.out.println(sourceAirport.getAirportName());
		// System.out.println(sourceAirport);
		scheduledFlight.getSchedule().setArrivalTime(LocalDateTime.now().minusHours(3));
		scheduledFlight.getSchedule().setDepartureTime(LocalDateTime.now());
		

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
