package com.mukunth.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mukunth.dao.EmployeeDaoImpl;
import com.mukunth.dao.EmployeeDaoImpl;
import com.mukunth.model.Employee;
import com.mukunth.model.Employee;

@Produces(MediaType.APPLICATION_JSON)
public class EmployeeService {
	
	@GET
	public Response getList() {
		List<Employee> employee = EmployeeDaoImpl.getInstance().getEmployee();
		return Response.status(200).entity(employee).build();
	}
	
	@GET
	@Path("{employeeId}")
	public Response getEmployee(@PathParam("employeeId") int employeeId) {
		Employee employee = EmployeeDaoImpl.getInstance().getEmployeeByID(employeeId);
	return Response.status(200).entity(employee).build();
	}
	
	@DELETE
	@Path("{employeeId}")
	public Response deleteEmployee(@PathParam("employeeId") int employeeId) {
		int n = EmployeeDaoImpl.getInstance().deleteEmployeeByID(employeeId);
		if(n > 0) 
			return Response.status(204).build();
		else
			return Response.status(404).entity("Employee details not found").build();
	}	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createEmployee(Employee Employee) {
		int n = EmployeeDaoImpl.getInstance().createEmployeeByID(Employee);
		if(n > 0) {
			return Response.status(201).build();
		}
			else
			return Response.status(500).entity("Internal Server Error").build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{employeeId}")
	public Response updateEmployee(Employee employee, @PathParam("employeeId") int employeeId) {
		employee.setId(employeeId);
		int n = EmployeeDaoImpl.getInstance().updateEmployeeByID(employee);
		if(n > 0) {
			return Response.status(204).build();
		}
			else
			return Response.status(404).entity("Id not valid").build();
	}

}
