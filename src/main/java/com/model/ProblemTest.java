package com.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@SequenceGenerator(name="TEST_SEQUENCE", initialValue=1)
@Entity
public class ProblemTest implements Serializable {
	
	private static final long serialVersionUID = 8891673742523205734L;

	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TEST_SEQUENCE")
	@Id
	private long id;
	
	@Column
	private String name;

	@Column
	private String hint;

	@Column
	private String givenInput;

	@Column
	private String expectedOutput;

	@Column
	private String status;//either public or private

	@Column
	private long problemCode;
	
	public ProblemTest(){}
	
	public ProblemTest(String name, String hint, String givenInput,
			String expectedOutput, String status, long problemCode) {
		this.name = name;
		this.hint = hint;
		this.givenInput = givenInput;
		this.expectedOutput = expectedOutput;
		this.status = status;
		this.problemCode = problemCode;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHint() {
		return hint;
	}
	public void setHint(String hint) {
		this.hint = hint;
	}
	public String getGivenInput() {
		return givenInput;
	}
	public void setGivenInput(String givenInput) {
		this.givenInput = givenInput;
	}
	public String getExpectedOutput() {
		return expectedOutput;
	}
	public void setExpectedOutput(String expectedOutput) {
		this.expectedOutput = expectedOutput;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public long getProblemCode() {
		return problemCode;
	}

	public void setProblemCode(long problemCode) {
		this.problemCode = problemCode;
	}
	
	

}
