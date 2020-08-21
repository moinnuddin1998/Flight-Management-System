package com.capg.fms.airport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.fms.airport.dao.AirportDao;
import com.capg.fms.airport.entity.Airport;
import com.capg.fms.airport.entity.AirportList;

@Service
@Transactional
public class AirportServiceImpl implements AirportService {
	
	@Autowired(required=true)
    AirportDao airportDao;
	
	
	@Override
public Airport getAirportByCode(String airportCode) {
		
		/*
		 * if(!airportDao.existsById(airportCode)) { System.out.println(airportCode);
		 * throw new
		 * AirportNotFoundException("Airport with code : ["+airportCode+"] Not Found");
		 * }
		 */
		return airportDao.getOne(airportCode);
   }

	@Override
	public AirportList getAllAirports(){
		return new AirportList(airportDao.findAll());
	}

	@Override
	public Airport addAirport(Airport airport) {
		System.out.println(airport);
		return airportDao.save(airport);
		
	}

	@Override
	public void deleteAirport(String airportCode) {
		airportDao.deleteById(airportCode);
		
	}

	@Override
	public Airport getAirportByName(String airportName) {
		Airport airport=airportDao.findByAirportName(airportName);
		return airport;
	}

}
