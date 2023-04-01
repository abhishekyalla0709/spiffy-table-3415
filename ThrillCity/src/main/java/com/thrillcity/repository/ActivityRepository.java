package com.thrillcity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.thrillcity.model.Activity;
import com.thrillcity.model.ActivityDTO;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer>{
	
	public List<Activity> findByCharges(Double charges);
	
	
	@Query("select new com.thrillcity.model.ActivityDTO(activityid, description,charges,age,capacity) from Activity" )
	public List<ActivityDTO> getOnlyActivityDetails();
	
	
}
