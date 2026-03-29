package com.ok.service;

import com.ok.model.Booking;
import com.ok.payload.dto.BookingRequest;
import com.ok.payload.dto.SalonDTO;
import com.ok.payload.dto.ServiceDTO;
import com.ok.payload.dto.UserDTO;

import java.util.Set;

public interface BookingService {

	Booking createBooking(BookingRequest booking,
	                      UserDTO user,
	                      SalonDTO salon,
	                      Set<ServiceDTO> servicesDTOSet);


}
