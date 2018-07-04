package com.litara.Test2.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.litara.Test2.model.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long>{
	Passenger findByEmail(String email);
	Passenger findByEmailAndPassword(String email, String password);
	List<Passenger> findByName(String name);
	@Query("From Passenger where name like %:name%")
	List<Passenger> findByNameLike(@Param("name") String name);
}
