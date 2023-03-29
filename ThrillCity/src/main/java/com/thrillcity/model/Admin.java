package com.thrillcity.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin extends User{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer admin_id;
	
	private String email;
	
	@Embedded
	private Address address;

	public Integer getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(Integer admin_id) {
		this.admin_id = admin_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public Admin(Integer admin_id, String email, Address address) {
		super();
		this.admin_id = admin_id;
		this.email = email;
		this.address = address;
	}
	
	
	

}
