package com.thrillcity.model;

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
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Customer{
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer customerID;
		
		@NotNull
		private String address;
		
//		@Size(min = 10, message = "Mobile Number should be of 10 digits!")
		private String mobileNumber;
		
		@Email
		private String email;
		
		@OneToOne(cascade = CascadeType.ALL)
		private Ticket tickets;
		
		@JsonIgnore
		@ManyToMany(cascade = CascadeType.ALL)
		private List<Activity> activities = new ArrayList<>();

}
