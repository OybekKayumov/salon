package com.ok.service.impl;

import com.ok.domain.BookingStatus;
import com.ok.model.Booking;
import com.ok.model.SalonReport;
import com.ok.payload.dto.BookingRequest;
import com.ok.payload.dto.SalonDTO;
import com.ok.payload.dto.ServiceDTO;
import com.ok.payload.dto.UserDTO;
import com.ok.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {


	@Override
	public Booking createBooking(BookingRequest booking, UserDTO user, SalonDTO salon, Set<ServiceDTO> servicesDTOSet) {
		return null;
	}

	@Override
	public List<Booking> getBookingsByCustomer(Long customerId) {
		return List.of();
	}

	@Override
	public List<Booking> getBookingsBySalon(Long salonId) {
		return List.of();
	}

	@Override
	public Booking getBookingById(Long bookingId) {
		return null;
	}

	@Override
	public Booking updateBooking(Long bookingId, BookingStatus status) {
		return null;
	}

	@Override
	public Booking getBookingsByDate(LocalDate date, Long salonId) {
		return null;
	}

	@Override
	public SalonReport getSalonReport(Long salonId) {
		return null;
	}
}
