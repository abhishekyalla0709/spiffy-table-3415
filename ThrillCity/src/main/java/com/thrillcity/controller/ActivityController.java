package com.thrillcity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thrillcity.model.Activity;
import com.thrillcity.service.ActivityService;

@RestController
public class ActivityController {
	
	@Autowired
	private ActivityService activityService;
	
	@PostMapping("/activities")
	public ResponseEntity<Activity> registerActivityHandler(@RequestBody Activity activity){
		Activity activ = activityService.insertActivity(activity);
		
		return new ResponseEntity<>(activ,HttpStatus.CREATED);
	}
	
	@PutMapping("/activities")
	public ResponseEntity<Activity> updateActivityHandler(Activity activity){
		Activity activ = activityService.updateActivity(activity);
				
		return new ResponseEntity<>(activ,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/activities")
	public ResponseEntity<Activity> deleteActivityHandler(int activityId){
		Activity activ = activityService.deleteActivity(activityId);
		
		return new ResponseEntity<>(activ,HttpStatus.OK);
	}
	
	@GetMapping("/activities{charges}")
	public ResponseEntity<List<Activity>> viewActivitiesByChargesHandler(@PathVariable Double charges){
		List<Activity> activities = activityService.viewChargesOfActivities(charges);
		
		return new ResponseEntity<>(activities,HttpStatus.OK);
	}
	
	
}
