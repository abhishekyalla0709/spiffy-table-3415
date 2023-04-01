package com.thrillcity.service;

import java.time.LocalDateTime;
import java.util.List;

import com.thrillcity.exceptions.ActivityException;
import com.thrillcity.model.Activity;
import com.thrillcity.model.ActivityDTO;

public interface ActivityService {
	
	public Activity insertActivity(Activity activity) throws ActivityException;
	
	public Activity updateActivity(Activity activity) throws ActivityException;
	
	public Activity deleteActivity(Integer activityId) throws ActivityException;
	
	public List<Activity> viewChargesOfActivities(Double charges) throws ActivityException;
	
	public List<ActivityDTO> getAllActivityDetails();
}
