package com.persistence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;

import com.model.Problem;

public interface ProblemRepository extends CrudRepository<Problem, Long>{
	
	<S extends Problem> S save(Problem problem);
	Problem findByCode(long code);
	void deleteAll();
	Page<Problem> findAll();
	List<Problem> findByName(String name);

}
