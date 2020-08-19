package com.capg.fms.schedule.model;

import java.util.List;

public class ScheduledFlightList {

	private List<ScheduledFlight> scheduledFlightList;

	public ScheduledFlightList(List<ScheduledFlight> scheduledFlightList) {
		super();
		this.scheduledFlightList = scheduledFlightList;
	}

	public ScheduledFlightList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<ScheduledFlight> getScheduledFlightList() {
		return scheduledFlightList;
	}

	public void setScheduledFlightList(List<ScheduledFlight> scheduledFlightList) {
		this.scheduledFlightList = scheduledFlightList;
	}

	@Override
	public String toString() {
		return "ScheduledFlightList [scheduledFlightList=" + scheduledFlightList + "]";
	}
	
	
	
	
}
