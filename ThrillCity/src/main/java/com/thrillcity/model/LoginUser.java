package com.thrillcity.model;

public class LoginUser {
	
	private String userType;
	
	private String mobileNumber;
	
	private String password;

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
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

	public LoginUser(String userType, String mobileNumber, String password) {
		super();
		this.userType = userType;
		this.mobileNumber = mobileNumber;
		this.password = password;
	}

		
	
}
