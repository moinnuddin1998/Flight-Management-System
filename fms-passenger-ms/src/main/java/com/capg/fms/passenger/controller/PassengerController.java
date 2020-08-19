package com.capg.fms.passenger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capg.fms.passenger.model.Passenger;
import com.capg.fms.passenger.model.PassengerList;
import com.capg.fms.passenger.service.PassengerServiceImpl;


@RestController
public class PassengerController {
	@Autowired
	
	PassengerServiceImpl passengerService;
	

	
	@PostMapping("/add")
	public ResponseEntity<Passenger> addPassenger(@RequestBody Passenger passenger){	
		if (passengerService.validatePassengerNumber(passenger.getPassengerNumber())
				&& passengerService.validatePassengerUIN(passenger.getPassengerUIN())
				&& passengerService.validatePassengerName(passenger.getPassengerName())
				&& passengerService.validatePassengerAge(passenger.getPassengerAge())) {
					}
	return new ResponseEntity<Passenger>(passengerService.addPassenger(passenger), HttpStatus.OK); 
		  } 		  
		 
	
	@DeleteMapping("/delete/number/{passengerNumber}")
	public boolean  deletePassenger(@PathVariable long passengerNumber) {
		
		return passengerService.deletePassenger(passengerNumber);
		
	}
	
	 @GetMapping("/number/{passengerNumber}")
	public ResponseEntity<Passenger> getPassenger(@PathVariable long passengerNumber){
		
		
		return new ResponseEntity<Passenger>(passengerService.getPassenger(passengerNumber), HttpStatus.OK )     ;
		
	}
	
	 @GetMapping("/all")
	 public ResponseEntity<PassengerList> getAllPassengers(){	
	return new ResponseEntity<PassengerList>(passengerService.getAllPassengers(), HttpStatus.OK);
	 }
	
	
	 @PutMapping("/update")
		public ResponseEntity<Passenger> updatePassenger(@RequestBody Passenger passenger) {
		 
		 
		 if (passengerService.validatePassengerNumber(passenger.getPassengerNumber())
					&& passengerService.validatePassengerUIN(passenger.getPassengerUIN())
					&& passengerService.validatePassengerName(passenger.getPassengerName())
					&& passengerService.validatePassengerAge(passenger.getPassengerAge())) {
		 }
		 return new ResponseEntity<Passenger>(passengerService.updatePassenger(passenger), HttpStatus.OK);

}
	 
		

		@GetMapping("/getcount")
		public long getCountOfPassenger() {

			return passengerService.getCountOfPassenger();
		}

	 
	
	 
}





