package com.mukunth.model;

public class Company {
	
	int id;
	String companyName;
	String hrPerson;
	String contactNumber;
	
	public Company(int id, String companyName, String hrPerson, String contactNumber) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.hrPerson = hrPerson;
		this.contactNumber = contactNumber;
	}
	
	public Company(String companyName, String hrPerson, String contactNumber) {
		super();
		this.companyName = companyName;
		this.hrPerson = hrPerson;
		this.contactNumber = contactNumber;
	}

	public Company() {
		super();
	}

	public int getId() {
		return id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String gethrPerson() {
		return hrPerson;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void sethrPerson(String hrPerson) {
		this.hrPerson = hrPerson;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	

}
