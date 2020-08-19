package com.capg.fms.microservice.flight.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.capg.fms.microservice.flight.model.FlightBean;

public interface FlightRepo extends JpaRepository<FlightBean, Long> {
	

}
