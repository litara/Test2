package com.litara.Test2.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.litara.Test2.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	@Query("From Category where name like %:name%")
	List<Category> findByNameLike(@Param("name")String name);
}
