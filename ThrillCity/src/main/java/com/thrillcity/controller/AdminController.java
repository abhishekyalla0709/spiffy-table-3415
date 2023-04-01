package com.thrillcity.controller;

import java.net.http.HttpHeaders;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thrillcity.model.Activity;
import com.thrillcity.model.Admin;
import com.thrillcity.model.Customer;
import com.thrillcity.repository.CustomerRepository;
import com.thrillcity.service.AdminService;
import com.thrillcity.service.CustomerService;

@RestController
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private CustomerService cutomerService;

	@PostMapping("/admins")
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin){
		Admin a = adminService.insertAdmin(admin);
		return new ResponseEntity<Admin>(a, HttpStatus.OK);
	}
	
	@GetMapping("/admins/{id}")
	public ResponseEntity<Admin> getAdmin(@PathVariable Integer id){
		Admin a = adminService.getAdmin(id);
		return new ResponseEntity<Admin>(a, HttpStatus.OK);
	}
	
//	@PostMapping("/customers")
//	public ResponseEntity<Customer> addCustomer(@RequestBody Customer c){
//		List<Activity> activities = c.getActivities();
//		for(Activity activity: activities) {
//			activity.getCustomers().add(c);
//		}
//		customerRepsoitory.save(c);
//		return new ResponseEntity<>(c, HttpStatus.ACCEPTED);
//	}
	
	@GetMapping("/customers/{id}")
	public ResponseEntity<List<Activity>> getAllActivtiesOfACustomer(@PathVariable Integer id){
		
		List<Activity> activities = adminService.getAllActivities(id);
		
		return new ResponseEntity<List<Activity>>(activities, HttpStatus.OK);
	}
	
	
	@PatchMapping("/updateTicketBalance/{sid}/{amount}")
	public ResponseEntity<String> updateBalCustTicket(@PathVariable String sid,@PathVariable Double amount){
			
			String bal = adminService.updateCustTickBal(sid, amount);
			
			return new ResponseEntity<>(bal,HttpStatus.ACCEPTED);
			
		}
}
