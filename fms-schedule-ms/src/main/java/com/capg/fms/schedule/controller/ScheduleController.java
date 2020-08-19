package com.capg.fms.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.fms.schedule.model.ScheduledFlight;
import com.capg.fms.schedule.model.ScheduledFlightList;
import com.capg.fms.schedule.service.ScheduleServiceImp;

@RestController
@RequestMapping("/scheduleflight")
public class ScheduleController  {

	@Autowired
	ScheduleServiceImp service;

	@PostMapping("/add")
	public ScheduledFlight addScheduledFlight(@RequestBody ScheduledFlight scheduledFlight) {
		
		
		ScheduledFlight scheduledFlight1 = service.addScheduleFlight(scheduledFlight);

		return scheduledFlight1;

	}
	
	@GetMapping("/view/id/{scheduleId}")
    public ScheduledFlight viewScheduledFlight(@PathVariable int scheduleId) {
		

	return service.viewScheduledFlight(scheduleId);

	}

    @GetMapping("/viewall")
    public ScheduledFlightList viewScheduledFlights() {
	

	return service.viewScheduledFlights();

	}

    @PostMapping("/modify")
	public ScheduledFlight modifyScheduledFlight(@RequestBody ScheduledFlight scheduledFlight) {

		ScheduledFlight scheduledFlight1 = service.modifyScheduledFlight(scheduledFlight.getScheduledFlightId(),
				scheduledFlight.getAvailableSeats(), scheduledFlight.getFlightNumber(), scheduledFlight.getSchedule());

		return scheduledFlight1;
		
	}

    @DeleteMapping("/delete/id/{scheduledFlightId}")
    public void deleteScheduledFlight(int scheduledFlightId) {
    	
    	service.deleteScheduledFlight(scheduledFlightId);
    	
    }









	
	
	
	
	
	
	
	
	
	
}
