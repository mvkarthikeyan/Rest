package com.mukunth.service;

import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.mukunth.dao.CompanyDaoImpl;
import com.mukunth.model.Company;

@Path("/company")
public class CompanyService {
 
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getList() {
		List<Company> company = CompanyDaoImpl.getInstance().getCompany();
		if(company == null)
		return Response.status(404).entity("No Details availabe").build();
		else
		return Response.status(200).entity(company).build();
	}
 
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompany(@PathParam("id") int id) {
		Company company = CompanyDaoImpl.getInstance().getCompanyByID(id);
		if(company == null)
			return Response.status(404).entity("Company not availabe").build();
			else
			return Response.status(200).entity(company).build();
	}
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteCompany(@PathParam("id") int id) {
		int n = CompanyDaoImpl.getInstance().deleteCompanyByID(id);
		if(n > 0) {
			List<Company> company = CompanyDaoImpl.getInstance().getCompany();
			if(company.size() > 0)
				return Response.status(200).entity(company).build();
			else
				return Response.status(204).build();
		}
		else
			return Response.status(404).entity("Company details not found").build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createCompany(Company company) {
		int n = CompanyDaoImpl.getInstance().createCompanyByID(company);
		if(n > 0) {
			List<Company> companies = CompanyDaoImpl.getInstance().getCompany();
			return Response.status(201).entity(companies).build();
		}
			else
			return Response.status(500).entity("Internal Server Error").build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateCompany(Company company) {
		int n = CompanyDaoImpl.getInstance().updateCompanyByID(company);
		if(n > 0) {
			List<Company> companies = CompanyDaoImpl.getInstance().getCompany();
			return Response.status(204).entity(companies).build();
		}
			else
			return Response.status(404).entity("Id not valid").build();
	}
	
} 