package com.thrillcity.model;

public class LoginUser {
	
	private String userType;
	
	private Integer id;
	
	private String password;

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LoginUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginUser(String userType, Integer id, String password) {
		super();
		this.userType = userType;
		this.id = id;
		this.password = password;
	}
	
	
}
