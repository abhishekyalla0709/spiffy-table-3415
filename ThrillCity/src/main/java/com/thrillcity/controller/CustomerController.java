package com.thrillcity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thrillcity.model.Customer;
import com.thrillcity.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> registerCustomerHandler(@RequestBody Customer customer){
		
		Customer cust = customerService.registerCustomer(customer);
		
		return new ResponseEntity<>(cust,HttpStatus.CREATED);
	}
	
	@PutMapping("/customers/{customerId}/{activityId}")
	public ResponseEntity<Customer> useAnActivity(@PathVariable Integer customerId, @PathVariable Integer activityId){
		Customer c = customerService.useActivity(customerId, activityId);
		return new ResponseEntity<Customer>(c, HttpStatus.ACCEPTED);
	}
	
	
}