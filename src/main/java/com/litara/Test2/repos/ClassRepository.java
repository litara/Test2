package com.litara.Test2.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClassRepository extends JpaRepository<com.litara.Test2.model.Class, Long> {
	@Query("From Class where name like %:name%")
	List<com.litara.Test2.model.Class> findByNameLike(@Param("name")String name);
}
