package org.alixar.servidor.dao;

import java.util.ArrayList;

import org.alixar.servidor.model.OrderDetails;

public interface DAOOrderDetails {

	public ArrayList<OrderDetails> getDetailsFromOrder(int orderNumber);
//	public ArrayList<OrderDetails> getOrderDetails(int orderNumber);
	
}
