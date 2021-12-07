package org.alixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.alixar.servidor.db.PoolDB;
import org.alixar.servidor.model.Customers;
import org.alixar.servidor.model.Employees;

public class DAOEmployeesImpl implements DAOEmployees{

	@Override
	public ArrayList<Employees> getEmployeesSearch(String officeCode) {
		
		Connection con = null;
		ArrayList<Employees> employeesList = new ArrayList<Employees>();
		Employees employee = null;

		try {

			String sql = "select * from employees where officeCode=?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
						
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1,officeCode);
			
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				employee = new Employees();
				
				employee.setEmployeeNumber(rs.getInt("employeeNumber"));
				employee.setLastName(rs.getString("lastName"));
				employee.setFirstName(rs.getString("firstName"));
				employee.setExtension(rs.getString("extension"));
                employee.setEmail(rs.getString("email"));
                employee.setOfficeCode(rs.getString("officeCode"));
                employee.setReportsTo(rs.getInt("reportsTo"));
                employee.setJobTitle(rs.getString("jobTitle"));
				
				employeesList.add(employee);

			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}finally {
			try {
				con.close();
			} catch (SQLException ex){
				System.out.println(ex.getMessage());
			}
		}

		return employeesList;

		
	}

	@Override
	public ArrayList<Employees> getAllEmployees() {
		
		ArrayList<Employees> employeesList = new ArrayList<>();
		Connection con = null;

		try {

			String sql = "select * from employees";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				Employees employee = new Employees();

				employee.setEmployeeNumber(rs.getInt("employeeNumber"));
				employee.setFirstName(rs.getString("firstName"));
				employee.setLastName(rs.getString("lastName"));
				employee.setExtension(rs.getString("extension"));
				employee.setEmail(rs.getString("email"));
				employee.setOfficeCode(rs.getString("officeCode"));
				employee.setReportsTo(rs.getInt("reportsTo"));
				employee.setJobTitle(rs.getString("jobTitle"));
				
				employeesList.add(employee);
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}

		return employeesList;
		
	}

}
