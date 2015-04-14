package com.mukunth.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mukunth.general.ConnectionManager;
import com.mukunth.model.Company;
import com.mukunth.model.Employee;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class EmployeeDaoImpl implements EmployeeDao {
	
	private static final EmployeeDao employeeDao = new EmployeeDaoImpl();

	public static EmployeeDao getInstance() {
		return employeeDao;
	}
	
	private EmployeeDaoImpl() {
		
	}
	
	@Override
	public List<Employee> getEmployee() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Employee> employeeList = new ArrayList<Employee>();
		con = (Connection) ConnectionManager.getConnection();
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from employee_master");
			while(rs.next()) {
				Employee employee = new Employee(rs.getInt(1),rs.getString(2), rs.getString(3));
				employeeList.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(con);
		}
		return employeeList;
	}

	@Override
	public Employee getEmployeeByID(int id) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		con = (Connection) ConnectionManager.getConnection();
		Employee employee = null;
		try {
			pst = (PreparedStatement) con.prepareStatement("select * from employee_master where employee_id=?");
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while(rs.next()) {
				employee = new Employee(rs.getInt(1),rs.getString(2), rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(con);
		}
		
		return employee;
	}

	@Override
	public int deleteEmployeeByID(int id) {
		Connection con = null;
		PreparedStatement pst = null;
		System.out.println(id);
		con = (Connection) ConnectionManager.getConnection();
		try {
			pst = (PreparedStatement) con.prepareStatement("delete from employee_master where employee_id=?");
			pst.setInt(1, id);
			return (pst.executeUpdate());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(con);
		}
		return 0;
	}

	@Override
	public int createEmployeeByID(Employee employee) {
		Connection con = null;
		PreparedStatement pst = null;
		con = (Connection) ConnectionManager.getConnection();
		try {
			pst = (PreparedStatement) con.prepareStatement("insert into employee_master (name,department) values (?,?)");
			pst.setString(1, employee.getName());
			pst.setString(2, employee.getDepartment());
			return (pst.executeUpdate());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(con);
		}
		return 0;
	}

	@Override
	public int updateEmployeeByID(Employee employee) {
		Connection con = null;
		PreparedStatement pst = null;
		con = (Connection) ConnectionManager.getConnection();
		try {
			pst = (PreparedStatement) con.prepareStatement("update employee_master set name=?,department=? where employee_id=? ");
			pst.setString(1, employee.getName());
			pst.setString(2, employee.getDepartment());
			pst.setInt(3, employee.getId());
			return (pst.executeUpdate());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(con);
		}
		
		return 0;
	}

}
