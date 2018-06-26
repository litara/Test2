package com.litara.Test2.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.litara.Test2.model.Passenger;
import com.litara.Test2.repos.PassengerRepository;
@Service
public class MyUserDetailsService implements UserDetailsService{
	@Autowired
	private PassengerService passengerRepository;
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Passenger passenger = passengerRepository.findByEmail(userName);
		GrantedAuthority authority = new SimpleGrantedAuthority(passenger.getRole());
		UserDetails userDetails = (UserDetails) new User(passenger.getEmail(), passenger.getPassword(), Arrays.asList(authority));
		return userDetails;
	}
	
}
