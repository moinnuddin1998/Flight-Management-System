package com.capg.fms.passenger.model;

public class Passenger {
  
	 private long passengerNumber;
	 private String passengerName;
	 private int passengerAge;
	 private long passengerUIN;
	 private double luggage;
	 
	 public Passenger() {
		// TODO Auto-generated constructor stub
	}
	 
	public Passenger(long passengerNumber, String passengerName, int passengerAge, long passengerUIN, double luggage) {
		super();
		this.passengerNumber = passengerNumber;
		this.passengerName = passengerName;
		this.passengerAge = passengerAge;
		this.passengerUIN = passengerUIN;
		this.luggage = luggage;
	}



	public long getPassengerNumber() {
		return passengerNumber;
	}
	public void setPassengerNumber(long passengerNumber) {
		this.passengerNumber = passengerNumber;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public int getPassengerAge() {
		return passengerAge;
	}
	public void setPassengerAge(int passengerAge) {
		this.passengerAge = passengerAge;
	}
	public long getPassengerUIN() {
		return passengerUIN;
	}
	public void setPassengerUIN(long passengerUIN) {
		this.passengerUIN = passengerUIN;
	}
	public double getLuggage() {
		return luggage;
	}
	public void setLuggage(double luggage) {
		this.luggage = luggage;
	}

	@Override
	public String toString() {
		return "Passenger [passengerNumber=" + passengerNumber + ", passengerName=" + passengerName + ", passengerAge="
				+ passengerAge + ", passengerUIN=" + passengerUIN + ", luggage=" + luggage + "]";
	}
	 	
	
}
