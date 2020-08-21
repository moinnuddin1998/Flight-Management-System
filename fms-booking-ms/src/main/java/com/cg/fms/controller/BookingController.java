package com.cg.fms.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fms.dto.Booking;
import com.cg.fms.dto.Passenger;
import com.cg.fms.exception.InvalidBookingException;
import com.cg.fms.payload.RestResponse;
import com.cg.fms.repository.BookingRepository;
import com.cg.fms.service.BookingService;



/**
 * @author nitesh
 *
 */
@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@Autowired
	private BookingRepository bookingRepository;
	
	
	private static final Logger logger = LoggerFactory.getLogger(BookingController.class);
	
	
	@GetMapping("/viewbyuserid/{userId}")
	public ResponseEntity<?> getBookingbyUserId(@PathVariable("userId") BigInteger userId) {
		List<Booking> bookings;
		try {
			bookings = bookingService.viewBookingbyUserId(userId);
		} catch (InvalidBookingException e) {
			logger.error(e.getMessage());
			return ResponseEntity.ok(new RestResponse<>(false, e.getMessage()));
		}
		logger.info("Booking list for user Found");
		return ResponseEntity.ok(new RestResponse<>(true, "Booking list for user id "+userId +" Found", bookings));
	}

	@GetMapping("/viewbybookingid/{bookingId}")
	public ResponseEntity<?> getBooking(@PathVariable("bookingId") BigInteger bookingId) {
		Booking booking;
		try {
			booking = bookingService.viewBooking(bookingId);
		} catch (InvalidBookingException e) {
			logger.error("Booking not found");
			return ResponseEntity.ok(new RestResponse<>(false, e.getMessage()));
		}
		logger.info("Booking found");
		return ResponseEntity.ok(new RestResponse<>(true, "Booking found",booking));
	}

	@PostMapping("/add")
	public ResponseEntity<?> saveBooking(@Valid @RequestBody Booking booking) {
		List<Passenger> passList = new ArrayList<>();
		Booking bookingUpdate;
		for (Passenger passenger : booking.getPassengerList()) {
			try {
				bookingService.validatePassenger(passenger);
			} catch (InvalidBookingException e) {
				logger.error(e.getMessage());
				return ResponseEntity.ok(new RestResponse<>(false, e.getMessage()));
			}
			passList.add(passenger);
		}
		booking.setCancelled(false);
		booking.setExpired(false);
		booking.setPassengerList(passList);
		try {
			bookingService.validateBooking(booking);
			bookingUpdate = bookingService.addBooking(booking);
			
		} catch (InvalidBookingException e) {
			logger.error(e.getMessage());
			return ResponseEntity.ok(new RestResponse<>(false, e.getMessage()));
		}
		logger.info("Booking Saved");
		return ResponseEntity.ok(new RestResponse<>(true, "Booking Added", bookingUpdate));
	}

	@PutMapping("/modify")
	public ResponseEntity<?> modifyBooking(@Valid @RequestBody Booking booking) {
		Optional<Booking> bookingUpdate;
		bookingUpdate = bookingRepository.findById(booking.getBookingId());

		if (!bookingUpdate.isPresent()) {
			logger.error("No booking found");
			return ResponseEntity.ok(new RestResponse<>(false, "Booking Not Found"));
		}
		else if (bookingUpdate.get().getNoOfPassengers() != booking.getPassengerList().size()) {
			logger.error("Number of passenger not matched");
			return ResponseEntity.ok(new RestResponse<>(false, "Invalid request, number of passenger cannot be changed."
					+ " You can rebook a ticket for this"));
		}
		else {
			List<Passenger> passList = new ArrayList<>();
			for (Passenger passenger : booking.getPassengerList()) {
				try {
					bookingService.validatePassenger(passenger);
				} catch (InvalidBookingException e) {
					logger.error(e.getMessage());
					return ResponseEntity.ok(new RestResponse<>(false, e.getMessage()));
				}
				passList.add(passenger);
			}
			bookingUpdate.get().setPassengerList(passList);
			
			try {
				bookingService.validateBooking(bookingUpdate.get());
				bookingService.modifyBooking(bookingUpdate.get());
			} catch (InvalidBookingException e) {
				logger.error(e.getMessage());
				return ResponseEntity.ok(new RestResponse<>(false, e.getMessage()));
			}
			logger.info("Booking modified succesfully");
			return ResponseEntity.ok(new RestResponse<>(true, "Booking Modified", bookingUpdate.get()));
		}
	}

	@PutMapping("/cancel/{bookingId}")
	public ResponseEntity<?> cancelBooking(@PathVariable("bookingId") BigInteger bookingId) {
		try {
			bookingService.cancelBooking(bookingId);
			logger.info("Booking Cancelled sucessfully");
			return ResponseEntity.ok(new RestResponse<>(true,"Booking with id "+bookingId +" Cancelled sucessfully"));
		} catch (InvalidBookingException e) {
			logger.error(e.getMessage());
			return ResponseEntity.ok(new RestResponse<>(false, e.getMessage()));
		}

	}


}
