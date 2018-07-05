package com.litara.Test2.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.litara.Test2.model.Train;
import com.litara.Test2.model.Way;

public interface WayRepository extends JpaRepository<Way, Long>{
	@Query("From Way where train.name like %:name%")
	List<Way> findByTrainName(@Param("name")String name);
}
