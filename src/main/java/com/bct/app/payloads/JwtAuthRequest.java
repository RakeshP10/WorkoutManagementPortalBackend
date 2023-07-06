package com.bct.app.payloads;

public class JwtAuthRequest {

	private String userName;
	
	private String password;

	public String getUsername() {
		return userName;
	}

	public void setUsername(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public JwtAuthRequest(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public JwtAuthRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "JwtAuthRequest [userName=" + userName + ", password=" + password + "]";
	}
	
	
	
}