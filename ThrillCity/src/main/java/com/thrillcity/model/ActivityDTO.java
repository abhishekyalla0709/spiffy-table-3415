package com.thrillcity.model;

public class ActivityDTO {
	
	private Integer activityid;
	private String description;
	private Double charges;
	private Integer age;
	private Integer capacity;
	
	
	
	public ActivityDTO(Integer activityid, String description, Double charges, Integer age, Integer capacity) {
		super();
		this.activityid = activityid;
		this.description = description;
		this.charges = charges;
		this.age = age;
		this.capacity = capacity;
	}
	public Integer getActivityID() {
		return activityid;
	}
	public void setActivityID(Integer activityID) {
		this.activityid = activityID;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getCharges() {
		return charges;
	}
	public void setCharges(Double charges) {
		this.charges = charges;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	@Override
	public String toString() {
		return "ActivityDTO [activityID=" + activityid + ", description=" + description + ", charges=" + charges
				+ ", age=" + age + ", capacity=" + capacity + "]";
	}
	
	
	
}
