package com.mukunth.model;

public class Person {
	
	int id;
	String name;
	String department;
	
	public Person(int id, String name, String department) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
	}
	
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDepartment() {
		return department;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", department="
				+ department + "]";
	}
	
	
}
