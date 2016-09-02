package com.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.model.Solution;

public interface SolutionRepository extends  CrudRepository<Solution, Long>{

	Solution save(Solution test);
	Solution findById(long id);
	List<Solution> findAll();
}
