package com.mukunth.dao;

import java.util.List;

import com.mukunth.model.Company;

public interface CompanyDao {
	
	List<Company> getCompany();
	
	Company getCompanyByID(int id);
	
	int deleteCompanyByID(int id);

	int createCompanyByID(Company company);

	int updateCompanyByID(Company company);

}
 