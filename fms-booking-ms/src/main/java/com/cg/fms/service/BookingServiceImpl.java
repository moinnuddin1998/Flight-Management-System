package com.cg.fms.service;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cg.fms.dto.Booking;
import com.cg.fms.dto.Flight;
import com.cg.fms.dto.Passenger;
import com.cg.fms.dto.ScheduleFlight;
import com.cg.fms.exception.InvalidBookingException;
import com.cg.fms.repository.BookingRepository;
import com.cg.fms.repository.FlightRepository;
import com.cg.fms.repository.ScheduleFlightRepository;
import com.cg.fms.repository.UserRepository;

/**
 * @author nitesh
 *
 */
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private ScheduleFlightRepository scheduleRepo;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private FlightRepository flightRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(BookingServiceImpl.class);
	@Override
	public Booking addBooking(Booking booking) throws InvalidBookingException {
		
		Optional<ScheduleFlight> scheduleFlight = scheduleRepo.findById(booking.getScheduleFlight().getScheduleFlightId());
 		Optional<Flight> flight = flightRepository.findById(scheduleFlight.get().getFlight().getFlightNumber());
		if (!scheduleFlight.isPresent())
			throw new InvalidBookingException("Scheduled Flight not found!");
		else if(!flight.isPresent())
			throw new InvalidBookingException("Flight not Found");
		booking.setScheduleFlight(scheduleFlight.get());
		booking.setNoOfPassengers(booking.getPassengerList().size());
		scheduleFlight.get().setAvailableSeats(scheduleFlight.get().getAvailableSeats() - booking.getNoOfPassengers());
		scheduleRepo.save(scheduleFlight.get());
		logger.info("adding booking");
		return bookingRepository.save(booking);
	}

	@Override
	public Booking modifyBooking(Booking booking) throws InvalidBookingException{
		
		Optional<Booking> bookingUpdate = bookingRepository.findById(booking.getBookingId());
		if(!bookingUpdate.isPresent())
			throw new InvalidBookingException("Booking not found");
		bookingUpdate.get().setCancelled(booking.isCancelled());
		logger.info("saving booking");
		bookingRepository.save(bookingUpdate.get());
		return booking;
	}

	@Override
	public Booking viewBooking(BigInteger bookingId) throws InvalidBookingException {
		Optional<Booking> booking = bookingRepository.findById(bookingId);
		if (!booking.isPresent())
			throw new InvalidBookingException("Booking Not Found");
		checkBookingExpiry(booking.get());
		logger.info("Fetching booking");
		return booking.get();
	}

	@Override
	public List<Booking> viewBookingbyUserId(BigInteger userId) throws InvalidBookingException {
		
		Optional<List<Booking>> bookings;
		bookings = bookingRepository.findByUserId(userId);
		if (!bookings.isPresent())
			throw new InvalidBookingException("No Booking Found");
		for(Booking booking : bookings.get())
			checkBookingExpiry(booking);
		logger.info("fetching booking with user id "+ userId);
		return bookings.get();
	}

	@Override
	public void cancelBooking(BigInteger bookingId) throws InvalidBookingException {
	
		Optional<Booking> booking = bookingRepository.findById(bookingId);
		validateBooking(booking.get());
		if (!booking.isPresent())
			throw new InvalidBookingException("No booking found");
		booking.get().setCancelled(true);
		logger.info("Booking cancelling...");
		bookingRepository.save(booking.get());
	}

	@Override
	public void validateBooking(Booking booking) throws InvalidBookingException {

		LocalDateTime currentDate = LocalDateTime.now();
		Optional<ScheduleFlight> scheduleFlight = scheduleRepo.findById(booking.getScheduleFlight().getScheduleFlightId());
		
 		if (!scheduleFlight.isPresent()) {
			throw new InvalidBookingException("Scheduled Flight not found!");
 		}
 		else if (booking.isCancelled() && booking.isExpired()) {
			throw new InvalidBookingException("Booking Already Expired or cancelled");
 		}
 		else if(!userRepository.existsById(booking.getUserId())) {
 			throw new InvalidBookingException("User Not Found");
 		}
		else if (scheduleFlight.get().getSchedule().getDepartureDateTime().isBefore(currentDate)) {
			booking.setExpired(true);
			bookingRepository.save(booking);
			throw new InvalidBookingException("flight already depatured");
		} 
		else if ((scheduleFlight.get().getAvailableSeats() - booking.getPassengerList().size()) < 0) {
			throw new InvalidBookingException("Not enough seat available");
		}
		else if(booking.getPassengerList().isEmpty())
			throw new InvalidBookingException("Enter Atleast 1 passenger");
		

	}

	@Override
	public void validatePassenger(Passenger passenger) throws InvalidBookingException{
		
		logger.info("Validating passenger");
		if (passenger.getPassengerName() == null || passenger.getPassengerName().isEmpty())
			throw new InvalidBookingException("Name field empty");
		else if(passenger.getPassengerAge() == (null))
			throw new InvalidBookingException("Age field Empty");
		else if(passenger.getPassengerUIN() == (null))
			throw new InvalidBookingException("UIN field Empty");
		else if(passenger.getPassengerUIN().toString().length() != 12)
			throw new InvalidBookingException("UIN should have 12 digits");
	}
	
	public void checkBookingExpiry(Booking booking) {
		LocalDateTime currentDate = LocalDateTime.now();
		Optional<ScheduleFlight> scheduleFlight = scheduleRepo.findById(booking.getScheduleFlight().getScheduleFlightId());
		
		if (scheduleFlight.get().getSchedule().getDepartureDateTime().isBefore(currentDate)) {
			booking.setExpired(true);
			bookingRepository.save(booking);
		}
	}

}
