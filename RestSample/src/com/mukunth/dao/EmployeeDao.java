package com.mukunth.dao;

import java.util.List;

import com.mukunth.model.Company;
import com.mukunth.model.Employee;

public interface EmployeeDao {
	
	List<Employee> getEmployee();
	
	int deleteEmployeeByID(int employeeId);

	int createEmployeeByID(Employee Employee);

	int updateEmployeeByID(Employee Employee);

	Employee getEmployeeByID(int employeeId);

}
 