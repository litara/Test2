package com.litara.Test2.services;

import java.util.List;

import com.litara.Test2.model.Coach;

public interface CoachService {
	public Coach findById(Long id);
	public List<Coach> outputAll();
	public void saveCoach(Coach coach);
	public void del(Long id);
}
