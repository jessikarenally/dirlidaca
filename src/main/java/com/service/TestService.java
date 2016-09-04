package com.service;

import java.util.List;

import com.model.ProblemTest;

public interface TestService {
	public List<ProblemTest> findAll();

	public ProblemTest findById(long code);
	
	public void save(ProblemTest problem);

	public void removeTest(long id);
	
}
