package org.alixar.servidor.dao;

import java.util.List;

import org.alixar.servidor.model.Payments;

public interface DAOPayments {

	public List<Payments> getAllPayments();
	public Payments getPayment(int customerNumber,String checkNumber);
	public boolean removePayment(int customerNumber,String checkNumber);
	public boolean updatePayment(Payments payment);
	public boolean addPayment(Payments payment);
	
}
