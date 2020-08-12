package com.capg.fms.schedule.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Schedule {

	@DateTimeFormat(pattern = "yyyy/MM/ddThh:mm:ss")
	private LocalDateTime arrivalTime;
	
	@DateTimeFormat(pattern = "yyyy/MM/ddThh:mm:ss")
	private LocalDateTime departureTime;
	
	private Airport sourceAirport;
	
	private Airport destinationAirport;

	public Schedule() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Schedule(LocalDateTime arrivalTime, LocalDateTime departureTime, Airport sourceAirport,
			Airport destinationAirport) {
		super();
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.sourceAirport = sourceAirport;
		this.destinationAirport = destinationAirport;
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}

	public Airport getSourceAirport() {
		return sourceAirport;
	}

	public void setSourceAirport(Airport sourceAirport) {
		this.sourceAirport = sourceAirport;
	}

	public Airport getDestinationAirport() {
		return destinationAirport;
	}

	public void setDestinationAirport(Airport destinationAirport) {
		this.destinationAirport = destinationAirport;
	}

	@Override
	public String toString() {
		return "Schedule [arrivalTime=" + arrivalTime + ", departureTime=" + departureTime + ", sourceAirport="
				+ sourceAirport + ", destinationAirport=" + destinationAirport + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}
