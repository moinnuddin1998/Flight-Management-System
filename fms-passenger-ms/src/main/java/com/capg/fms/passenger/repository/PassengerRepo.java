package com.capg.fms.passenger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.fms.passenger.model.Passenger;

/****************************************************************************************************************************
- File Name        : IPassengerRepo.java 
- Author           : Capgemini 
- Creation Date    : 11/08/2020
- Description      : IPassengerRepo class is responsible for accessing the data through database
****************************************************************************************************************************/

public interface PassengerRepo extends JpaRepository<Passenger, Long> {
}
