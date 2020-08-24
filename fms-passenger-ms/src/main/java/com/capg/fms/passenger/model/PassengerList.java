package com.capg.fms.passenger.model;

import java.util.List;

/****************************************************************************************************************************
- File Name        : PassengerList.java 
- Author           : Capgemini 
- Creation Date    : 12/08/2020
- Description      : PassengerList Class with passengerList Property
****************************************************************************************************************************/

public class PassengerList {

	private List<Passenger> passengerList;

	public List<Passenger> getPassengerList() {
		return passengerList;
	}

	public void setPassengerList(List<Passenger> passengerList) {
		this.passengerList = passengerList;
	}

	public PassengerList(List<Passenger> passengerList) {
		super();
		this.passengerList = passengerList;
	}

	public PassengerList() {
		super();
	}

	@Override
	public String toString() {
		return "PassengerList [passengerList=" + passengerList + "]";
	}

}
