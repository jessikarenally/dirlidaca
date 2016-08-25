package com.service;

import java.util.List;

import com.model.Problem;

public interface ProblemService {

	public List<Problem> findAll();

	public List<Problem> findByName(String name);
	
	public Problem findByCode(long code);
	
	public void save(Problem problem);
}
