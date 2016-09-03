package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Solution;
import com.persistence.SolutionRepository;

@Service
public class SolutionServiceImpl implements SolutionService{

	@Autowired
	SolutionRepository solutionRepository;
	
	@Override
	public void save(Solution solution) {
		solutionRepository.save(solution);
	}

	@Override
	public void update(Solution solution) {
		save(solution);
	}

	@Override
	public Solution getSolution(Long solutionId) {
		return solutionRepository.findOne(solutionId);
	}

	@Override
	public void removeSolution(Long solutionId) {
		solutionRepository.delete(solutionId);
	}
	
	@Override
	public List<Solution> getSolutionByProblemId(Long problemId) {
		return solutionRepository.findByProblemId(problemId);
	}

}
