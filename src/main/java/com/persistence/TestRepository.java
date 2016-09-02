package com.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.model.Test;

public interface TestRepository extends CrudRepository<Test, Long>{

	Test save(Test test);
	Test findById(long id);
	List<Test> findAll();
}
