package com.service.user;

import java.util.List;

import com.model.user.User;

public interface UserService {
	
	
	public User getUserByUsername(String username);

	public void save(User user);
	
	public void update(User user);

	public User getUser(Long userId); 

	public void removeUser(Long userId); 
	
	public long countUsers();

}
