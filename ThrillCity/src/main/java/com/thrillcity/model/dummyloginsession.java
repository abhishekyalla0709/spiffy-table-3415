package com.thrillcity.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class dummyloginsession {

	@Id
	private Integer id;
	
	private String token;
	
	private LocalDateTime logintime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public LocalDateTime getLogintime() {
		return logintime;
	}

	public void setLogintime(LocalDateTime logintime) {
		this.logintime = logintime;
	}

	public dummyloginsession(Integer id, String token, LocalDateTime logintime) {
		super();
		this.id = id;
		this.token = token;
		this.logintime = logintime;
	}

	public dummyloginsession() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "dummyloginsession [id=" + id + ", token=" + token + ", logintime=" + logintime + "]";
	}
	
	
}
