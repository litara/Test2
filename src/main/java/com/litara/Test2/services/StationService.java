package com.litara.Test2.services;

import java.util.List;

import com.litara.Test2.model.Station;

public interface StationService {
	public Station findById(Long id);
	public List<Station> outputAll();
	public void saveStation(Station station);
	public void del(Long id);
	public Station findByName(String name);
}
