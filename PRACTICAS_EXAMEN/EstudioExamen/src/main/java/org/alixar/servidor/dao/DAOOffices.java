package org.alixar.servidor.dao;

import java.util.List;

import org.alixar.servidor.model.Offices;

public interface DAOOffices {

	public List<Offices> getAllOficinas();
	public Offices getOffice(String officeCode);
	
}
