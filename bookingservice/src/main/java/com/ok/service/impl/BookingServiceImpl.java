package com.ok.service.impl;

import com.ok.domain.BookingStatus;
import com.ok.model.Booking;
import com.ok.model.SalonReport;
import com.ok.payload.dto.BookingRequest;
import com.ok.payload.dto.SalonDTO;
import com.ok.payload.dto.ServiceDTO;
import com.ok.payload.dto.UserDTO;
import com.ok.repo.BookingRepo;
import com.ok.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

	private final BookingRepo bookingRepo;

	@Override
	public Booking createBooking(BookingRequest booking,
	                             UserDTO user,
	                             SalonDTO salon,
	                             Set<ServiceDTO> servicesDTOSet) throws Exception {

		int totalDuration = servicesDTOSet.stream()
						.mapToInt(ServiceDTO::getDuration)
						.sum();

		LocalDateTime bookingStartTime = booking.getStartTime();
		LocalDateTime bookingEndTime = bookingStartTime.plusMinutes(totalDuration);

		Boolean isSlotAvailable = isTimeSlotAvailable(salon, bookingStartTime,
						bookingEndTime);

		int totalPrice = servicesDTOSet.stream()
						.mapToInt(ServiceDTO::getPrice)
						.sum();

		Set<Long> idList = servicesDTOSet.stream()
						.map(ServiceDTO::getId)
						.collect(Collectors.toSet());

		Booking newBooking = new Booking();
		newBooking.setCustomerId(user.getId());
		newBooking.setSalonId(salon.getId());
		newBooking.setServiceIds(idList);
		newBooking.setStatus(BookingStatus.PENDING);

		newBooking.setStartTime(bookingStartTime);
		newBooking.setEndTime(bookingEndTime);

		newBooking.setTotalPrice(totalPrice);

		return bookingRepo.save(newBooking);
	}

	public Boolean isTimeSlotAvailable(SalonDTO salonDTO,
	                                   LocalDateTime bookingStartTime,
	                                   LocalDateTime bookingEndTime) throws Exception {

		List<Booking> existingBookings = getBookingsBySalon(salonDTO.getId());

		LocalDateTime salonOpenTime = salonDTO.getOpenTime().
						atDate(bookingStartTime.toLocalDate());

		//!
		LocalDateTime salonCloseTime = salonDTO.getCloseTime().
						atDate(bookingEndTime.toLocalDate());

		if(bookingStartTime.isBefore(salonOpenTime) || bookingEndTime.isAfter(salonCloseTime)) {

			throw new Exception("Booking time must be within salons's working hour");
		}

		for(Booking existingBooking : existingBookings) {
			LocalDateTime existingBookingStartTime = existingBooking.getStartTime();
			LocalDateTime existingBookingEndTime = existingBooking.getEndTime();

			if (bookingStartTime.isBefore(existingBookingEndTime)
					&& bookingEndTime.isAfter(existingBookingStartTime)) {

				throw new Exception("Slot not available, choose different time!");
			}

			if (bookingStartTime.isEqual(existingBookingStartTime)
			   || bookingEndTime.isEqual(existingBookingEndTime)) {

				throw new Exception("Slot not available, choose different time!");
			}

		}
		return true;
	}

	@Override
	public List<Booking> getBookingsByCustomer(Long customerId) {
		return bookingRepo.findByCustomerId(customerId);
	}

	@Override
	public List<Booking> getBookingsBySalon(Long salonId) {
		return bookingRepo.findBySalonId(salonId);
	}

	@Override
	public Booking getBookingById(Long bookingId) throws Exception {

		Booking booking = bookingRepo.findById(bookingId).orElse(null);
		if(booking == null) {
			throw new Exception("Booking not found!");
		}

		return booking;
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
