package com.capg.fms.airport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.fms.airport.entity.Airport;
import com.capg.fms.airport.entity.AirportList;
import com.capg.fms.airport.service.AirportService;
@RestController
@RequestMapping("/airport")
public class AirportRestController {
	@Autowired 
	private AirportService airportservice;
	

	@GetMapping("/airport/{airportcode}")
	public ResponseEntity<Airport> viewAiportByCode(@PathVariable ("airportCode") String airportCode ){
		Airport airport=airportservice.getAirportByCode(airportCode);
	    return new ResponseEntity<Airport>(airport,new HttpHeaders(),HttpStatus.OK);
	}
    
	@GetMapping("/all")
	public ResponseEntity<AirportList> getAllAirports(){
		AirportList list=airportservice.getAllAirports();
		return new ResponseEntity<AirportList>(list,new HttpHeaders(),HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Boolean> addAirport(@RequestBody Airport airport){
		airportservice.addAirport(airport);
		ResponseEntity<Boolean> responseEntity=new ResponseEntity(true,HttpStatus.OK);
		return responseEntity;
	}
	
	@DeleteMapping("/delete/{airportCode}")
	public void deleteAirport(@PathVariable String airportCode) {
		System.out.println(airportCode);
		airportservice.deleteAirport(airportCode);
	}
	
	
	@GetMapping("/airportname/{airportName}")
	public Airport getAirportByName(@PathVariable String airportName) {
		return airportservice.getAirportByName(airportName);
	}
	
     @ExceptionHandler(Exception.class)
     public String inValidInput(Exception e)
     {
    	 return e.getMessage();
     }
	
}
