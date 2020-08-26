package com.capg.fms.schedule.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Schedule {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int scheduleId;
	@DateTimeFormat(pattern = "yyyy/MM/ddThh:mm:ss")
	private LocalDateTime arrivalTime;
	
	@DateTimeFormat(pattern = "yyyy/MM/ddThh:mm:ss")
	private LocalDateTime departureTime;
	
	private String sourceAirport;
	
	private String destinationAirport;

	public Schedule() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Schedule(LocalDateTime arrivalTime, LocalDateTime departureTime, String sourceAirport,String destinationAirport,int scheduleId) {
		super();
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.sourceAirport = sourceAirport;
		this.destinationAirport = destinationAirport;
		this.scheduleId = scheduleId;
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

	public String getSourceAirport() {
		return sourceAirport;
	}

	public void setSourceAirport(String sourceAirport) {
		this.sourceAirport = sourceAirport;
	}

	public String getDestinationAirport() {
		return destinationAirport;
	}

	public void setDestinationAirport(String destinationAirport) {
		this.destinationAirport = destinationAirport;
	}
	

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	@Override
	public String toString() {
		return "Schedule [ScheduleId =" +scheduleId+"   arrivalTime=" + arrivalTime + ", departureTime=" + departureTime + ", sourceAirport="
				+ sourceAirport + ", destinationAirport=" + destinationAirport + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}
