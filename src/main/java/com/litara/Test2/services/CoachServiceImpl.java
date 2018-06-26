package com.litara.Test2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.litara.Test2.model.Coach;
import com.litara.Test2.repos.CoachRepository;

@Service("coachService")
public class CoachServiceImpl implements CoachService{
	@Autowired
	CoachRepository coachRepository;
	@Override
	public Coach findById(Long id) {
		return coachRepository.getOne(id);
	}

	@Override
	public List<Coach> outputAll() {
		return coachRepository.findAll();
	}

	@Override
	public void saveCoach(Coach coach) {
		coachRepository.save(coach);
	}

	@Override
	public void del(Long id) {
		coachRepository.deleteById(id);
	}
	
}
