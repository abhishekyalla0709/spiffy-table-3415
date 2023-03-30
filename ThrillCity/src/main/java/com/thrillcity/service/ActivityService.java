package com.thrillcity.service;

import java.util.List;

import com.thrillcity.exceptions.ActivityException;
import com.thrillcity.model.Activity;

public interface ActivityService {
	
	public Activity insertActivity(Activity activity) throws ActivityException;
	
	public Activity updateActivity(Activity activity) throws ActivityException;
	
	public Activity deleteActivity(int activityId) throws ActivityException;
	
	public List<Activity> viewChargesOfActivities(Double charges) throws ActivityException;
}
