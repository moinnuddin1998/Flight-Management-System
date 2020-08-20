package com.capg.fms.airport.entity;

import java.util.List;

public class AirportList {
 
	private List<Airport> airportList;

	public List<Airport> getAirportList() {
		return airportList;
	}

	public void setAirportList(List<Airport> airportList) {
		this.airportList = airportList;
	}

	public AirportList(List<Airport> airportList) {
		super();
		this.airportList = airportList;
	}

	public AirportList() {
		super();
	}

	@Override
	public String toString() {
		return "AirportList [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
}
