package org.alixar.servidor.dao;

import java.util.ArrayList;

import org.alixar.servidor.model.Products;

public interface DAOProducts {

	public ArrayList<Products> getAllProducts();
	public Products getProducts(String productName);
	public ArrayList<Products> getProduct(String searchTerm);
//	public Products getProductByCode(String productCode);
	
	public Products getProductByCode(String productCode);
	public int getDetailsOrderNumber(String productCode);
	public int getDetailsNumProductosVentas(String productCode);
	public double getDetailsNumVentasPrecio(String productCode);
	
}
