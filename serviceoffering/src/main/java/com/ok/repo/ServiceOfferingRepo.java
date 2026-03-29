package com.ok.repo;

import com.ok.model.ServiceOffering;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ServiceOfferingRepo extends JpaRepository<ServiceOffering, Long> {

	Set<ServiceOffering> findBySalonId(Long salonId);
}
