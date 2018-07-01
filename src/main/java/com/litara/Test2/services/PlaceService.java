package com.litara.Test2.services;

import java.util.List;

import com.litara.Test2.model.Place;


public interface PlaceService {
	public Place findById(Long id);
	public List<Place> outputAll();
	public void savePlace(Place place);
	public void del(Long id);
}
