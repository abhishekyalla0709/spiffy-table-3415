package com.thrillcity.service;

import java.util.List;

import com.masai.exception.CustomerException;
import com.thrillcity.model.Customer;

public interface CustomerService {
	
	public Customer registerCustomer(Customer customer) throws CustomerException;
	public Customer updateCustomer(Customer customer) throws CustomerException;
	public String deleteCustomer(Integer customerID) throws CustomerException;
	public List<Activity> getAllActivities() throws ActivityException;
	public Customer getCustomerById(String email) throws CustomerException;

}
