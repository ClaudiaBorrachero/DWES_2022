package org.alixar.servidor.dao;

import java.util.ArrayList;

import org.alixar.servidor.model.Employees;
import org.alixar.servidor.model.Usuario;

public interface DAOEmployees {

	public ArrayList<Employees> getEmployeesSearch(String officeCode);
	public ArrayList<Employees> getAllEmployees();
	public boolean addEmployee(Employees employee);
	public Employees getEmployee(int employeeNumber);
}
