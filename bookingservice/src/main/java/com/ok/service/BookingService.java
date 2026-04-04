package com.ok.service;

import com.ok.domain.BookingStatus;
import com.ok.model.Booking;
import com.ok.model.SalonReport;
import com.ok.payload.dto.BookingRequest;
import com.ok.payload.dto.SalonDTO;
import com.ok.payload.dto.ServiceDTO;
import com.ok.payload.dto.UserDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface BookingService {

	Booking createBooking(BookingRequest booking,
	                      UserDTO user,
	                      SalonDTO salon,
	                      Set<ServiceDTO> servicesDTOSet) throws Exception;

	List<Booking> getBookingsByCustomer(Long customerId);

	List<Booking> getBookingsBySalon(Long salonId);

	Booking getBookingById(Long bookingId) throws Exception;

	Booking updateBooking(Long bookingId, BookingStatus status) throws Exception;

	List<Booking> getBookingsByDate(LocalDate date, Long salonId);

	SalonReport getSalonReport(Long salonId);

}
