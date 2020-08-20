package com.capg.fms.schedule.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ScheduledFlight {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int scheduledFlightId;
	private int availableSeats;
	@OneToOne(cascade = { CascadeType.ALL })
	private Schedule schedule;
	private long flightNumber;
	public ScheduledFlight() {
		// TODO Auto-generated constructor stub
	}
	public ScheduledFlight(int scheduledFlightId,int availableSeats, Schedule schedule, long flightNumber) {
		super();
		this.availableSeats = availableSeats;
		this.schedule = schedule;
	    this.scheduledFlightId = scheduledFlightId;
		this.flightNumber = flightNumber;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	public int getScheduledFlightId() {
		return scheduledFlightId;
	}
	public void setScheduledFlightId(int scheduledFlightId) {
		this.scheduledFlightId = scheduledFlightId;
	}
	public Schedule getSchedule() {
		return schedule;
	}
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	public long getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(long flightNumber) {
		this.flightNumber = flightNumber;
	}
	@Override
	public String toString() {
		return "ScheduledFlight [scheduledFlightId=" + scheduledFlightId + ", availableSeats=" + availableSeats
				+ ", schedule=" + schedule + ", flightNumber=" + flightNumber + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
