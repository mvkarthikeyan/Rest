package com.mukunth.service;

import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.GET;
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
} 