package com.mukunth.model;

public class Company {
	
	int id;
	String CompanyName;
	String floor;
	int contactNumber;
	
	public Company(int id, String companyName, String floor, int contactNumber) {
		super();
		this.id = id;
		CompanyName = companyName;
		this.floor = floor;
		this.contactNumber = contactNumber;
	}

	public int getId() {
		return id;
	}

	public String getCompanyName() {
		return CompanyName;
	}

	public String getFloor() {
		return floor;
	}

	public int getContactNumber() {
		return contactNumber;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	

}
