package com.litara.Test2.repos;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.litara.Test2.model.Timetable;

public interface TimetableRepository extends JpaRepository<Timetable, Long>{
	Timetable findByDate(Date date);
}
