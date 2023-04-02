package com.thrillcity.model;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserSession {

	@Id
	private String phoneNumber;
	
	private String sessionId;
	
	private LocalDateTime logintime;
	
	private String type;

	public UserSession() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public UserSession(String phoneNumber, String sessionId, LocalDateTime logintime, String type) {
		super();
		this.phoneNumber = phoneNumber;
		this.sessionId = sessionId;
		this.logintime = logintime;
		this.type = type;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSessionPassKey() {
		return sessionId;
	}

	public void setSessionPassKey(String sessionPassKey) {
		this.sessionId = sessionPassKey;
	}

	public LocalDateTime getLogintime() {
		return logintime;
	}

	public void setLogintime(LocalDateTime logintime) {
		this.logintime = logintime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "UserSession [userSessionId=" + ", phoneNumber=" + phoneNumber + ", sessionPassKey="
				+ sessionId + ", logintime=" + logintime + ", type=" + type + "]";
	}

		
	
	
	
}
