package com.thrillcity.service;

import java.time.LocalDateTime;
import java.util.List;

import com.thrillcity.model.Activity;
import com.thrillcity.model.Admin;

public interface AdminService {
	
	public Admin insertAdmin(Admin admin);
	
	public Admin getAdmin(Integer id);
	
	public Admin updateAdmin(Admin admin);
	
	public Admin deleteAdmin(Integer admin_id);
	
	public List<Activity> getAllActivities(Integer customer_id);
	
	public List<Activity> getAllActivities();
	
	public List<Activity> getActivitiesDatewise();
	
	public List<Activity> getAllActivitiesForDays(Integer customer_id, LocalDateTime fromDate, LocalDateTime toDate);

}
