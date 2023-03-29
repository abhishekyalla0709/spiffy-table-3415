package com.thrillcity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thrillcity.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
