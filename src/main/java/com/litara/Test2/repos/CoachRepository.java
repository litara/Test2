package com.litara.Test2.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.litara.Test2.model.Coach;

public interface CoachRepository extends JpaRepository<Coach, Long>{
	
}
