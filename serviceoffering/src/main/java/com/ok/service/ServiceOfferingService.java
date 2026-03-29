package com.ok.service;

import com.ok.model.ServiceOffering;
import com.ok.payload.dto.CategoryDTO;
import com.ok.payload.dto.SalonDTO;
import com.ok.payload.dto.ServiceDTO;

import java.util.List;
import java.util.Set;

public interface ServiceOfferingService {

	ServiceOffering createService(SalonDTO salonDTO,
	                              ServiceDTO serviceDTO,
	                              CategoryDTO categoryDTO);

	ServiceOffering updateService(Long serviceId, ServiceOffering service) throws Exception;

	Set<ServiceOffering> getAllServiceBySalon(Long salonId, Long categoryId);

	Set<ServiceOffering> getServicesByIds(Set<Long> ids);

	ServiceOffering getServiceById(Long id) throws Exception;
}
