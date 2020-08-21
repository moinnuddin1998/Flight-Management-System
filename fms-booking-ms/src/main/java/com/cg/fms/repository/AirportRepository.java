package com.cg.fms.repository;
import org.springframework.data.repository.CrudRepository;
//repository that extends CrudRepository

import com.cg.fms.dto.Airport;

public interface AirportRepository extends CrudRepository<Airport, String>
{
}
