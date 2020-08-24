package com.cg.fms.repository;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
//repository that extends CrudRepository

import com.cg.fms.dto.Airport;
import com.cg.fms.dto.Schedule;
import com.cg.fms.dto.ScheduleFlight;

public interface ScheduleRepository extends CrudRepository<Schedule,Integer>{
	 
	Optional<List<ScheduleFlight>> findBysourceAirportAndDestinationAirportAndDepartureDateTime(Airport sourceAirport,
			Airport destinationAirport, LocalDateTime departureDateTime);
}
