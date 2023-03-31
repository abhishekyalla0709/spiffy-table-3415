package com.thrillcity.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thrillcity.exceptions.ActivityException;
import com.thrillcity.exceptions.CustomerException;
import com.thrillcity.model.Activity;
import com.thrillcity.model.Customer;
import com.thrillcity.repository.ActivityRepository;
import com.thrillcity.repository.CustomerRepository;

import ch.qos.logback.core.joran.spi.ActionException;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ActivityRepository activityRepository;
	
	@Override
	public Customer registerCustomer(Customer customer) throws CustomerException {
		
		List<Activity> activities = customer.getActivities();
		
//		if(activities==null) {
//			List<Activity> activities2 = new ArrayList<>();
//			
//		}
		
		
		
		for(Activity activity: activities) {
			activity.getCustomers().add(customer);
		}
		
		Customer customer2 = customerRepository.save(customer);
		
		return customer2;
		
	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteCustomer(Integer customerID) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Activity> getAllActivities() throws ActivityException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomerById(String email) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer useActivity(Integer customerId, Integer activityId) throws CustomerException, ActivityException {
		Optional<Customer> opt = customerRepository.findById(customerId);
		if(opt.isPresent() == false) {
			throw new CustomerException("No customer found for this id " + customerId);
		}
		Customer c = opt.get();
		Optional<Activity> opt2 = activityRepository.findById(activityId);
		if(opt2.isPresent()==false) {
			throw new ActivityException("No activity found for this id " + activityId);
		}
		Activity a = opt2.get();
		if(c.getTickets().getBalance()>a.getCharges()) {
			Double bal = c.getTickets().getBalance();
			c.getActivities().add(a);
			a.getCustomers().add(c);
			c.getTickets().setBalance(bal - a.getCharges());
			customerRepository.save(c);
		}
		return c;
	}

}
