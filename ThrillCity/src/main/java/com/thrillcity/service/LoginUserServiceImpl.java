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
		Integer id = loginuser.getId();
		if(type.equalsIgnoreCase("customer")) {
			Optional<Customer> opt = customerRepository.findById(id);
			if(opt.isEmpty()) {
				throw new CustomerException("customer not found with id " + id);
			}
			Customer c = opt.get();
			if(c.getPassword().equalsIgnoreCase(loginuser.getPassword())==false) {
				throw new CustomerException("Incorrect password");
			}
			
			Optional<UserSession> opt2 = userSessionRepository.findById(id);
			if(opt2.isPresent()) {
				throw new CustomerException("Already logged in");
			}
			
			String sessionId = RandomString.make(5);
			
			UserSession us = new UserSession(id, sessionId, LocalDateTime.now());
			
			userSessionRepository.save(us);
			return sessionId;
		}
		else {
			Optional<Admin> opt = adminRepository.findById(id);
			if(opt.isEmpty()) {
				throw new AdminException("customer not found with id " + id);
			}
		    Admin a = opt.get();
			if(a.getPassword().equalsIgnoreCase(loginuser.getPassword())==false) {
				throw new AdminException("Incorrect password");
			}
			
			Optional<UserSession> opt2 = userSessionRepository.findById(id);
			if(opt2.isPresent()) {
				throw new AdminException("Already logged in");
			}
			
			String sessionId = RandomString.make(5);
			
			UserSession us = new UserSession(id, sessionId, LocalDateTime.now());
			
			userSessionRepository.save(us);
			return sessionId;
		}
	}

	@Override
	public String logoutUser(Integer id, String sessionId) {
		Optional<UserSession> opt2 = userSessionRepository.findById(id);
		if(opt2.isPresent()==false) {
			throw new CustomerException("user not found with id " + id);
		}
		UserSession us = opt2.get();
		if(us.getSessionId().equalsIgnoreCase(sessionId)==false) {
			throw new CustomerException("Incorrect sessionId");
		}
		userSessionRepository.delete(us);
		return "successfully logged out";
	}

}
