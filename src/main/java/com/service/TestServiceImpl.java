package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.ProblemTest;
import com.persistence.TestRepository;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	TestRepository testRepository;
	
	@Override
	public List<ProblemTest> findAll() {
		List<ProblemTest> tests = testRepository.findAll();
		return tests;
	}

	@Override
	public ProblemTest findById(long id) {
		return testRepository.findOne(id);
	}

	@Override
	public void save(ProblemTest test) {
		testRepository.save(test);

	}

	@Override
	public void removeTest(long id) {
		testRepository.delete(id);
	}

}
