package com.capg.fms.airport.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.fms.airport.entity.Airport;
public interface AirportDao extends JpaRepository<Airport, String>{
	public Airport findByAirportName(String airportName);
}
