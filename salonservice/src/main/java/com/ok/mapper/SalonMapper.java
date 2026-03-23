package com.ok.mapper;

import com.ok.model.Salon;
import com.ok.payload.dto.SalonDTO;

public class SalonMapper {

	public static SalonDTO mapToDTO(Salon salon) {

		SalonDTO salonDTO = new SalonDTO();
		salonDTO.setId(salon.getId());
		salonDTO.setName(salon.getName());
		salonDTO.setAddress(salon.getAddress());
		salonDTO.setCity(salon.getCity());
		salonDTO.setImages(salon.getImages());
		salonDTO.setCloseTime(salon.getCloseTime());
		salonDTO.setOpeningTime(salon.getOpeningTime());
		salonDTO.setPhoneNumber(String.valueOf(salon.getPhoneNumber()));
		//salonDTO.setEmail(salon.getEmail());
		salonDTO.setOwnerId(salon.getOwnerId());
		return salonDTO;
	}
}
