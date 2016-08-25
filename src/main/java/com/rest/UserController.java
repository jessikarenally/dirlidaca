package com.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
@RequestMapping(value="/user")
public class UserController {
	
	
	@RequestMapping(method = RequestMethod.POST)
	public String addUser(){
		return String.format("created");
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(){
		return String.format("Logado");
	}
	
	@ApiOperation(value = "userId", nickname = "userId")
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public String getUser(@PathVariable Long userId){
		return String.format("Id user passado: %s", userId);
	}

	@ApiOperation(value = "userId", nickname = "userId")
	@RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable Long userId){
		return String.format("Id user passado: %s", userId);
	}
	
	@ApiOperation(value = "userId", nickname = "userId")
	@RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
	public String setUser(@PathVariable Long userId){
		return String.format("Id userId passado: %s", userId);
	}

}
