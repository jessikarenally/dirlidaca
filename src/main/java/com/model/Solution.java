package com.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@SequenceGenerator(name="SOLUTION_SEQUENCE", initialValue=1)
@Entity
public class Solution implements Serializable{

	private static final long serialVersionUID = -5653197660148721839L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SOLUTION_SEQUENCE")
	private long id;
	
	@Column
	private String solutionBody;
	
	@Column
	private String givenOutput;
	
	@Column
	private String givenInput;
	
	@Column
	private boolean valid;
	
	@Column
	private long problemId;
	
	@Column
	private long userId;
	
	public Solution(String solutionBody, String givenOutput, String givenInput,
			boolean valid, long problemId) {
		this.solutionBody = solutionBody;
		this.givenOutput = givenOutput;
		this.givenInput = givenInput;
		this.valid = valid;
		this.problemId = problemId;
	}
	
	public Solution(){}
	
	public long getId() {
		return this.id;
	}
	
	public String getSolutionBody() {
		return solutionBody;
	}
	public void setSolutionBody(String solutionBody) {
		this.solutionBody = solutionBody;
	}
	public String getGivenOutput() {
		return givenOutput;
	}
	public void setGivenOutput(String givenOutput) {
		this.givenOutput = givenOutput;
	}
	public String getGivenInput() {
		return givenInput;
	}
	public void setGivenInput(String givenInput) {
		this.givenInput = givenInput;
	}
	public long getProblemId() {
		return problemId;
	}
	public void setProblemId(long problemId) {
		this.problemId = problemId;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
}
