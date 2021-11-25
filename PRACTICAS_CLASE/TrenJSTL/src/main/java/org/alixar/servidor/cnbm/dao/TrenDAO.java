package org.alixar.servidor.cnbm.dao;

import java.util.ArrayList;

import org.alixar.servidor.cnbm.model.Tren;

public interface TrenDAO {

	public Tren getCustomer(int customerNumber);
	public ArrayList<Tren> getAllCustomer();
	
}
