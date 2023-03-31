package com.thrillcity.service;

import java.time.LocalDate;
import java.util.List;

import com.thrillcity.exceptions.ActivityException;
import com.thrillcity.exceptions.CustomerException;
import com.thrillcity.model.Activity;
import com.thrillcity.model.Customer;

public interface CustomerService {
	
	public Customer registerCustomer(Customer customer) throws CustomerException;
	public Customer updateCustomer(Customer customer) throws CustomerException;
	public String deleteCustomer(Integer customerID) throws CustomerException;
	public List<Activity> getAllActivities() throws ActivityException;
	public List<Activity> getCustomerActivity(LocalDate d1, LocalDate d2) throws CustomerException, ActivityException;
	public Customer getCustomerById(Integer customerId) throws CustomerException;
	public Customer useActivity(Integer customerId, Integer activityId) throws CustomerException, ActivityException;

}
