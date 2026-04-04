package com.ok.repo;

import com.ok.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepo extends JpaRepository<Booking, Long> {

	List<Booking> findByCustomerId(Long customerId);

	List<Booking> findBySalonId(Long salonId);
}
