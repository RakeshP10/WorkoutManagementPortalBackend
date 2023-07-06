package com.bct.app.payloads;


import com.bct.app.entity.User;

public class JwtAuthResponse {

	private String token;
	
	private User user;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "JwtAuthResponse [token=" + token + ", user=" + user + "]";
	}

	public JwtAuthResponse(String token, User user) {
		super();
		this.token = token;
		this.user = user;
	}

	public JwtAuthResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
