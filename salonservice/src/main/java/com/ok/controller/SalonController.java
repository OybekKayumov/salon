package com.ok.controller;

import com.ok.mapper.SalonMapper;
import com.ok.model.Salon;
import com.ok.payload.dto.SalonDTO;
import com.ok.payload.dto.UserDTO;
import com.ok.service.SalonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/salons")
@RequiredArgsConstructor
public class SalonController {

	private final SalonService salonService;

	@PostMapping
	public ResponseEntity<SalonDTO> createSalon(@RequestBody SalonDTO salonDTO) {

		UserDTO userDTO = new UserDTO();
		userDTO.setId(1L);

		Salon salon = salonService.createSalon(salonDTO, userDTO);

		SalonDTO salonDTO1 = SalonMapper.mapToDTO(salon);

		return ResponseEntity.ok(salonDTO1);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<SalonDTO> updateSalon(
					@PathVariable("id") Long salonId,
					@RequestBody SalonDTO salonDTO) throws Exception {

		UserDTO userDTO = new UserDTO();
		userDTO.setId(1L);

		Salon salon = salonService.updateSalon(salonDTO, userDTO, salonId);

		SalonDTO salonDTO1 = SalonMapper.mapToDTO(salon);

		return ResponseEntity.ok(salonDTO1);
	}
}
