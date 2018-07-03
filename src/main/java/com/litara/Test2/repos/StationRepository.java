package com.litara.Test2.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.litara.Test2.model.Station;

public interface StationRepository extends JpaRepository<Station, Long>{
	Station findByName(String name);
}
