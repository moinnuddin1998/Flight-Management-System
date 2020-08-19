package com.capg.fms.schedule.model;

import javax.persistence.Entity;
import javax.persistence.Id;


public class Flight {

	
	public String flightModel;
	public String carrierName;
	public int seatCapacity;
	
	public Flight() {
		super();
		// TODO Auto-generated constructor stub
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



	public Flight( String flightModel, String carrierName, int seatCapacity) {
		super();
		
		this.flightModel = flightModel;
		this.carrierName = carrierName;
		this.seatCapacity = seatCapacity;
	}

	@Override
	public String toString() {
		return "Flight [ flightModel=" + flightModel + ", carrierName=" + carrierName
				+ ", seatCapacity=" + seatCapacity + "]";
	}

	
	
	
	
}

