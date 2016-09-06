package com.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private long id;
	@Column()
	private String username;
	@Column
	private String email;
	@Column
	private String password;
	@Column
	private String name;
	
	public User(){
	}
	
	public User(String username,String email){
		this.username = username;
		this.email = email;
	}
	public User(String username,String email,String password){
		this.username = username;
		this.email = email;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public long getId() {
		return this.id;
	}
	

}
