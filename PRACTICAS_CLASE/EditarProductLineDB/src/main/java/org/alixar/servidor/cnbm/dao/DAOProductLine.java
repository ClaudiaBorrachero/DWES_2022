package org.alixar.servidor.cnbm.dao;

import java.util.List;

import org.alixar.servidor.cnbm.model.Products;

public interface DAOProductLine {

	public List<Products> getAllProducts();
	public Products getProducts(String productLine);
	public boolean removeProducts(String productLine);
	public boolean updateProducts(Products productLine);
	public boolean addProducts(Products productLine);
	
}
