package com.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.model.Problem;

public interface ProblemRepository extends CrudRepository<Problem, Long>{
	
	List<Problem> findAll();
	List<Problem> findByName(String name);

}
