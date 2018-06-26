package com.litara.Test2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.litara.Test2.model.Category;
import com.litara.Test2.repos.CategoryRepository;
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public Category findById(Long id) {
		return categoryRepository.getOne(id);
	}

	@Override
	public List<Category> outputAll() {
		return categoryRepository.findAll();
	}

	@Override
	public void saveCategory(Category category) {
		categoryRepository.save(category);
	}

	@Override
	public void del(Long id) {
		categoryRepository.deleteById(id);
	}
	
}
