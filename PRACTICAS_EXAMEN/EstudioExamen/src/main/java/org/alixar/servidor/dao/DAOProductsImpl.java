package org.alixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.alixar.servidor.db.PoolDB;
import org.alixar.servidor.model.Customers;
import org.alixar.servidor.model.Products;

public class DAOProductsImpl implements DAOProducts {

	@Override
	public ArrayList<Products> getAllProducts() {
		
		ArrayList<Products> productsrList = new ArrayList<>();
		Connection con = null;

		try {

			String sql = "select * from products";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				Products product = new Products();

				product.setProductCode(rs.getString("productCode"));
				product.setProductName(rs.getString("productName"));
				product.setProductLine(rs.getString("productLine"));
				product.setProductScale(rs.getString("productScale"));
				product.setProductVendor(rs.getString("productVendor"));
				product.setProductDescription(rs.getString("productDescription"));
				product.setQuantityInStock(rs.getInt("quantityInStock"));
				product.setBuyPrice(rs.getDouble("buyPrice"));
				product.setMSRP(rs.getDouble("MSRP"));
				
				productsrList.add(product);
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

		return productsrList;
		
	}
	
	@Override
	public Products getProducts(String productName) {

		Products product = null;
		Connection con = null;

		try {

			String sql = "select * from products where productName=?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				product = new Products();

				product.setProductCode(rs.getString("productCode"));
				product.setProductName(rs.getString("productName"));
				product.setProductLine(rs.getString("productLine"));
				product.setProductScale(rs.getNString("productScale"));
				product.setProductVendor(rs.getString("productVendor"));
				product.setProductDescription(rs.getString("productDescription"));
				product.setQuantityInStock(rs.getInt("quantityInStock"));
				product.setBuyPrice(rs.getDouble("buyPrice"));
				product.setMSRP(rs.getDouble("MSRP"));

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


	@Override
	public ArrayList<Products> getProduct(String searchTerm) {
	
		ArrayList<Products> productsList = new ArrayList<>();
		Products product;
		Connection con = null;
		
		try {

			String sql = "select * from products where productName LIKE ? OR productLine LIKE ?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, "%"+searchTerm+"%");
			statement.setString(2, "%"+searchTerm+"%");
			
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				product = new Products();

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
			try {
				con.close();
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}

		return productsList;
		
	}

//	@Override
//	public Products getProductByCode(String productCode) {
//		
//		Products product = null;
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
//				product = new Products();
//
//				product.setProductCode(rs.getString("productCode"));
//				product.setProductName(rs.getString("productName"));
//				product.setProductLine(rs.getString("productLine"));
//				product.setProductScale(rs.getNString("productScale"));
//				product.setProductVendor(rs.getString("productVendor"));
//				product.setProductDescription(rs.getString("productDescription"));
//				product.setQuantityInStock(rs.getInt("quantityInStock"));
//				product.setBuyPrice(rs.getDouble("buyPrice"));
//				product.setMSRP(rs.getDouble("MSRP"));
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
//		return product;
//		
//	}
	
	@Override
	public Products getProductByCode(String productCode) {
		
		Products product = null;
		Connection con = null;

		try {

			String sql = "select * from products where productCode=?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, productCode);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				product = new Products();
				product.setProductCode(rs.getString("productCode"));
				product.setProductName(rs.getString("productName"));
				product.setProductLine(rs.getString("productLine"));
				product.setProductScale(rs.getString("productScale"));
				product.setProductVendor(rs.getString("productVendor"));
				product.setProductDescription(rs.getString("productDescription"));
				product.setQuantityInStock(rs.getInt("quantityInStock"));
				product.setBuyPrice(rs.getDouble("buyPrice"));
				product.setMSRP(rs.getDouble("MSRP"));

			}
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}  finally {
			try {
				con.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

		return product;
		
	}

	@Override
	public int getDetailsOrderNumber(String productCode) {
		
		Connection con = null;
		int total = 0;
		
		try {

			String sql = "select count(*) from orderdetails where productCode=?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, productCode);
			
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				total = rs.getInt(1);
				
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException ex){
				System.out.println(ex.getMessage());
			}
		}

		return total;
		
	}

	@Override
	public int getDetailsNumProductosVentas(String productCode) {
	
		Connection con = null;
		int total = 0;
		
		try {

			String sql = "select sum(quantityOrdered) from orderdetails where productCode=?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, productCode);
			
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				total = rs.getInt(1);
				
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException ex){
				System.out.println(ex.getMessage());
			}
		}

		return total;
		
	}

	@Override
	public double getDetailsNumVentasPrecio(String productCode) {
		
		Connection con = null;
		double total = 0;
		
		try {

			String sql = "select (sum(quantityOrdered))*priceEach from orderdetails where productCode=?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, productCode);
			
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				total = rs.getDouble(1);
				
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException ex){
				System.out.println(ex.getMessage());
			}
		}

		return total;
		
	}

}
