package com.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.User;
import com.service.UserServiceImpl;

@Api
@RestController
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	UserServiceImpl userService;
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<User> addUser(@RequestBody User user){
		userService.save(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(){
		return String.format("Logado");
	}
	
	@ApiOperation(value = "userId", nickname = "userId")
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable Long userId){
		User user = userService.getUser(userId);
		return user != null ? new ResponseEntity<User>(user,HttpStatus.OK) : new ResponseEntity<User>(user,HttpStatus.NOT_FOUND); 
	}

	@ApiOperation(value = "userId", nickname = "userId")
	@RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteUser(@PathVariable Long userId){
		userService.removeUser(userId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "userId", nickname = "userId")
	@RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
	public ResponseEntity<User> setUser(@PathVariable Long userId,@RequestBody User user){
		userService.update(user);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}

}
