package com.ok.service.impl;

import com.ok.model.Category;
import com.ok.payload.dto.SalonDTO;
import com.ok.repo.CategoryRepo;
import com.ok.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

	private CategoryRepo categoryRepo;

	@Override
	public Category saveCategory(Category category, SalonDTO salonDTO) {
		return null;
	}

	@Override
	public Set<Category> getAllCategoriesBySalon(Long id) {
		return Set.of();
	}

	@Override
	public Category getCategoryById(Long id) {
		return null;
	}

	@Override
	public void deleteCategoryById(Long id) {

	}
}
