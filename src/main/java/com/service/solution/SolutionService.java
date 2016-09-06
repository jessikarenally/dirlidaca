package com.service.solution;

import java.util.List;

import com.model.solution.Solution;

public interface SolutionService {
	
	public void save(Solution solution);
	
	public void update(Solution solution);
	
	public Solution getSolution(Long solutionId);
	
	public void removeSolution(Long solutionId);

	public List<Solution> getSolutionByProblemId(Long problemId);

}
