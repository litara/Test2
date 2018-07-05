package com.litara.Test2.services;

import java.util.List;

import com.litara.Test2.model.Train;

public interface TrainService {
	public Train findById(Long id);
	public List<Train> outputAll();
	public void saveTrain(Train train);
	public void del(Long id);
	public List<Train> findByNameLike(String name);
}
