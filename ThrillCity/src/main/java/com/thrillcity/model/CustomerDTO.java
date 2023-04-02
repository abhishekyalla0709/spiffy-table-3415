package com.thrillcity.model;

import java.time.LocalDate;

public class CustomerDTO {
	
	private Integer customerID;
	private String address;
	private String mobileNumber;
	private String email;
	private LocalDate dob;
	
	
	public CustomerDTO(Integer customerId, String address, String mobileNumber, String email, LocalDate dob) {
		super();
		this.customerID = customerId;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.dob = dob;
	}
	
	public Integer getCustomerId() {
		return customerID;
	}
	public void setCustomerId(Integer customerId) {
		this.customerID = customerId;
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
		return "CustomerDTO [customerId=" + customerID + ", address=" + address + ", mobileNumber=" + mobileNumber
				+ ", email=" + email + ", dob=" + dob + "]";
	}
	
	
	
	
}
