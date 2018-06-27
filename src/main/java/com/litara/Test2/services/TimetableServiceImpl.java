package com.litara.Test2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.litara.Test2.model.Timetable;
import com.litara.Test2.repos.TimetableRepository;

@Service("timetableService")
public class TimetableServiceImpl implements TimetableService{
	@Autowired 
	TimetableRepository timetableRepository;

	@Override
	public Timetable findById(Long id) {
		return timetableRepository.getOne(id);
	}

	@Override
	public List<Timetable> outputAll() {
		return timetableRepository.findAll();
	}

	@Override
	public void saveTimetable(Timetable timetable) {
		timetableRepository.save(timetable);
		
	}

	@Override
	public void del(Long id) {
		timetableRepository.deleteById(id);
	}
	
}
