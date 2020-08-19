package com.capg.fms.schedule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.fms.schedule.exceptions.ScheduleAlreadyExistsException;
import com.capg.fms.schedule.exceptions.ScheduledFlightNotFoundException;
import com.capg.fms.schedule.model.Schedule;
import com.capg.fms.schedule.model.ScheduledFlight;
import com.capg.fms.schedule.model.ScheduledFlightList;
import com.capg.fms.schedule.repo.IScheduleRepo;

@Service
public class ScheduleServiceImp implements IScheduleService {

	@Autowired
	IScheduleRepo repo;
	
	@Override
	public ScheduledFlight addScheduleFlight(ScheduledFlight scheduledFlight) {

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
