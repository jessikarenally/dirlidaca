package com.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Problem implements Serializable {
	/**
	 * 
	 */
	public Problem(String name, String description, String hint, long code, List<Test> publicTests){
		this.name = name;
		this.description = description;
		this.hint=hint;
		this.code = code;
		this.publicTests = publicTests;
	}
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private long code;
	@Column
	private String description;
	@Column
	private String hint;
	@Column
	private List<Test> publicTests;
	
	@Column
	private String name;
	
	public Problem(){}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getCode() {
		return code;
	}
	public void setCode(long code) {
		this.code = code;
	}
	public String getHint() {
		return hint;
	}
	public void setHint(String hint) {
		this.hint = hint;
	}

	public List<Test> getPublicTests() {
		return publicTests;
	}

	public void setPublicTests(List<Test> publicTests) {
		this.publicTests = publicTests;
	}
}
