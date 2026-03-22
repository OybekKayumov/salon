package com.ok.service;

import com.ok.model.Salon;
import com.ok.payload.dto.SalonDTO;
import com.ok.payload.dto.UserDTO;

import java.util.List;

public interface SalonService {

	Salon createSalon(SalonDTO salon, UserDTO user);

	Salon updateSalon(SalonDTO salon, UserDTO user, Long salonId) throws Exception;

	List<Salon> getAllSalons();

	Salon getSalonById(Long salonId) throws Exception;

	void deleteSalonById(Long salonId);

	Salon getSalonByOwnerId(Long ownerId);

	List<Salon> searchSalonByCity(String city);
}
