package com.dao.test;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.model.test.ProblemTest;

public interface TestRepository extends CrudRepository<ProblemTest, Long>{

	ProblemTest save(ProblemTest test);
	ProblemTest findById(long id);
	List<ProblemTest> findAll();
	List<ProblemTest> findByProblemCode(long problemCode);
}
