package com.capg.fms.passenger.model;

import java.util.List;

public class PassengerList {

	private List<Passenger> passengerList;
	
	
	public PassengerList() {
		// TODO Auto-generated constructor stub
	}
	
	public PassengerList(List<Passenger> passengerList) {
		super();
		this.passengerList = passengerList;
	}

	public List<Passenger> getPassengerList() {
		return passengerList;
	}

	public void setPassengerList(List<Passenger> passengerList) {
		this.passengerList = passengerList;
	}

	@Override
	public String toString() {
		return "PassengerList [passengerList=" + passengerList + "]";
	}
	
	
	
	
}
