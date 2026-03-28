package com.ok.repo;

import com.ok.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepo extends JpaRepository<Category, Long> {

	List<Category> findBySalonId(Long salonId);

}
