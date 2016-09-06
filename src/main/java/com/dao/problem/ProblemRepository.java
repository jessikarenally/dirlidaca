package com.dao.problem;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.model.problem.Problem;

public interface ProblemRepository extends CrudRepository<Problem, Long>{
	
	List<Problem> findAll();
	
	List<Problem> findByName(String name);
	
	long count();
}
