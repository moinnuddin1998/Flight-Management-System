package com.cg.fms.dto;


import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private BigInteger bookingId;
	
	@Column(name = "user_id")
	private BigInteger userId;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = ISO.DATE_TIME)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime bookingDate;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Passenger> passengerList;
	
	//used Double not big double  
	private Double ticketCost;
	
	@OneToOne
	private ScheduleFlight scheduleFlight;
	
	private Integer noOfPassengers;
	
	private boolean cancelled;
	
	private boolean expired;
	
	
	public Booking() {
		super();
		this.setCancelled(false);
		this.setExpired(false);
	}
	
	public BigInteger getBookingId() {
		return bookingId;
	}
	public void setBookingId(BigInteger bookingId) {
		this.bookingId = bookingId;
	}
	public BigInteger getUserId() {
		return userId;
	}
	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}
	public LocalDateTime getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDateTime bookingDate) {
		this.bookingDate = bookingDate;
	}
	public List<Passenger> getPassengerList() {
		return passengerList;
	}
	public void setPassengerList(List<Passenger> passengerList) {
		this.passengerList = passengerList;
	}
	public Double getTicketCost() {
		return ticketCost;
	}
	public void setTicketCost(Double ticketCost) {
		this.ticketCost = ticketCost;
	}
	
	
	public ScheduleFlight getScheduleFlight() {
		return scheduleFlight;
	}

	public void setScheduleFlight(ScheduleFlight scheduleFlight) {
		this.scheduleFlight = scheduleFlight;
	}

	public Integer getNoOfPassengers() {
		return noOfPassengers;
	}
	public void setNoOfPassengers(Integer noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}
	
	public boolean isCancelled() {
		return cancelled;
	}
	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}
	
	public boolean isExpired() {
		return expired;
	}
	public void setExpired(boolean expired) {
		this.expired = expired;
	}
	
	
	
	public Booking(BigInteger bookingId, BigInteger userId, LocalDateTime bookingDate, List<Passenger> passengerList,
			Double ticketCost, ScheduleFlight scheduleFlight, Integer noOfPassengers, boolean cancelled, boolean expired) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		this.bookingDate = bookingDate;
		this.passengerList = passengerList;
		this.ticketCost = ticketCost;
		this.scheduleFlight = scheduleFlight;
		this.noOfPassengers = noOfPassengers;
		this.cancelled = cancelled;
		this.expired = expired;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", userId=" + userId + ", bookingDate=" + bookingDate
				+ ", passengerList=" + passengerList + ", ticketCost=" + ticketCost + ", scheduleFlight=" + scheduleFlight
				+ ", noOfPassengers=" + noOfPassengers + "]";
	}

	
}
