package com.cg.fms.dto;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

@Entity
public class Flight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private BigInteger flightNumber;
	
	@NotEmpty(message = "Flight Model is Empty")
	private String flightModel;
	
	@NotEmpty(message = "Carrier Name is Empty")
	private String carrierName;
	
	@NotNull
	private Integer seatCpacity;
	public BigInteger getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(BigInteger flightNumber) {
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
	public Integer getSeatCpacity() {
		return seatCpacity;
	}
	public void setSeatCpacity(Integer seatCpacity) {
		this.seatCpacity = seatCpacity;
	}
	@Override
	public String toString() {
		return "Flight [flightNumber=" + flightNumber + ", flightModel=" + flightModel + ", carrierName=" + carrierName
				+ ", seatCpacity=" + seatCpacity + "]";
	}
	public Flight(BigInteger flightNumber, String flightModel, String carrierName, Integer seatCpacity) {
		super();
		this.flightNumber = flightNumber;
		this.flightModel = flightModel;
		this.carrierName = carrierName;
		this.seatCpacity = seatCpacity;
	}
	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
