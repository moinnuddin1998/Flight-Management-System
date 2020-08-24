package com.capg.fms.passenger.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.fms.passenger.model.Passenger;
import com.capg.fms.passenger.model.PassengerList;
import com.capg.fms.passenger.service.PassengerService;
import com.capg.fms.passenger.service.PassengerServiceImpl;

/****************************************************************************************************************************
- File Name        : PassengerController.java 
- Author           : Capgemini 
- Creation Date    : 11/08/2020
- Modified Date    : 17/08/2020
- Description      : This Controller class act as an end point to manage the entire PassengerService
****************************************************************************************************************************/

@CrossOrigin(origins = { "http://localhost:4200" }, methods = { RequestMethod.DELETE, RequestMethod.GET,
		RequestMethod.POST, RequestMethod.PUT })
@RestController
@RequestMapping("/passenger")
public class PassengerController {

	@Autowired
	PassengerService passengerService;

	Logger logger = LoggerFactory.getLogger(PassengerServiceImpl.class);
	
	/****************************************************************************************************************************
	  - Method Name         : addPassenger
	  - Input Parameters    : Passenger passenger
	  - Return Type         : boolean
	  - End Point Url       : /add
	  - Request Method Type : PostMapping 
	  - Author              : Capgemini 
	  - Creation Date       : 11/08/2020
	  - Description         : Adding the passenger details in to the database
	 ****************************************************************************************************************************/
		
	@PostMapping("/add")
	public ResponseEntity<Passenger> addPassenger(@RequestBody Passenger passenger) {
		
		if (passengerService.validatePassengerNumber(passenger.getPassengerNum())
				&& passengerService.validatePassengerUIN(passenger.getPassengerUIN())
				&& passengerService.validatePassengerName(passenger.getPassengerName())
				&& passengerService.validatePassengerAge(passenger.getPassengerAge())
				&& passengerService.validateLuggage(passenger.getLuggage())) {
			
			logger.info("Passenger Added Successfully");

			return new ResponseEntity<Passenger>(passengerService.addPassenger(passenger), HttpStatus.OK);
		}
		return new ResponseEntity<Passenger>(HttpStatus.BAD_REQUEST);

	}

	/****************************************************************************************************************************
	  - Method Name         : deletePassenger
	  - Input Parameters    : passengerNum
	  - Return Type         : boolean
	  - End Point Url       : /delete/num/{passengerNum} 
	  - Request Method Type : DeleteMapping 
	  - Author              : Capgemini 
	  - Creation Date       : 13/08/2020
	  - Description         : Deleting the passenger details from the database
	 ****************************************************************************************************************************/
	
	@DeleteMapping("/delete/num/{passengerNum}")
	public boolean deletePassenger(@PathVariable("passengerNum") long passengerNum) {
		
		logger.info("Passenger Deleted Successfully");

		return passengerService.deletePassenger(passengerNum);
	}

	/****************************************************************************************************************************
	  - Method Name         : getPassenger
	  - Input Parameters    : passengerNum
	  - Return Type         : passengerdetails
	  - End Point Url       : /num/{passengerNum} 
	  - Request Method Type : GetMapping 
	  - Author              : Capgemini 
	  - Creation Date       : 15/08/2020
	  - Description         : Getting the passenger details from the database
	 ****************************************************************************************************************************/

	@GetMapping("/num/{passengerNum}")
	public ResponseEntity<Passenger> getPassenger(@PathVariable("passengerNum") long passengerNum) {
		logger.info("Passenger details of" + passengerNum +"are shown");;
		return new ResponseEntity<Passenger>(passengerService.getPassenger(passengerNum), HttpStatus.OK);
	}

	/****************************************************************************************************************************
	  - Method Name         : getAllPassengers
	  - Return Type         : passengerList
	  - End Point Url       : /all
	  - Request Method Type : GetMapping 
	  - Author              : Capgemini 
	  - Creation Date       : 12/08/2020
	  - Description         : Getting the passenger list from the database
	 ****************************************************************************************************************************/
	
	@GetMapping("/all")
	public ResponseEntity<PassengerList> getAllPassengers() {
		logger.info("Passenger List is shown");
		return new ResponseEntity<PassengerList>(passengerService.getAllPassengers(), HttpStatus.OK);
	}

	/****************************************************************************************************************************
	  - Method Name         : updatePassenger
	  - Input Parameters    : Passenger passenger
	  - Return Type         : boolean
	  - End Point Url       : /update
	  - Request Method Type : PutMapping 
	  - Author              : Capgemini 
	  - Creation Date       : 14/08/2020
	  - Description         : Updating the passenger details present in the database
	 ****************************************************************************************************************************/
	
	@PutMapping("/update")
	public ResponseEntity<Passenger> updatePassenger(@RequestBody Passenger passenger) {

		if (passengerService.validatePassengerUIN(passenger.getPassengerUIN())
				&& passengerService.validatePassengerName(passenger.getPassengerName())
				&& passengerService.validatePassengerAge(passenger.getPassengerAge())
				&& passengerService.validateLuggage(passenger.getLuggage())) {
			
			logger.info("Passenger Updated Successfully");

			return new ResponseEntity<Passenger>(passengerService.updatePassenger(passenger), HttpStatus.OK);
		}
		return new ResponseEntity<Passenger>(HttpStatus.BAD_REQUEST);
	}

}
