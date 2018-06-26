package com.litara.Test2.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.litara.Test2.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
