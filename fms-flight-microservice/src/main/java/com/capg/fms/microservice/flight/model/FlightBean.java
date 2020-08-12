package com.capg.fms.microservice.flight.model;

public class FlightBean {
	
    private int flightNumber;
	private String flightModel;
	private String carrierName;
	private int seatCapacity;
	
	public int getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(int flightNumber) {
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
	public String toString() {
		return "FlightBean [flightNumber=" + flightNumber + ", flightModel=" + flightModel + ", carrierName="
				+ carrierName + ", seatCapacity=" + seatCapacity + "]";
	}

}
