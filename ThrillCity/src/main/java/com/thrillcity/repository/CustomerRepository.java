package com.thrillcity.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.thrillcity.exceptions.CustomerException;
import com.thrillcity.model.Activity;
import com.thrillcity.model.Customer;
import com.thrillcity.model.CustomerDTO;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	
	@Query("select c.activities from customer c where c.customerid = :customerid AND c.tickets.dateTime IS BETWEEN :forDate AND :toDate")
	public List<Activity> getActivitiesForDays();
	
	@Query("select new com.thrillcity.model.CustomerDTO(customerId,address,email,dob) from Customer where customerId=?1")
	public Optional<CustomerDTO> getCustomerAllDetails( Integer customerId) throws CustomerException;
	
	@Query("select new com.thrillcity.model.CustomerDTO(customerId,address,email,dob) from Customer")
	public List<CustomerDTO> getAllCustomer() throws CustomerException;
	
	
	
	

}
