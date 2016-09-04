package com.service;

import java.util.List;

import com.model.Solution;

public interface SolutionService {
	
	public void save(Solution solution);
	
	public void update(Solution solution);
	
	public Solution getSolution(Long solutionId);
	
	public void removeSolution(Long solutionId);

	public List<Solution> getSolutionByProblemId(Long problemId);

}
