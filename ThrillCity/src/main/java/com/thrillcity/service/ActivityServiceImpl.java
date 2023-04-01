package com.thrillcity.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thrillcity.exceptions.ActivityException;
import com.thrillcity.exceptions.CustomerException;
import com.thrillcity.model.Activity;
import com.thrillcity.model.ActivityDTO;
import com.thrillcity.model.Customer;
import com.thrillcity.repository.ActivityRepository;
import com.thrillcity.repository.CustomerRepository;

@Service
public class ActivityServiceImpl implements ActivityService{

	@Autowired
	private ActivityRepository activityRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Activity insertActivity(Activity activity) throws ActivityException {
		
		List<Customer> customers = activity.getCustomers();
		
		for(Customer customer:customers) {
			
			customer.getActivities().add(activity);
		}
		
		Activity activ = activityRepository.save(activity);
		
		return activ;
	}

	@Override
	public Activity updateActivity(Activity activity) throws ActivityException {
		Optional<Activity> opt = activityRepository.findById(activity.getActivityid());
		
		if(opt.isPresent()) {
			Activity activ = opt.get();
			
			activityRepository.save(activity);
			
			return activity;
		}
		
		else throw new ActivityException("Entered ActivityID is wrong");
	}


	@Override
	public List<Activity> viewChargesOfActivities(Double charges) throws ActivityException {
		List<Activity> activities = activityRepository.findByCharges(charges);
		
		if(activities.isEmpty()) {
			throw new ActivityException("There are no activities for a charge of: "+charges);
		}
		
		else return activities;
	}

	@Override
	public List<ActivityDTO> getAllActivityDetails() {
		
		List<ActivityDTO> activityDTOs = activityRepository.getOnlyActivityDetails();
		
		if(activityDTOs.isEmpty()) throw new ActivityException("No Record Found");
		
		else return activityDTOs;
		
	}

	@Override
	public Activity deleteActivity(Integer activityId) throws ActivityException {
		// TODO Auto-generated method stub
		return null;
	}

}
