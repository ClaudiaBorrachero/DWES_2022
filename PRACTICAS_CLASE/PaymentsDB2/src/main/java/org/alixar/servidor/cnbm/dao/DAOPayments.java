package org.alixar.servidor.cnbm.dao;

import java.util.ArrayList;

import org.alixar.servidor.cnbm.model.Payments;

public interface DAOPayments {

	public Payments getPayments(int customerNumber, String checkNumber);
	public ArrayList<Payments> getAllPayments();
	public boolean removePayments(int customerNumber, String checkNumber);
	public boolean updatePayments(Payments payment);
	
}
