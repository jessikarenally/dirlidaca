package com.service.test;

import java.util.List;

import com.model.test.ProblemTest;

public interface TestService {
	public List<ProblemTest> findAll();

	public ProblemTest findById(long code);
	
	public void save(ProblemTest problem);

	public void removeTest(long id);
	
	public List<ProblemTest> findByProblemCode(long problemCode);
	
}
