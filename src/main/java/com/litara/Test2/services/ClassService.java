package com.litara.Test2.services;

import java.util.List;

public interface ClassService {
	public com.litara.Test2.model.Class findById(Long id);
	public List<com.litara.Test2.model.Class> outputAll();
	public void saveClass(com.litara.Test2.model.Class classCoach);
	public void del(Long id);
}
