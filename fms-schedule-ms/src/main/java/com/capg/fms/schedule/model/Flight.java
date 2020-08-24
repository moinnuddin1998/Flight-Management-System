package com.capg.fms.schedule.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Flight {

	@Id
	private long flightNumber; 
	private String flightModel;
	private String carrierName;
	private int seatCapacity;
	
	public Flight() {
		super();
		
	}
	
	public long getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(long flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getFlightModel() {
		return flightModel;
	}

	public void setFlightModel(String flightModel) {
		this.flightModel = flightModel;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public int getSeatCapacity() {
		return seatCapacity;
	}

	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}



	public Flight( String flightModel, String carrierName, int seatCapacity, long flightNumber) {
		super();
		
		this.flightModel = flightModel;
		this.carrierName = carrierName;
		this.seatCapacity = seatCapacity;
		this.flightNumber = flightNumber;
	}

	@Override
	public String toString() {
		return "Flight [FlightNumber=" +flightNumber+ ", flightModel=" + flightModel + ", carrierName=" + carrierName
				+ ", seatCapacity=" + seatCapacity + "]";
	}

	
	
	
	
}

