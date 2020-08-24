package com.capg.fms.microservice.flight.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.fms.microservice.flight.model.Flight;

public interface FlightRepo extends JpaRepository<Flight, Long> {
	

}
