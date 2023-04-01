package com.thrillcity.service;

import java.time.LocalDate;
import java.util.List;

import com.thrillcity.exceptions.ActivityException;
import com.thrillcity.exceptions.CustomerException;
import com.thrillcity.model.Activity;
import com.thrillcity.model.ActivityDTO;
import com.thrillcity.model.Customer;
import com.thrillcity.model.CustomerDTO;

public interface CustomerService {
	
	public Customer registerCustomer(Customer customer) throws CustomerException;
	public Customer updateCustomer(Integer customerId, String address, String mobileNumber, String email) throws CustomerException;
	public Customer deleteCustomer(Integer customerID) throws CustomerException;
	public CustomerDTO getCustomerAllDetails(Integer customerId) throws CustomerException;
	public List<CustomerDTO> getAllCustomer() throws CustomerException;
	public List<ActivityDTO> getAllActivities() throws ActivityException;
	public List<CustomerDTO> listOfCustomers(LocalDate d1, LocalDate d2) throws CustomerException, ActivityException;
	public Customer useActivity(Integer customerId, Integer activityId) throws CustomerException, ActivityException;

}
