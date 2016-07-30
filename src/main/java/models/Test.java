package models;

public class Test {
	private String name;
	private String hint;
	private String givenInput;
	private String expectedOutput;
	private String status;//either public or private
	
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
	
	

}
