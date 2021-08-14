package com.ms.practiceServiceTwo.models;

public class ServiceTwo {

	private String name;
	private String mobile_no;
	private String description;
	
	public ServiceTwo() {
		
	}
	public ServiceTwo(String name, String mobile_no, String description) {
		super();
		this.name = name;
		this.mobile_no = mobile_no;
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
