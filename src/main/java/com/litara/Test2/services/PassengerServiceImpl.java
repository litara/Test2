package com.litara.Test2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.litara.Test2.model.Passenger;
import com.litara.Test2.repos.PassengerRepository;
@Service("passengerService")
public class PassengerServiceImpl implements PassengerService{
	@Autowired
	private PassengerRepository passengerRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
	public Passenger findByEmail(String email) {
		return passengerRepository.findByEmail(email);
	}

	@Override
	public Passenger findByEmailAndPassword(String email, String password) {
		return passengerRepository.findByEmailAndPassword(email, password);
	}

	@Override
	public void saveUser(Passenger passenger) {
		passenger.setPassword(bCryptPasswordEncoder.encode(passenger.getPassword()));
		passenger.setActive(1);
		passenger.setRole("PASSENGER");
		passengerRepository.save(passenger);
	}

	@Override
	public List<Passenger> outputAll() {
		return passengerRepository.findAll();
	}
	
	public void del(Long id) {
		passengerRepository.deleteById(id);
	}

	@Override
	public void update(Passenger passenger) {
		passengerRepository.save(passenger);
	}

	@Override
	public Passenger findById(Long id) {
		Passenger passenger = passengerRepository.getOne(id);
		return passenger;
	}
	
}
