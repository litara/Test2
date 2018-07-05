package com.litara.Test2.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.litara.Test2.model.Type;

public interface TypeRepository extends JpaRepository<Type, Long>{
	@Query("From Type where name like %:name%")
	List<Type> findByNameLike(@Param("name")String name);
}
