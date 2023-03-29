package com.thrillcity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thrillcity.model.Activity;

@Repository
public interface ActivityDao extends JpaRepository<Activity, Integer>{
	
	public List<Activity> findByCharges(Double charges);
}
