package org.alixar.servidor.dao;

import java.util.ArrayList;

import org.alixar.servidor.model.Employees;

public interface DAOEmployees {

	public ArrayList<Employees> getEmployeesSearch(String officeCode);
	public ArrayList<Employees> getAllEmployees();
	
}
