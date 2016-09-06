package com.dao.user;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.model.user.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByUsername(String username);

}
