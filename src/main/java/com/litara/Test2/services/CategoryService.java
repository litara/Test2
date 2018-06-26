package com.litara.Test2.services;

import java.util.List;

import com.litara.Test2.model.Category;
import com.litara.Test2.model.Station;

public interface CategoryService {
	public Category findById(Long id);
	public List<Category> outputAll();
	public void saveCategory(Category category);
	public void del(Long id);
}
