package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.model.Problem;
import com.persistence.ProblemRepository;

@Service
public class ProblemServiceImpl implements ProblemService{
	
	@Autowired
	ProblemRepository problemRepository;

	@Override
	public Page<Problem> findAll() {
		return problemRepository.findAll();
	}

	@Override
	public List<Problem> findByName(String name) {
		return problemRepository.findByName(name);
	}

	@Override
	public Problem findByCode(long code) {
		return problemRepository.findByCode(code);
	}

	@Override
	public void save(Problem problem) {
	}

}