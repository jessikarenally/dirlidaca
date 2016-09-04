package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Problem;
import com.model.Solution;
import com.persistence.ProblemRepository;

@Service
public class ProblemServiceImpl implements ProblemService{
	
	@Autowired
	ProblemRepository problemRepository;
	
	

	@Override
	public List<Problem> findAll() {
		List<Problem> result = new ArrayList<Problem>();
		for(Problem element:problemRepository.findAll()){
			result.add(element);
		}
		return result;
	}

	@Override
	public List<Problem> findByName(String name) {
		return problemRepository.findByName(name);
	}

	@Override
	public Problem findById(long id) {
		return problemRepository.findOne(id);
	}

	@Override
	public void save(Problem problem) {
		problemRepository.save(problem);
	}
	
	@Override
	public void removeProblem(long id){
		problemRepository.delete(id);
	}
}
