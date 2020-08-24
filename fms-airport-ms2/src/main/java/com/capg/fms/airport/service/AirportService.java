package com.capg.fms.airport.service;

import java.util.List;

import com.capg.fms.airport.entity.Airport;
import com.capg.fms.airport.entity.AirportList;

public interface AirportService {
	
	    public Airport getAirportByCode(String airportCode);
	    public AirportList getAllAirports();
        public Airport addAirport(Airport airport);
        void deleteAirport(String airportCode);
        public Airport getAirportByName(String airportName);
}
