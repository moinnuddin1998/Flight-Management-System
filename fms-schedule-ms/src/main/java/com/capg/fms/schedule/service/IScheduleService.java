package com.capg.fms.schedule.service;

import com.capg.fms.schedule.exceptions.ScheduleAlreadyExistsException;
import com.capg.fms.schedule.exceptions.ScheduledFlightNotFoundException;
import com.capg.fms.schedule.model.Schedule;
import com.capg.fms.schedule.model.ScheduledFlight;
import com.capg.fms.schedule.model.ScheduledFlightList;

public interface IScheduleService  {

	
	public ScheduledFlight addScheduleFlight (long flightNumber,ScheduledFlight scheduledFlight) throws ScheduleAlreadyExistsException,ScheduledFlightNotFoundException;

	public ScheduledFlight viewScheduledFlight(int scheduleId);

	public ScheduledFlightList viewScheduledFlights();

	public ScheduledFlight modifyScheduledFlight(int scheduledFlightId, int availableSeats, long flightNumber,
			Schedule schedule);

	public void deleteScheduledFlight(int scheduledFlightId);

	
	
	
}
