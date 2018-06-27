package com.litara.Test2.services;

import java.util.List;

import com.litara.Test2.model.Station;
import com.litara.Test2.model.Timetable;

public interface TimetableService {
	public Timetable findById(Long id);
	public List<Timetable> outputAll();
	public void saveTimetable(Timetable timetable);
	public void del(Long id);
}
