package com.mukunth.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mukunth.general.ConnectionManager;
import com.mukunth.model.Company;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class CompanyDaoImpl implements CompanyDao {
	
	private static final CompanyDao companyDao = new CompanyDaoImpl();

	public static CompanyDao getInstance() {
		return companyDao;
	}
	
	private CompanyDaoImpl() {
		
	}
	
	@Override
	public List<Company> getCompany() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Company> companyList = new ArrayList<Company>();
		con = (Connection) ConnectionManager.getConnection();
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from company_master");
			while(rs.next()) {
			Company company = new Company(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getInt(4));
			companyList.add(company);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(con);
		}
		return companyList;
	}

	@Override
	public Company getCompanyByID(int id) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		con = (Connection) ConnectionManager.getConnection();
		Company company = null;
		try {
			pst = (PreparedStatement) con.prepareStatement("select * from company_master where id=?");
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while(rs.next()) {
				company = new Company(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(con);
		}
		
		return company;
	}

}
