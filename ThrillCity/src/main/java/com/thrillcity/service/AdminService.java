package com.thrillcity.service;

import java.time.LocalDateTime;
import java.util.List;

import com.thrillcity.exceptions.ActivityException;
import com.thrillcity.exceptions.AdminException;
import com.thrillcity.exceptions.CustomerException;
import com.thrillcity.model.Activity;
import com.thrillcity.model.ActivityDTO;
import com.thrillcity.model.Admin;

public interface AdminService {
	
	public Admin insertAdmin(Admin admin) throws AdminException;
	
	public Admin getAdmin(Integer id) throws AdminException;
	
	public Admin updateAdmin(Admin admin) throws AdminException;
	
	public Admin deleteAdmin(Integer admin_id) throws AdminException;
	
	public List<Activity> getAllActivities(Integer customer_id) throws ActivityException, CustomerException;
	
	public List<ActivityDTO> getAllActivities() throws ActivityException;
	
	
	
}
