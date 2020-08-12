package com.capg.fms.schedule.model;

import javax.persistence.Entity;

@Entity
public class ScheduledFlight {

	
	private int availableSeats;
	private Schedule schedule;
	private Flight flight;
	public ScheduledFlight() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ScheduledFlight(int availableSeats, Schedule schedule, Flight flight) {
		super();
		this.availableSeats = availableSeats;
		this.schedule = schedule;
		this.flight = flight;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	public Schedule getSchedule() {
		return schedule;
	}
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	@Override
	public String toString() {
		return "ScheduledFlight [availableSeats=" + availableSeats + ", schedule=" + schedule + ", flight=" + flight
				+ "]";
	}
	
	
	
	
	
	
	
	
	
}
