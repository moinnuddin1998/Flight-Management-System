package com.capg.fms.airport.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Airport {
	public Airport() {
		super();
	}
	public Airport(String airportName, String airportCode, String airportLocation) {
		super();
		this.airportName = airportName;
		this.airportCode = airportCode;
		this.airportLocation = airportLocation;
	}
	
	@Id
	private String airportCode;
	private String airportName;
	private String airportLocation;
	public String getAirportName() {
		return airportName;
	}
	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}
	public String getAirportCode() {
		return airportCode;
	}
	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}
	public String getAirportLocation() {
		return airportLocation;
	}
	public void setAirportLocation(String airportLocation) {
		this.airportLocation = airportLocation;
	}
}
