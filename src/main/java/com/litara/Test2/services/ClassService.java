package com.litara.Test2.services;

import java.util.List;

import com.litara.Test2.model.Class;

public interface ClassService {
	public com.litara.Test2.model.Class findById(Long id);
	public List<com.litara.Test2.model.Class> outputAll();
	public void saveClass(com.litara.Test2.model.Class classCoach);
	public void del(Long id);
	public List<Class> findByNameLike(String name);
}
