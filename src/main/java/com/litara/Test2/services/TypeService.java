package com.litara.Test2.services;

import java.util.List;

import com.litara.Test2.model.Station;
import com.litara.Test2.model.Type;

public interface TypeService {
	public Type findById(Long id);
	public List<Type> outputAll();
	public void saveType(Type type);
	public void del(Long id);
}
