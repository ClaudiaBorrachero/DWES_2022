package org.alixar.servidor.dao;

import java.util.ArrayList;

import org.alixar.servidor.model.Orders;

public interface DAOOrders {

	public Orders getOrder(int orderNumber);
	public ArrayList<Orders> getAllOrders();
	
}
