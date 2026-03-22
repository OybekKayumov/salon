package com.ok.service.impl;

import com.ok.model.Salon;
import com.ok.payload.dto.SalonDTO;
import com.ok.payload.dto.UserDTO;
import com.ok.repo.SalonRepo;
import com.ok.service.SalonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalonServiceImpl implements SalonService {

	private final SalonRepo salonRepo;

	@Override
	public Salon createSalon(SalonDTO salon, UserDTO user) {
		return null;
	}

	@Override
	public Salon updateSalon(SalonDTO salon, UserDTO user, Long salonId) {
		return null;
	}

	@Override
	public List<Salon> getAllSalons() {
		return List.of();
	}

	@Override
	public Salon getSalonById(Long salonId) {
		return null;
	}

	@Override
	public void deleteSalonById(Long salonId) {

	}

	@Override
	public Salon getSalonByOwnerId(Long ownerId) {
		return null;
	}

	@Override
	public List<Salon> searchSalonByCity(String city) {
		return List.of();
	}
}
