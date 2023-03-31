package com.thrillcity.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thrillcity.exceptions.ActivityException;
import com.thrillcity.exceptions.AdminException;
import com.thrillcity.exceptions.CustomerException;
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
	public Admin insertAdmin(Admin admin) throws AdminException {
		Admin a = adminRepository.save(admin);
		if(a==null) {
			throw new AdminException("Something went wrong please try again");
		}
		return a;
	}

	@Override
	public Admin getAdmin(Integer id) throws AdminException {
		Optional<Admin> opt = adminRepository.findById(id);
		if(opt.isPresent()) {
			Admin admin = opt.get();
			return admin;
		}
		throw new AdminException("Admin not found with id " + id);
	}

	@Override
	public Admin updateAdmin(Admin admin) throws AdminException {
		Optional<Admin> opt = adminRepository.findById(admin.getAdmin_id());
		if(opt.isPresent()) {
			Admin a1 = adminRepository.save(admin);
			return a1;
		}
		throw new AdminException("Admin not found with id " + admin.getAdmin_id());
	}

	@Override
	public Admin deleteAdmin(Integer admin_id) throws AdminException {

		Optional<Admin> opt = adminRepository.findById(admin_id);
		if(opt.isPresent()) {
			Admin a1 = opt.get();
			adminRepository.delete(a1);
			return a1;
		}
		throw new AdminException("Admin not found with id " + admin_id);
	}

	@Override
	public List<Activity> getAllActivities(Integer customer_id) throws ActivityException, CustomerException {
		Optional<Customer> opt = customerRepository.findById(customer_id);
		if(opt.isPresent()==false) {
			throw new CustomerException("customer not found with id " + customer_id);
		}
		
			Customer c = opt.get();
			List<Activity> activities = c.getActivities();
			if(activities.size() == 0) {
				throw new ActivityException("customer has not taken any activity yet");
			}
			return activities;
	}

	@Override
	public List<Activity> getAllActivities() throws ActivityException {
		List<Activity> activities = activityRepository.findAll();
		if(activities.size()==0) {
			throw new ActivityException("no activity is found");
		}
		return activities;
	}

	
	


}
