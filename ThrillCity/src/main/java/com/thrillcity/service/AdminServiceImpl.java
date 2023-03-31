package com.thrillcity.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thrillcity.exceptions.AdminException;
import com.thrillcity.model.Activity;
import com.thrillcity.model.Admin;
import com.thrillcity.model.Customer;
import com.thrillcity.repository.ActivityRepository;
import com.thrillcity.repository.AdminRepository;
import com.thrillcity.repository.CustomerRepository;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ActivityRepository activityRepository;
	
	
	@Override
	public Admin insertAdmin(Admin admin) {
		Admin a = adminRepository.save(admin);
		// TODO Auto-generated method stub
		return a;
	}
	
	@Override
	public Admin getAdmin(Integer id) {
		
		Optional<Admin> opt = adminRepository.findById(id);
		if(opt.isPresent()) {
			Admin admin = opt.get();
			return admin;
		}
		throw new AdminException("not found idiot");
		
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		Admin a = adminRepository.save(admin);
		return a;
	}

	@Override
	public Admin deleteAdmin(Integer admin_id) {
		// TODO Auto-generated method stub
		Optional<Admin> opt = adminRepository.findById(admin_id);
		if(opt.isPresent()) {
			Admin a = opt.get();
			adminRepository.delete(a);
			return a;
		}
		throw new AdminException("admin not found");
	}

	@Override
	public List<Activity> getAllActivities(Integer customer_id) {
		// TODO Auto-generated method stub
		Optional<Customer> opt = customerRepository.findById(customer_id);
		if(opt.isPresent()) {
			Customer c = opt.get();
			List<Activity> activities = c.getActivities();
			return activities;
		}
		throw new AdminException("admin not found");
	}

	@Override
	public List<Activity> getAllActivities() {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public List<Activity> getActivitiesDatewise() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Activity> getAllActivitiesForDays(Integer customer_id, LocalDateTime fromDate, LocalDateTime toDate) {
		// TODO Auto-generated method stub
		return null;
	}

}
