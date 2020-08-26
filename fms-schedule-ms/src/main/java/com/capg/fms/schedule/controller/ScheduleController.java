package com.capg.fms.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.fms.schedule.exceptions.ScheduledFlightNotFoundException;
import com.capg.fms.schedule.model.ScheduledFlight;
import com.capg.fms.schedule.model.ScheduledFlightList;
import com.capg.fms.schedule.service.ScheduleServiceImp;

/***************************************************************
-Author                : Nagendra 
-Created/Modified Date : 15/08/2020
-Description           : ScheduleController class for 
						  Schedule Management system
*******************************************************************/
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/scheduleflight")
//@CrossOrigin(origins = "http://localhost:4200")
public class ScheduleController  {

	@Autowired
	ScheduleServiceImp service;

	/**
	   * This method is used to process Add Schedule Flights. 
	   * @param  flightNumber,ScheduedFlight : A  variable and an object  
	   * @return String  : This returns String message,else else throws exception
	 **/
	
	@PostMapping("/add/{flightNumber}")
	public ScheduledFlight addScheduledFlight(@PathVariable long flightNumber,@RequestBody ScheduledFlight scheduledFlight)throws ScheduledFlightNotFoundException {
		
		
		ScheduledFlight scheduledFlight1 = service.addScheduleFlight(flightNumber,scheduledFlight);

		return scheduledFlight1;

	}
	
	/**
	   * This method is used to  View Schedule Flight. 
	   * @param  Scheduled Flight Id : a variable  
	   * @return String  : returns that particualr Scheduled Flight
	 **/
	
	@GetMapping("/view/id/{scheduleId}")
    public ScheduledFlight viewScheduledFlight(@PathVariable int scheduleId) {
		

	return service.viewScheduledFlight(scheduleId);

	}
	
	/**
	   * This method is used to  View Schedule Flights. 
	   * @return   : returns all the Scheduled flights from List 
	 **/


    @GetMapping("/viewall")
    public ScheduledFlightList viewScheduledFlights() {
	

	return service.viewScheduledFlights();

	}

    /**
	   * This method is used to Modify a Scheduled Flight. 
	   * @param   : Variables present in Scheduled Flight  
	   * @return String  : returns that particualr Scheduled Flight
	 **/

    
    @PostMapping("/modify")
	public ScheduledFlight modifyScheduledFlight(@RequestBody ScheduledFlight scheduledFlight) {

		ScheduledFlight scheduledFlight1 = service.modifyScheduledFlight(scheduledFlight.getScheduledFlightId(),
				scheduledFlight.getAvailableSeats(), scheduledFlight.getFlightNumber(), scheduledFlight.getSchedule());

		return scheduledFlight1;
		
	}

    /**
	   * This method is used to  Delete a Scheduled Flight. 
	   * @param  Scheduled Flight Id : a variable  
	   * @return String  : returns that particualr Scheduled Flight
	 **/
    
    @DeleteMapping("/delete/id/{scheduledFlightId}")
    public String deleteScheduledFlight(@PathVariable int scheduledFlightId) {
    	
    	service.deleteScheduledFlight(scheduledFlightId);
    	
    	return "Deleted succesfully";
    }









	
	
	
	
	
	
	
	
	
	
}
