package com.model.problem;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 *  The representation of a problem.
 * @author tiaraju
 *
 */
@Entity
public class Problem implements Serializable {
/***
 *	 
 * @param name the name of the problem to be created
 * @param description a description of the problem
 * @param hint a hint to help to solve the problem.
 */
	public Problem(String name, String description, String hint){
		this.name = name;
		this.description = description;
		this.hint=hint;
	}
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private long id;
	@Column
	private String description;
	@Column
	private String hint;
	
	@Column
	private String name;
	
	public Problem(){}
	
	/**
	 *  Returns the problem's name
	 * @return the problem's name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of the problem
	 * @param name the new name 
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 *  Returns the problem's description.
	 * @return the problem's description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 *  Sets the description of the problem
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * returns the problem's Id
	 * @return the problem's id
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * Returns the problem's hint
	 * @return the problem's hint
	 */
	public String getHint() {
		return hint;
	}
	/**
	 * Sets the problem's hint
	 * @param hint the new hint
	 */
	public void setHint(String hint) {
		this.hint = hint;
	}
}
