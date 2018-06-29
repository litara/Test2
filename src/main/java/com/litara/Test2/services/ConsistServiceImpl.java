package com.litara.Test2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.litara.Test2.model.Consist;
import com.litara.Test2.repos.ConsistRepository;

@Service("consistService")
public class ConsistServiceImpl implements ConsistService{
	@Autowired
	ConsistRepository consistRepository;
	@Override
	public Consist findById(Long id) {
		return consistRepository.getOne(id);
	}

	@Override
	public List<Consist> outputAll() {
		return consistRepository.findAll();
	}

	@Override
	public void saveConsist(Consist consist) {
		consistRepository.save(consist);
	}

	@Override
	public void del(Long id) {
		consistRepository.deleteById(id);
	}
	
}
