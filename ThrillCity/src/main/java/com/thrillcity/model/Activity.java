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
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@ToString
public class Activity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer activityid;
	@NotNull
	@NotBlank
	private String description;
	@Min(value = 100)
	private Double charges;
	private Integer age;
	@Min(value = 1)
	private Integer capacity;
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Customer> customers = new ArrayList<>();


	public Integer getActivityid() {
		return activityid;
	}


	public void setActivityid(Integer activityid) {
		this.activityid = activityid;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Double getCharges() {
		return charges;
	}


	public void setCharges(Double charges) {
		this.charges = charges;
	}


	public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
		this.age = age;
	}


	public Integer getCapacity() {
		return capacity;
	}


	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}


	public List<Customer> getCustomers() {
		return customers;
	}


	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}


	public Activity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Activity(Integer activityid, String description, @Min(100) Double charges, Integer age,
			@Min(1) Integer capacity, List<Customer> customers) {
		super();
		activityid = activityid;
		this.description = description;
		this.charges = charges;
		this.age = age;
		this.capacity = capacity;
		this.customers = customers;
	}
	
	
	
}
