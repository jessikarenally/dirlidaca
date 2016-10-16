package com.service.solution;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.kafka.support.KafkaNull;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

import com.Application;
import com.dao.solution.SolutionRepository;
import com.model.solution.Solution;


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

	public List<Solution> getSolutionsByUserId(Long userId) {
		return solutionRepository.findByUserId(userId);
	}		
}
