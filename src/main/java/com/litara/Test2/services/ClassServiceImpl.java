package com.litara.Test2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.litara.Test2.model.Class;
import com.litara.Test2.repos.ClassRepository;
@Service("classService")
public class ClassServiceImpl implements ClassService{
	@Autowired
	ClassRepository classRepository;

	@Override
	public Class findById(Long id) {
		return classRepository.getOne(id);
	}

	@Override
	public List<Class> outputAll() {
		return classRepository.findAll();
	}

	@Override
	public void saveClass(Class classCoach) {
		classRepository.save(classCoach);
	}

	@Override
	public void del(Long id) {
		classRepository.deleteById(id);
	}
	
}
