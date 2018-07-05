package com.litara.Test2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.litara.Test2.model.Station;
import com.litara.Test2.repos.StationRepository;
@Service("stationService")
public class StationServiceImpl implements StationService{
	@Autowired
	StationRepository stationRepository;
	@Override
	public Station findById(Long id) {
		return stationRepository.getOne(id);
	}

	@Override
	public Station findByName(String name) {
		return stationRepository.findByName(name);
	}

	@Override
	public List<Station> outputAll() {
		return stationRepository.findAll();
	}

	@Override
	public void saveStation(Station station) {
		stationRepository.save(station);
	}

	@Override
	public void del(Long id) {
		stationRepository.deleteById(id);
	}

	@Override
	public List<Station> findByNameLike(String name) {
		return stationRepository.findByNameLike(name);
	}
	
}
