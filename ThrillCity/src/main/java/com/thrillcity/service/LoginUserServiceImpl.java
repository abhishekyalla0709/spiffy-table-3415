package com.thrillcity.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thrillcity.exceptions.AdminException;
import com.thrillcity.exceptions.CustomerException;
import com.thrillcity.model.Admin;
import com.thrillcity.model.Customer;
import com.thrillcity.model.LoginUser;
import com.thrillcity.model.UserSession;
import com.thrillcity.repository.AdminRepository;
import com.thrillcity.repository.CustomerRepository;
import com.thrillcity.repository.UserSessionRepository;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginUserServiceImpl implements LoginUserService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private UserSessionRepository userSessionRepository;
	
	@Override
	public String loginUser(LoginUser loginuser) {
		String type = loginuser.getUserType();
		String mobileNumber = loginuser.getMobileNumber();
		if(type.equalsIgnoreCase("customer")) {
			Customer c = customerRepository.findBymobileNumber(mobileNumber);
			if(c==null) {
				throw new CustomerException("customer not found with mobileNumber " + mobileNumber);
			}
			if(c.getPassword().equalsIgnoreCase(loginuser.getPassword())==false) {
				throw new CustomerException("Incorrect password");
			}
			
			Optional<UserSession> opt2 = userSessionRepository.findById(mobileNumber);
			if(opt2.isPresent() && opt2.get().getType().equalsIgnoreCase(type)) {
				throw new CustomerException("Already logged in");
			}
			
			String sessionId = RandomString.make(5);
			
			UserSession us = new UserSession();
			us.setSessionPassKey(sessionId);
			us.setPhoneNumber(mobileNumber);
			us.setLogintime(LocalDateTime.now());
			us.setType(type);
			userSessionRepository.save(us);
			return sessionId;
		}
		else {
			Admin a = adminRepository.findByphonenumber(mobileNumber);
			if(a==null) {
				throw new AdminException("admin not found with mobileNumber " + mobileNumber);
			}
			if(a.getPassword().equalsIgnoreCase(loginuser.getPassword())==false) {
				throw new CustomerException("Incorrect password");
			}
			
			Optional<UserSession> opt2 = userSessionRepository.findById(mobileNumber);
			if(opt2.isPresent() && opt2.get().getType().equalsIgnoreCase(type)) {
				throw new CustomerException("Already logged in");
			}
			
			String sessionId = RandomString.make(5);
			
			UserSession us = new UserSession();
			us.setSessionPassKey(sessionId);
			us.setPhoneNumber(mobileNumber);
			us.setLogintime(LocalDateTime.now());
			us.setType(type);
			userSessionRepository.save(us);
			return sessionId;
		}
	}

	@Override
	public String logoutUser(String mobileNumber, String sessionId) {
		UserSession us = userSessionRepository.findBySessionId(sessionId);
		if(us==null) {
			throw new CustomerException("user not found with sessioId " + sessionId);
		}
		userSessionRepository.delete(us);
		return "successfully logged out";
	}

	

}
