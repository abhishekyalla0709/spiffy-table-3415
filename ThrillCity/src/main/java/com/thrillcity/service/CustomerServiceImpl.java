package com.thrillcity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thrillcity.exceptions.ActivityException;
import com.thrillcity.exceptions.CustomerException;
import com.thrillcity.model.Activity;
import com.thrillcity.model.Customer;
import com.thrillcity.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerrepository;

	@Override
	public Customer registerCustomer(Customer customer) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
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

}
