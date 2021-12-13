package org.alixar.servidor.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.alixar.servidor.bd.PoolDB;
import org.alixar.servidor.model.Product;

public class DAOProductImpl implements DAOProduct{

	@Override
	public List<Product> getAllProducts() {
		ArrayList <Product> productList = new ArrayList<>();
		Product product;
		Connection con = null;
		
		try {

			String sql = "select * from products";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				product = new Product();

				product.setProductCode(rs.getString("productCode"));
				product.setProductName(rs.getString("productName"));
				product.setProductLine(rs.getString("productLine"));
				product.setProductScale(rs.getString("productScale"));
				product.setProductVendor(rs.getString("productVendor"));
				product.setProductDescription(rs.getString("productDescription"));
				product.setQuantityInStock(rs.getInt("quantityInStock"));
				product.setBuyPrice(rs.getDouble("buyPrice"));
				product.setMSRP(rs.getDouble("MSRP"));

				productList.add(product);
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}

		return productList;
		
	}

	@Override
	public Product getProductCategory(String productLine) {
		
		Product product = null;
		Connection con = null;
		
		try {

			String sql = "select productLine from products";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, productLine);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				product = new Product();

//				product.setProductCode(rs.getString("productCode"));
//				product.setProductName(rs.getString("productName"));
				product.setProductLine(rs.getString("productLine"));
//				product.setProductScale(rs.getString("productScale"));
//				product.setProductVendor(rs.getString("productVendor"));
//				product.setProductDescription(rs.getString("productDescription"));
//				product.setQuantityInStock(rs.getInt("quantityInStock"));
//				product.setBuyPrice(rs.getDouble("buyPrice"));
//				product.setMSRP(rs.getDouble("MSRP"));
				
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}

		return product;
		
	}

//	@Override
//	public ArrayList<Product> getProduct(String searchTerm) {
//		
//		ArrayList<Product> productsList = new ArrayList<>();
//		Product product;
//		Connection con = null;
//		
//		try {
//
//			String sql = "select * from products where productName LIKE ? OR productLine LIKE ?";
//			PoolDB pool = new PoolDB();
//			con = pool.getConnection();
//			PreparedStatement statement = con.prepareStatement(sql);
//			
//			statement.setString(1, "%"+searchTerm+"%");
//			statement.setString(2, "%"+searchTerm+"%");
//			
//			ResultSet rs = statement.executeQuery();
//
//			while (rs.next()) {
//
//				product = new Product();
//
//				product.setProductCode(rs.getString("productCode"));
//				product.setProductName(rs.getString("productName"));
//				product.setProductLine(rs.getString("productLine"));
//				product.setProductScale(rs.getString("productScale"));
//				product.setProductVendor(rs.getString("productVendor"));
//				product.setProductDescription(rs.getString("productDescription"));
//				product.setQuantityInStock(rs.getInt("quantityInStock"));
//				product.setBuyPrice(rs.getDouble("buyPrice"));
//				product.setMSRP(rs.getDouble("MSRP"));
//
//				productsList.add(product);
//				
//			}
//
//
//		} catch (SQLException ex) {
//			System.out.println(ex.getMessage());
//		} finally {
//			try {
//				con.close();
//			} catch (SQLException ex) {
//				System.out.println(ex.getMessage());
//			}
//		}
//
//		return productsList;
//		
//	}
	
//	@Override
//	public Product getProductByCode(String productCode) {
//		
//		Product product = null;
//		Connection con = null;
//		
//		try {
//
//			String sql = "select * from products where productCode=?";
//			PoolDB pool = new PoolDB();
//			con = pool.getConnection();
//			PreparedStatement statement = con.prepareStatement(sql);
//			statement.setString(1, productCode);
//
//			ResultSet rs = statement.executeQuery();
//
//			while (rs.next()) {
//
//				product = new Product();
//
//				product.setProductCode(rs.getString("productCode"));
//				product.setProductName(rs.getString("productName"));
//				product.setProductLine(rs.getString("productLine"));
//				product.setProductScale(rs.getString("productScale"));
//				product.setProductVendor(rs.getString("productVendor"));
//				product.setProductDescription(rs.getString("productDescription"));
//				product.setQuantityInStock(rs.getInt("quantityInStock"));
//				product.setBuyPrice(rs.getDouble("buyPrice"));
//				product.setMSRP(rs.getDouble("MSRP"));
//				
//			}
//
//		} catch (SQLException ex) {
//			System.out.println(ex.getMessage());
//		} finally {
//			try {
//				con.close();
//			} catch (SQLException ex) {
//				System.out.println(ex.getMessage());
//			}
//		}
//
//		return product;
//		
//	}

//	@Override
//	public boolean updateProduct(Product product) {
//		
//		int resultado=0;
//		Connection con = null;
//		
//		try {
//
////			String sql = "update products set productName=?, productLine=?, productScale=?,"
////					+ "productVendor=?, productDescription=?, quantityInStock=?, buyPrice=?, MSRP=? where productCode=?";
//			String sql = "update products set quantityInStock= ?, buyPrice= ? where productCode=?";
//			
//			PoolDB pool = new PoolDB();
//			con = pool.getConnection();
//			PreparedStatement statement = con.prepareStatement(sql);
//			
////			statement.setString(1, product.getProductName());
////			statement.setString(2, product.getProductLine());
////			statement.setString(3, product.getProductScale());
////			statement.setString(4, product.getProductVendor());
////			statement.setString(5, product.getProductDescription());
//			statement.setInt(1, product.getQuantityInStock());
//			statement.setDouble(2, product.getBuyPrice());
////			statement.setDouble(8, product.getMSRP());
//			statement.setString(3, product.getProductCode());
//			
////			ResultSet rs = statement.executeQuery();
//			
//			resultado = statement.executeUpdate();			
//
//		} catch (SQLException ex) {
//			System.out.println(ex.getMessage());
//		} finally {
//			try {
//				con.close();
//			} catch (SQLException ex) {
//				System.out.println(ex.getMessage());
//			}
//		}
//
//		return (resultado==0?false:true);
//		
//	}

}
