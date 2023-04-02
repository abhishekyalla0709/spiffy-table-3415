package com.thrillcity.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.thrillcity.exceptions.CustomerException;
import com.thrillcity.model.Activity;
import com.thrillcity.model.Customer;
import com.thrillcity.model.CustomerDTO;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	
	@Query("select new com.thrillcity.model.CustomerDTO(customerID,address,email,dob) from Customer c where c.customerID=?1")
	public Optional<CustomerDTO> getCustomerAllDetails( Integer customerId) throws CustomerException;
	
	@Query("select new com.thrillcity.model.CustomerDTO(customerID,address,email,dob) from Customer")
	public List<CustomerDTO> getAllCustomer() throws CustomerException;	
	
	public Customer findBymobileNumber(String mobileNumber);

}
