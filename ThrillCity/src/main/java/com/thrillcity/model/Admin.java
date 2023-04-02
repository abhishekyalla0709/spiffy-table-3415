package com.thrillcity.model;


import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Admin{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer admin_id;
	
	@Column(unique = true)
	@NotNull
	private String email;
	
	@Embedded
	private Address address;
	
	@NotNull
	private String username;
	
	@Column(unique = true)
	@NotNull
	private String phonenumber;
	
	@NotNull
	private String password;

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

	public Admin(Integer admin_id, String email, Address address, String username, String phonenumber,
			String password) {
		super();
		this.admin_id = admin_id;
		this.email = email;
		this.address = address;
		this.username = username;
		this.phonenumber = phonenumber;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
