package com.ok.controller;

import com.ok.domain.BookingStatus;
import com.ok.mapper.BookingMapper;
import com.ok.model.Booking;
import com.ok.payload.dto.*;
import com.ok.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

  private final BookingService bookingService;

	@PostMapping
  public ResponseEntity<Booking> createBooking(
					@RequestParam Long salonId,
					@RequestBody BookingRequest bookingRequest) throws Exception {

		UserDTO user = new UserDTO();
		user.setId(1L);

		SalonDTO salon = new SalonDTO();
		salon.setId(salonId);

		Set<ServiceDTO> serviceDTOSet = new HashSet<>();

		ServiceDTO serviceDTO = new ServiceDTO();
		serviceDTO.setId(1L);
		serviceDTO.setPrice(399);
		serviceDTO.setDuration(45);
		serviceDTO.setName("Haircut for men");

		serviceDTOSet.add(serviceDTO);

		Booking booking = bookingService.createBooking(
													bookingRequest,
													user,
													salon,
													serviceDTOSet);

		return ResponseEntity.ok(booking);
	}

	@GetMapping("/customer")
  public ResponseEntity<Set<BookingDTO>> getBookingsByCustomer() {

		List<Booking> bookings = bookingService.getBookingsByCustomer(1l);

		return ResponseEntity.ok(getBookingDTOs(bookings));
	}

	@GetMapping("/salon")
	public ResponseEntity<Set<BookingDTO>> getBookingsBySalon() {

		List<Booking> bookings = bookingService.getBookingsBySalon(1l);

		return ResponseEntity.ok(getBookingDTOs(bookings));
	}

	@GetMapping("/{bookingId}")
	public ResponseEntity<BookingDTO> getBookingsById(
					@PathVariable Long bookingId) throws Exception {

		Booking booking = bookingService.getBookingById(bookingId);

		return ResponseEntity.ok(BookingMapper.toDTO(booking));
	}

	@GetMapping("/slots/salon/{salonId}/date/{date}")
	public ResponseEntity<List<BookingSlotDTO>> getBookingsSlot(
					@PathVariable Long salonId,
					@RequestParam LocalDate date) throws Exception {

		List<Booking> bookings = bookingService.getBookingsByDate(date, salonId);

		List<BookingSlotDTO> slotDTOs = bookings.stream()
						.map(booking -> {
							BookingSlotDTO slotDTO = new BookingSlotDTO();
							slotDTO.setStartTime(booking.getStartTime());
							slotDTO.setEndTime(booking.getEndTime());
							return slotDTO;
						}).collect(Collectors.toList());

		return ResponseEntity.ok(slotDTOs);
	}

	@PutMapping("/{bookingId}/status")
	public ResponseEntity<BookingDTO> updateBookingStatus(
					@PathVariable Long bookingId,
					@RequestParam BookingStatus status) throws  Exception {

		Booking booking = bookingService.updateBooking(bookingId, status);

		return ResponseEntity.ok(BookingMapper.toDTO(booking));
	}

	private Set<BookingDTO> getBookingDTOs(List<Booking> bookings) {

		return bookings.stream()
						.map(booking -> {
							return BookingMapper.toDTO(booking);
						}).collect(Collectors.toSet());
	}
}
