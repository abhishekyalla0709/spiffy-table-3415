package com.thrillcity.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thrillcity.model.Customer;
import com.thrillcity.model.CustomerDTO;
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
	
	@PatchMapping("/customersaddress/{customerid}/{address}/{mobileNumber}/{email}")
	public ResponseEntity<Customer> updateCustAdd(@PathVariable Integer customerid, @PathVariable String address, @PathVariable String mobileNumber, @PathVariable String email){
		
		Customer customer = customerService.updateCustomer(customerid, address, mobileNumber, email);
		
		return new ResponseEntity<>(customer,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/customers/{customerid}")
	public ResponseEntity<Customer> delCustHandler(@PathVariable Integer customerid){
		Customer customer = customerService.deleteCustomer(customerid);
		
		return new ResponseEntity<>(customer,HttpStatus.OK);
	}
	
	@PutMapping("/customers/{sessionId}/{activityId}")
	public ResponseEntity<Customer> useAnActivity(@PathVariable Integer customerId, @PathVariable Integer activityId){
		Customer c = customerService.useActivity(customerId, activityId);
		return new ResponseEntity<Customer>(c, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/customersbwdates/{d1}/{d2}")
	public ResponseEntity<List<CustomerDTO>> listOfCustomers(@PathVariable LocalDate d1, @PathVariable LocalDate d2){
		List<CustomerDTO> listcust= customerService.listOfCustomers(d1, d2);
		return new ResponseEntity<>(listcust, HttpStatus.OK);
		
	}
	
	
}
