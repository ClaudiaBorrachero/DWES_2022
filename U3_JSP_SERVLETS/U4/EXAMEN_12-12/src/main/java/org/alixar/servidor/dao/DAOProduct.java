package org.alixar.servidor.dao;

import java.util.ArrayList;


import java.util.List;
import org.alixar.servidor.model.Product;

public interface DAOProduct {

	public List<Product> getAllProducts();
//	public ArrayList<Product> getProduct(String searchTerm);
//	public Product getProductByCode(String productCode);
	public Product getProductCategory(String productLine);
//	public boolean updateProduct(Product product);
}
