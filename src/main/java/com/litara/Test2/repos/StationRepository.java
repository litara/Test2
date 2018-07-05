package com.litara.Test2.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.litara.Test2.model.Station;

public interface StationRepository extends JpaRepository<Station, Long>{
	Station findByName(String name);
	@Query("From Station where name like %:name%")
	List<Station> findByNameLike(@Param("name")String name);
}
