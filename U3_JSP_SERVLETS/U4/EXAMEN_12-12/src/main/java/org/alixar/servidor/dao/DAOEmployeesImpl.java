package org.alixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.alixar.servidor.bd.PoolDB;
import org.alixar.servidor.model.Employees;
import org.alixar.servidor.model.Usuario;

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

	@Override
	public boolean addEmployee(Employees employee) {
		
		int resultado=0;
		Connection con = null;
		
		try {

			String sql = "insert into employees values(?,?,?,?,?,?,?,?)";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setInt(1, employee.getEmployeeNumber());
			statement.setString(2, employee.getLastName());
			statement.setString(3, employee.getFirstName());
			statement.setString(4, employee.getExtension());
			statement.setString(5, employee.getEmail());
			statement.setString(6, employee.getOfficeCode());
			statement.setInt(7, employee.getReportsTo());
			statement.setString(8, employee.getJobTitle());
			
			resultado = statement.executeUpdate();


		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
		
		return (resultado==0?false:true);
		
	}

	@Override
	public Employees getEmployee(int employeeNumber) {
		
		Employees employee = null;
		Connection con = null;
		
		try {
			
			String sql = "select * from employees where employeeNumber=?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setInt(1, employeeNumber);
			
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

		return employee;
		
	}

}
