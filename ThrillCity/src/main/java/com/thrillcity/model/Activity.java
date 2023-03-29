package com.thrillcity.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Activity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACTIVITYID")
	private Integer Activityid;
	private String description;
	@Min(value = 100)
	private Double charges;
	private Integer age;
	@Min(value = 1)
	private Integer capacity;
	
	@ManyToMany(mappedBy = "activities",cascade = CascadeType.ALL)
	private List<Customer> customers = new ArrayList<>();
	
}