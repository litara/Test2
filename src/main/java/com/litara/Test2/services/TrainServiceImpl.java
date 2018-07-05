package com.litara.Test2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.litara.Test2.model.Train;
import com.litara.Test2.repos.TrainRepository;
@Service("trainService")
public class TrainServiceImpl implements TrainService{
	@Autowired
	TrainRepository trainRepo;
	@Override
	public Train findById(Long id) {
		Train train = trainRepo.getOne(id);
		return train;
	}

	@Override
	public List<Train> outputAll() {
		return trainRepo.findAll();
	}

	@Override
	public void saveTrain(Train train) {
		trainRepo.save(train);
	}

	@Override
	public void del(Long id) {
		trainRepo.deleteById(id);
		
	}

	@Override
	public List<Train> findByNameLike(String name) {
		return trainRepo.findByNameLike(name);
	}
	
}
