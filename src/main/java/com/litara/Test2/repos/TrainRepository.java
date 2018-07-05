package com.litara.Test2.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.litara.Test2.model.Train;

public interface TrainRepository extends JpaRepository<Train, Long>{
	@Query("From Train where name like %:name%")
	List<Train> findByNameLike(@Param("name")String name);
}
