package com.thrillcity.model;

import java.time.LocalDate;

public class CustomerDTO {
	
	private Integer customerId;
	private String address;
	private String mobileNumber;
	private String email;
	private LocalDate dob;
	
	
	public CustomerDTO(Integer customerId, String address, String mobileNumber, String email, LocalDate dob) {
		super();
		this.customerId = customerId;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.dob = dob;
	}
	
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "CustomerDTO [customerId=" + customerId + ", address=" + address + ", mobileNumber=" + mobileNumber
				+ ", email=" + email + ", dob=" + dob + "]";
	}
	
	
	
	
}
