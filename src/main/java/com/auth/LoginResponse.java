package com.auth;

public class LoginResponse {
    
	private String token;

    public LoginResponse(final String token) {
        this.token = token;
    }
    
    public String getToken(){
    	return this.token;
    }
}