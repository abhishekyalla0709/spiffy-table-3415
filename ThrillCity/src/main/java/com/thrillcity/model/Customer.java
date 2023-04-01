package com.thrillcity.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@ToString
@Entity
public class Customer{
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer customerID;
		
		@NotNull(message = "please provide address")
		private String address;
		
		@Size(min = 10, message = "Mobile Number should be of 10 digits!")
		private String mobileNumber;
		
		@Email
		private String email;
		
		
		private LocalDate dob;
		
		private String password;
		
		@OneToOne(cascade = CascadeType.ALL)
		private Ticket tickets;
		
		
		@ManyToMany(cascade = CascadeType.ALL,mappedBy = "customers")
		private List<Activity> activities = new ArrayList<>();

		public Integer getCustomerID() {
			return customerID;
		}

		public void setCustomerID(Integer customerID) {
			this.customerID = customerID;
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

		public Ticket getTickets() {
			return tickets;
		}

		public void setTickets(Ticket tickets) {
			this.tickets = tickets;
		}

		public List<Activity> getActivities() {
			return activities;
		}

		public void setActivities(List<Activity> activities) {
			this.activities = activities;
		}

		public Customer(Integer customerID, @NotNull String address, String mobileNumber, @Email String email,
				Ticket tickets, List<Activity> activities) {
			super();
			this.customerID = customerID;
			this.address = address;
			this.mobileNumber = mobileNumber;
			this.email = email;
			this.tickets = tickets;
			this.activities = activities;
		}

		public Customer() {
			super();
			// TODO Auto-generated constructor stub
		}

		public LocalDate getDob() {
			return dob;
		}

		public void setDob(LocalDate dob) {
			this.dob = dob;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		
		
		
		

}
