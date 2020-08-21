package com.cg.fms.dto;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@Entity(name = "Passenger")
public class Passenger {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private BigInteger pnrNumber;
	
	@Pattern(regexp = "^[\\p{L} .'-]+$", message = "Name should not contain special characters.")
	private String passengerName;
	
	@Positive(message = "Age cannot be less than 0.")
	private Integer passengerAge;
	
	private BigInteger passengerUIN;
	
	private Double Luggage;
	public BigInteger getPnrNumber() {
		return pnrNumber;
	}
	public void setPnrNumber(BigInteger pnrNumber) {
		this.pnrNumber = pnrNumber;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public Integer getPassengerAge() {
		return passengerAge;
	}
	public void setPassengerAge(Integer passengerAge) {
		this.passengerAge = passengerAge;
	}
	public BigInteger getPassengerUIN() {
		return passengerUIN;
	}
	public void setPassengerUIN(BigInteger passengerUIN) {
		this.passengerUIN = passengerUIN;
	}
	public Double getLuggage() {
		return Luggage;
	}
	public void setLuggage(Double luggage) {
		Luggage = luggage;
	}
	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Passenger(BigInteger pnrNumber, String passengerName, Integer passengerAge, BigInteger passengerUIN,
			Double luggage) {
		super();
		this.pnrNumber = pnrNumber;
		this.passengerName = passengerName;
		this.passengerAge = passengerAge;
		this.passengerUIN = passengerUIN;
		Luggage = luggage;
	}
	@Override
	public String toString() {
		return "Passenger [pnrNumber=" + pnrNumber + ", passengerName=" + passengerName + ", passengerAge="
				+ passengerAge + ", passengerUIN=" + passengerUIN + ", Luggage=" + Luggage + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Passenger other = (Passenger) obj;
		if (passengerAge == null) {
			if (other.passengerAge != null)
				return false;
		} else if (!passengerAge.equals(other.passengerAge))
			return false;
		if (passengerName == null) {
			if (other.passengerName != null)
				return false;
		} else if (!passengerName.equals(other.passengerName))
			return false;
		if (passengerUIN == null) {
			if (other.passengerUIN != null)
				return false;
		} else if (!passengerUIN.equals(other.passengerUIN))
			return false;
		if (pnrNumber == null) {
			if (other.pnrNumber != null)
				return false;
		} else if (!pnrNumber.equals(other.pnrNumber))
			return false;
		return true;
	}
	
	
	
}