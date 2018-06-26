package com.litara.Test2.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.litara.Test2.model.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long>{
	Passenger findByEmail(String email);
	Passenger findByEmailAndPassword(String email, String password);
}
