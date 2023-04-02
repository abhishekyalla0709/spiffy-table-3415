package com.thrillcity.service;

import com.thrillcity.model.LoginUser;

public interface LoginUserService {
	
	public String loginUser(LoginUser loginuser);
	
	public String logoutUser(String mobileNumber, String sessionId);
	
	
}
