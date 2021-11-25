package org.alixar.servidor.cnbm.dao;

import java.util.ArrayList;

import java.util.List;

import org.alixar.servidor.cnbm.model.Product;


public interface DAOProduct {

	public List<Product> getAllProducts();
	public ArrayList<Product> getProduct(String searchTerm);
	
}
