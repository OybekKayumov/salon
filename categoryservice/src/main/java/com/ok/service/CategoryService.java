package com.ok.service;

import com.ok.model.Category;
import com.ok.payload.dto.SalonDTO;

import java.util.List;
import java.util.Set;

public interface CategoryService {

	Category saveCategory(Category category, SalonDTO salonDTO);

	Set<Category> getAllCategoriesBySalon(Long id);

	Category getCategoryById(Long id);

	void deleteCategoryById(Long id);
}
