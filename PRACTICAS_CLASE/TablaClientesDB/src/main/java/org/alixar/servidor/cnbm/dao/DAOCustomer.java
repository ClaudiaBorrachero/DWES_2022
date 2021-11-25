package org.alixar.servidor.cnbm.dao;

import java.util.ArrayList;

import org.alixar.servidor.cnbm.model.Customer;

public interface DAOCustomer {

	public Customer getCustomer(int customerNumber);
	public ArrayList<Customer> getAllCustomer();
	
}
