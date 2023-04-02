package com.thrillcity.model;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserSession {

	@Id
	private Integer id;
	
	private String sessionId;
	
	private LocalDateTime logintime;
	
	private String type;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
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

	public UserSession() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserSession(Integer id, String sessionId, LocalDateTime logintime, String type) {
		super();
		this.id = id;
		this.sessionId = sessionId;
		this.logintime = logintime;
		this.type = type;
	}

	
	
	
}
