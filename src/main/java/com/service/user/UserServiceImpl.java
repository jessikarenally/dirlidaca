package com.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.user.UserRepository;
import com.model.user.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	public User getUserByUsername(String username){
		return userRepository.findByUsername(username);
	}

	public void save(User user) {
		userRepository.save(user);
	}
	
	public void update(User user){
		userRepository.save(user);
	}

	public User getUser(Long userId) {
		return userRepository.findOne(userId);
	}

	public void removeUser(Long userId) {
		userRepository.delete(userId);
	}

	@Override
	public long countUsers() {
		return userRepository.count();
	}
}
