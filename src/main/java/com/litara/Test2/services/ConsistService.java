package com.litara.Test2.services;

import java.util.List;

import com.litara.Test2.model.Consist;

public interface ConsistService {
	public Consist findById(Long id);
	public List<Consist> outputAll();
	public void saveConsist(Consist consist);
	public void del(Long id);
}
