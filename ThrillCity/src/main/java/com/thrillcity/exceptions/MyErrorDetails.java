package com.thrillcity.exceptions;

import java.time.LocalDateTime;

public class MyErrorDetails {
	
	private LocalDateTime timeStamp;
	
	private String msg;
	
	private String details;

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public MyErrorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "MyErrorDetails [timeStamp=" + timeStamp + ", msg=" + msg + ", details=" + details + "]";
	}
	
	

}
