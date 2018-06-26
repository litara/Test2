package com.litara.Test2.services;

import java.util.List;

import com.litara.Test2.model.Passenger;

public interface PassengerService {
	public Passenger findByEmail(String email);
	public Passenger findByEmailAndPassword(String email, String password);
	public void saveUser(Passenger passenger);
	public List<Passenger> outputAll();
	public void del(Long id);
	public void update(Passenger passenger);
	public Passenger findById(Long id);
}
