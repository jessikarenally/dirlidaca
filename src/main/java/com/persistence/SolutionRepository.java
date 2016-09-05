package com.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.model.Solution;

public interface SolutionRepository extends  CrudRepository<Solution, Long>{

	List<Solution> findByProblemId(Long problemId);

	List<Solution> findByUserId(Long userId);

}
