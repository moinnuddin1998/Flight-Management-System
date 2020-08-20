package com.capg.fms.passenger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.fms.passenger.model.Passenger;
@Repository
public interface PassengerRepo extends JpaRepository<Passenger, Long> {

}
