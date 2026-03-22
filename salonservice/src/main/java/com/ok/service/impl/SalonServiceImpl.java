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
	public Salon createSalon(SalonDTO req, UserDTO user) {
		Salon salon = new Salon();
		salon.setName(req.getName());
		salon.setAddress(req.getAddress());
		salon.setEmail(req.getEmail());
		salon.setCity(req.getCity());
		salon.setImages(req.getImages());
		salon.setOwnerId(user.getId());
		salon.setOpeningTime(req.getOpeningTime());
		salon.setCloseTime(req.getCloseTime());
		salon.setPhoneNumber(req.getPhoneNumber());

		return salonRepo.save(salon);
	}

	@Override
	public Salon updateSalon(SalonDTO salon, UserDTO user, Long salonId) throws Exception {

		Salon existingSalon = salonRepo.findById(salonId).orElse(null);

		if(existingSalon != null && salon.getOwnerId().equals(user.getId())) {

			existingSalon.setCity(salon.getCity());
			existingSalon.setName(salon.getName());
			existingSalon.setAddress(salon.getAddress());
			existingSalon.setEmail(salon.getEmail());
			existingSalon.setImages(salon.getImages());
			existingSalon.setOpeningTime(salon.getOpeningTime());
			existingSalon.setCloseTime(salon.getCloseTime());
			existingSalon.setOwnerId(user.getId());
			existingSalon.setPhoneNumber(salon.getPhoneNumber());
		}

		throw new Exception("Salon not exists!");
	}

	@Override
	public List<Salon> getAllSalons() {
		return salonRepo.findAll();
	}

	@Override
	public Salon getSalonById(Long salonId) throws Exception {
		Salon salon = salonRepo.findById(salonId).orElse(null);
		if(salon == null) {
			throw new Exception("Salon not exist");
		}
		return salon;
	}

	@Override
	public void deleteSalonById(Long salonId) {

	}

	@Override
	public Salon getSalonByOwnerId(Long ownerId) {
		return salonRepo.findByOwnerId(ownerId);
	}

	@Override
	public List<Salon> searchSalonByCity(String city) {
		return salonRepo.searchSalons(city);
	}
}
