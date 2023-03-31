package com.thrillcity.service;

import java.time.LocalDate;
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
	
	private ActivityRepository activityRepository;
	
	@Override
	public Customer registerCustomer(Customer customer) throws CustomerException {
		
		List<Activity> activities = customer.getActivities();
		for(Activity activity: activities) {
			activity.getCustomers().add(customer);
		}
		Customer customer2 = customerRepository.save(customer);
		return customer2;
	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerException {
		
		Optional<Customer> opt = customerRepository.findById(customer.getCustomerID());
		if (opt.isPresent()) {
			Customer updateCustomer = customerRepository.save(customer);
			return updateCustomer;
		} else {
			throw new CustomerException(" Customer Does Not Exist ! ");
		}
	}

	@Override
	public String deleteCustomer(Integer customerID) throws CustomerException {
		
		Optional<Customer> opt = customerRepository.findById(customerID);

		if (opt.isPresent()) {
			customerRepository.delete(opt.get());
			return "Deletion successful!";
		} else {
			throw new CustomerException("No customer found with the ID:" + customerID);
		}
	}

	@Override
	public List<Activity> getAllActivities() throws ActivityException {
		
		List<Activity> list = activityRepository.findAll();
		if(list == null) {
			throw new ActivityException("No activities found.");
		}
		return list;
	}

	@Override
	public Customer getCustomerById(Integer customerId) throws CustomerException {
		
		Optional<Customer> cus = customerRepository.findById(customerId);
		
		if(cus == null) throw new CustomerException("customer is not available with this id");
		Customer customer= cus.get();
		return customer;
	}

	@Override
	public List<Activity> getCustomerActivity(LocalDate d1, LocalDate d2) throws CustomerException, ActivityException {
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
