package com.ok.service.impl;

import com.ok.model.Category;
import com.ok.payload.dto.SalonDTO;
import com.ok.repo.CategoryRepo;
import com.ok.service.CategoryService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

	private CategoryRepo categoryRepo;

	@Override
	public Category saveCategory(Category category, SalonDTO salonDTO) {

		Category newCategory = new Category();
		newCategory.setName(category.getName());
		newCategory.setSalonId(salonDTO.getId());
		newCategory.setImage(category.getImage());

		return categoryRepo.save(newCategory);
	}

	@Override
	public Set<Category> getAllCategoriesBySalon(Long id) {

		return categoryRepo.findBySalonId(id);
	}

	@Override
	public Category getCategoryById(Long id) throws Exception {
		Category category = categoryRepo.findById(id).orElse(null);

		if (category == null) {
			throw new Exception("Category with id: " + id + " not found");
		}

		return category;
	}

	@Override
	public void deleteCategoryById(Long id, Long salonId) throws Exception {

		Category category = getCategoryById(id);

		if (category.getSalonId().equals(salonId)) {
			throw new Exception("You can't delete category with id: " + id + " and salon: " + salonId);
		}

		categoryRepo.deleteById(id);
	}
}
