package com.thrillcity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.thrillcity.model.Activity;
import com.thrillcity.model.Admin;
import com.thrillcity.model.Customer;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

//	
//	@Query("select a from Acivity a where customer")
//	public List<Activity> getAllActivities(Integer customer_id);
	public Admin findByphonenumber(String mobileNumber);
}
