package com.capg.fms.microservice.flight.model;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@Entity

@Table(name="Flight_Info")

public class FlightBean {
	@Id
	
    private long flightNumber;
	 
	private String flightModel;	
	
	private String carrierName;

	private int seatCapacity;
	
	public FlightBean() {
		super();
	}

	public FlightBean(long flightNumber, String flightModel, String carrierName, int seatCapacity) {
		super();
		this.flightNumber = flightNumber;
		this.flightModel = flightModel;
		this.carrierName = carrierName;
		this.seatCapacity = seatCapacity;
	}
	public long getFlightNumber() {
		
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
