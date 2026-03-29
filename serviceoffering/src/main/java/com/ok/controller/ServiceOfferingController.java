package com.ok.controller;

import com.ok.model.ServiceOffering;
import com.ok.repo.ServiceOfferingRepo;
import com.ok.service.ServiceOfferingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/service-offering")
@RequiredArgsConstructor
public class ServiceOfferingController {

	private final ServiceOfferingService serviceOfferingService;

	@GetMapping("/salon/{salonId}")
	public ResponseEntity<Set<ServiceOffering>> getServicesBySalonId(
					@PathVariable Long salonId,
					@RequestParam(required = false) Long categoryId) throws Exception{

		Set<ServiceOffering> serviceOfferings = serviceOfferingService.
						getAllServiceBySalon(salonId, categoryId);

		return ResponseEntity.ok(serviceOfferings);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ServiceOffering> getServiceById(
					@PathVariable Long id) throws Exception{

		ServiceOffering serviceOffering = serviceOfferingService.
						getServiceById(id);

		return ResponseEntity.ok(serviceOffering);
	}

	@GetMapping("/list/{ids}")
	public ResponseEntity<Set<ServiceOffering>> getServicesByIds(
					@PathVariable Set<Long> ids) throws Exception{

		Set<ServiceOffering> serviceOfferings = serviceOfferingService.
						getServicesByIds(ids);

		return ResponseEntity.ok(serviceOfferings);
	}

}
