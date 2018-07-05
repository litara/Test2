package com.litara.Test2.services;

import java.util.List;

import com.litara.Test2.model.Train;
import com.litara.Test2.model.Way;

public interface WayService {
	public Way findById(Long id);
	public List<Way> outputAll();
	public void saveWay(Way way);
	public void del(Long id);
	public List<Way> findByTrainName(String name);
}
