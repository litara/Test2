package com.litara.Test2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.litara.Test2.model.Place;
import com.litara.Test2.repos.PlaceRepository;

@Service("placeService")
public class PlaceServiceImpl implements PlaceService{
	@Autowired
	PlaceRepository placeRepository;

	@Override
	public Place findById(Long id) {
		return placeRepository.getOne(id);
	}

	@Override
	public List<Place> outputAll() {
		return placeRepository.findAll();
	}

	@Override
	public void savePlace(Place place) {
		placeRepository.save(place);
		
	}

	@Override
	public void del(Long id) {
		placeRepository.deleteById(id);
		
	}
	
}
