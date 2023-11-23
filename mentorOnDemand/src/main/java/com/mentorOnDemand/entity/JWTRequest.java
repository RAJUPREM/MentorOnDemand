package com.mentorOnDemand.entity;


public class JWTRequest {
    public JWTRequest() {
		super();
	}
	public JWTRequest(String personName, String password) {
		super();
		this.personName = personName;
		this.password = password;
	}
	private String personName;
    private String password;
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "JWTRequest [personName=" + personName + ", password=" + password + "]";
	}
}
