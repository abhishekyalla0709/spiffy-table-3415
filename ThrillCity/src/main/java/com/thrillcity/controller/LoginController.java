package com.thrillcity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thrillcity.model.LoginUser;
import com.thrillcity.service.LoginUserService;

@RestController
public class LoginController {
	
	@Autowired
	private LoginUserService loginUserService;
	
	@PostMapping("/users/login")
	public ResponseEntity<String> userLogin(@RequestBody LoginUser user){
		String passcode = loginUserService.loginUser(user);
		return new ResponseEntity<String>(passcode, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/users/logout/{mobileNumber}/{passcode}")
	public ResponseEntity<String> userLogout(@PathVariable String mobileNumber, @PathVariable String passcode){
		String s = loginUserService.logoutUser(mobileNumber, passcode);
		return new ResponseEntity<String>(s, HttpStatus.ACCEPTED);
	}

}
