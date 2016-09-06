package com.service.problem;

import java.util.List;

import com.model.problem.Problem;

public interface ProblemService {

	public List<Problem> findAll();

	public List<Problem> findByName(String name);
	
	public Problem findById(long code);
	
	public void save(Problem problem);

	public void removeProblem(long id);
	
	public long countProblems();

}
