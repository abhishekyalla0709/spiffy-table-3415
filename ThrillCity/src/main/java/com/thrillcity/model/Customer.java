package com.thrillcity.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Customer {
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Integer customerID;

//		@NotNull
//		@Size(min = 4, max = 12, message = "Username should has minimum 4 to 12 characters")
//		private String username;
//		@Size(min = 4, max = 12, message = "Password should has minimum 4 to 12 characters")
//		private String password;
		@NotNull
		private String address;
		@Size(min = 10, message = "Mobile Number should be of 10 digits!")
		private String mobileNumber;
		@Email
		private String email;
		
		@JsonIgnore
		@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
		private List<Ticket> tickets;

}
