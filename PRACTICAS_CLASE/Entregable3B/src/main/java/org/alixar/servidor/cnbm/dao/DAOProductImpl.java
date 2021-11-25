package org.alixar.servidor.cnbm.dao;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.alixar.servidor.cnbm.db.ConexionBD;
import org.alixar.servidor.cnbm.model.Product;

public class DAOProductImpl implements DAOProduct{

	@Override
	public List<Product> getAllProducts() {
		ArrayList <Product> productList = new ArrayList<>();
		Product product;
		
		try {

			String sql = "select * from products";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				product = new Product();

				product.setProductName(rs.getString("productCode"));
				product.setProductCode(rs.getString("productName"));
				product.setProductLine(rs.getString("productLine"));
//				product.setProductScale(rs.getNString("productScale"));
//				product.setProductVendor(rs.getString("productVendor"));
//				product.setProductDescription(rs.getString("productDescription"));
				product.setQuantityInStock(rs.getInt("quantityInStock"));
				product.setBuyPrice(rs.getDouble("buyPrice"));
//				product.setMSRP(rs.getDouble("MSRP"));

				productList.add(product);
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			ConexionBD.close();			
		}

		return productList;
		
	}

	@Override
	public ArrayList<Product> getProduct(String searchTerm) {
		
		ArrayList<Product> productsList = new ArrayList<>();
		
		Product product;
		
		try {

			String sql = "select * from products where productName LIKE ? OR productLine LIKE ?";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			statement.setString(1, "%"+searchTerm+"%");
			statement.setString(2, "%"+searchTerm+"%");
			
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				product = new Product();

				product.setProductCode(rs.getString("productCode"));
				product.setProductName(rs.getString("productName"));
				product.setProductLine(rs.getString("productLine"));
				product.setProductScale(rs.getNString("productScale"));
				product.setProductVendor(rs.getString("productVendor"));
				product.setProductDescription(rs.getString("productDescription"));
				product.setQuantityInStock(rs.getInt("quantityInStock"));
				product.setBuyPrice(rs.getDouble("buyPrice"));
				product.setMSRP(rs.getDouble("MSRP"));

				productsList.add(product);
				
			}


		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			ConexionBD.close();			
		}

		return productsList;
		
	}

}
