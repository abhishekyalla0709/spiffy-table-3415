package com.thrillcity.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.thrillcity.exceptions.ActivityException;
import com.thrillcity.exceptions.CustomerException;
import com.thrillcity.model.Activity;
import com.thrillcity.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{

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
