package com.cg.fms.repository;
import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;

import com.cg.fms.dto.Flight;

//repository that extends CrudRepository
public interface FlightRepository extends CrudRepository<Flight, BigInteger>
{


}
