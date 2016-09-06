package com.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByUsername(String username);

}
