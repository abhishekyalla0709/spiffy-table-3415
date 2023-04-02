package com.thrillcity.controller;

import java.net.http.HttpHeaders;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thrillcity.model.Activity;
import com.thrillcity.model.ActivityDTO;
import com.thrillcity.model.Admin;
import com.thrillcity.model.Customer;
import com.thrillcity.repository.CustomerRepository;
import com.thrillcity.service.ActivityService;
import com.thrillcity.service.AdminService;
import com.thrillcity.service.CustomerService;

@RestController
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private CustomerService cutomerService;
	
	@Autowired
	private ActivityService activityService;

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
	
	@DeleteMapping("/admins/{id}")
	public ResponseEntity<Admin> deleteAdmin(@PathVariable Integer id){
		Admin a = adminService.deleteAdmin(id);
		return new ResponseEntity<Admin>(a, HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/admins")
	public ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin){
		Admin a = adminService.insertAdmin(admin);
		return new ResponseEntity<Admin>(a, HttpStatus.OK);
	}
	
	@GetMapping("/customeractivities/{id}")
	public ResponseEntity<List<Activity>> getAllActivtiesOfACustomer(@PathVariable Integer id){
		
		List<Activity> activities = adminService.getAllActivities(id);
		
		return new ResponseEntity<List<Activity>>(activities, HttpStatus.OK);
	}
	
	
	@PatchMapping("/updateTicketBalance/{sid}/{amount}")
	public ResponseEntity<String> updateBalCustTicket(@PathVariable String sid,@PathVariable Double amount){
			
			String bal = adminService.updateCustTickBal(sid, amount);
			
			return new ResponseEntity<>(bal,HttpStatus.ACCEPTED);
			
		}
	
	@GetMapping("/getallactivities")
	public ResponseEntity<List<ActivityDTO>> getActivDetails(){
		
		List<ActivityDTO> activityDTOs = activityService.getAllActivityDetails();
		
		return new ResponseEntity<>(activityDTOs,HttpStatus.OK);
		
	}
}
