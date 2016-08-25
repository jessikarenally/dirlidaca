package com.persistence;

import org.springframework.data.repository.CrudRepository;

import com.model.Problem;

public interface ProblemRepository extends CrudRepository<Problem, Long>{
	
	Problem findByCode();
}
