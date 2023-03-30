package com.thrillcity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thrillcity.exceptions.ActivityException;
import com.thrillcity.model.Activity;
import com.thrillcity.model.Customer;
import com.thrillcity.repository.ActivityRepository;

@Service
public class ActivityServiceImpl implements ActivityService{

	@Autowired
	private ActivityRepository activityRepository;
	
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
	public Activity deleteActivity(int activityId) throws ActivityException {
		return activityRepository.findById(activityId).orElseThrow(() -> new ActivityException("Entered ActivityID is wrong"));
	}

	@Override
	public List<Activity> viewChargesOfActivities(Double charges) throws ActivityException {
		List<Activity> activities = activityRepository.findByCharges(charges);
		
		if(activities.isEmpty()) {
			throw new ActivityException("There are no activities for a charge of: "+charges);
		}
		
		else return activities;
	}

}
