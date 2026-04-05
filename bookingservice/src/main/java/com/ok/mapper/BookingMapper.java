package com.ok.mapper;

import com.ok.model.Booking;
import com.ok.payload.dto.BookingDTO;

public class BookingMapper {

	public static BookingDTO toDTO(Booking booking) {

		BookingDTO bookingDTO = new BookingDTO();

		bookingDTO.setId(booking.getId());
		bookingDTO.setCustomerId(booking.getCustomerId());
		bookingDTO.setStatus(booking.getStatus());
		bookingDTO.setStartTime(booking.getStartTime());
		bookingDTO.setEndTime(booking.getEndTime());
		bookingDTO.setSalonId(booking.getSalonId());
		bookingDTO.setServiceIds(booking.getServiceIds());

		return bookingDTO;
	}
}
