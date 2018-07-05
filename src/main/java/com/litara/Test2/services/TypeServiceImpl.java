package com.litara.Test2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.litara.Test2.model.Type;
import com.litara.Test2.repos.TypeRepository;
@Service("typeService")
public class TypeServiceImpl implements TypeService{
	@Autowired
	TypeRepository typeRepository;

	@Override
	public Type findById(Long id) {
		return typeRepository.getOne(id);
	}

	@Override
	public List<Type> outputAll() {
		return typeRepository.findAll();
	}

	@Override
	public void saveType(Type type) {
		typeRepository.save(type);
		
	}

	@Override
	public void del(Long id) {
		typeRepository.deleteById(id);
	}

	@Override
	public List<Type> findByNameLike(String name) {
		return typeRepository.findByNameLike(name);
	}
	
}
