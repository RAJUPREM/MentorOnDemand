package com.mentorOnDemand.entity;



public class JWTResponse {
    public JWTResponse() {
		super();
	}

	public JWTResponse(String token) {
		super();
		this.token = token;
	}

	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "JWTResponse [token=" + token + "]";
	}

}
