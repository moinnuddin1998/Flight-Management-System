package com.cg.fms.repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.cg.fms.dto.Booking;

public interface BookingRepository extends CrudRepository<Booking, BigInteger>{
	
	Optional<List<Booking>> findByUserId(BigInteger userId);
}
