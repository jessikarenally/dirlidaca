package com.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.model.Problem;

public interface ProblemService {

	public Page<Problem> findAll();

	public List<Problem> findByName(String name);
	
	public Problem findByCode(long code);
	
	public void save(Problem problem);

}
