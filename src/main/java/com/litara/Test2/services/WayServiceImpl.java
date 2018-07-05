package com.litara.Test2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.litara.Test2.model.Train;
import com.litara.Test2.model.Way;
import com.litara.Test2.repos.WayRepository;

@Service("wayService")
public class WayServiceImpl implements WayService{
	@Autowired
	WayRepository wayRepository;

	@Override
	public Way findById(Long id) {
		return wayRepository.getOne(id);
	}

	@Override
	public List<Way> outputAll() {
		return wayRepository.findAll();
	}

	@Override
	public void saveWay(Way way) {
		wayRepository.save(way);
	}

	@Override
	public void del(Long id) {
		wayRepository.deleteById(id);
	}

	@Override
	public List<Way> findByTrainName(String name) {
		return wayRepository.findByTrainName(name);
	}
	
}
