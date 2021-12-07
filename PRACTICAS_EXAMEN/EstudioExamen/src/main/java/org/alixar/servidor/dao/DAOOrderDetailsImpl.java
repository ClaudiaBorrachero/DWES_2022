package org.alixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.alixar.servidor.db.PoolDB;
import org.alixar.servidor.model.OrderDetails;
import org.alixar.servidor.model.Products;

public class DAOOrderDetailsImpl implements DAOOrderDetails {


	@Override
	public ArrayList<OrderDetails> getDetailsFromOrder(int orderNumber) {
		
		ArrayList<OrderDetails> orderdetails = new ArrayList<OrderDetails>();
		OrderDetails od = null;
		Products product = null;
		Connection con = null;

		try {

			String sql = "select * from orderdetails where  orderNumber = ?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setInt(1, orderNumber);
			

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				
				od = new OrderDetails();
				od.setOrderLineNumber(rs.getInt("orderLineNumber"));
				od.setPriceEach(rs.getDouble("priceEach"));
				od.setQuantityOrdered(rs.getInt("quantityOrdered"));
				
				String productCode = rs.getString("productCode");
				
				DAOProductsImpl daoProduct = new DAOProductsImpl();
				
				product = daoProduct.getProductByCode(productCode);
				
				od.setProduct(product);
				
				orderdetails.add(od);
				
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

		return orderdetails;
		
	}
	
//	@Override
//	public ArrayList<OrderDetails> getOrderDetails(int orderNumber) {
//
//		ArrayList<OrderDetails> orderDetails = new ArrayList<OrderDetails>();
//		OrderDetails od = null;
//		Products product = null;
//		Connection con = null;
//
//		try {
//
//			String sql = "select * from ordersDetails where orderNumber=?";
//			PoolDB pool = new PoolDB();
//			con = pool.getConnection();
//			PreparedStatement statement = con.prepareStatement(sql);
//
//			ResultSet rs = statement.executeQuery();
//
//			while (rs.next()) {
//
//				od = new OrderDetails();
//
//				String productCode = rs.getString("productCode");
//				DAOProductsImpl daoProductImpl = new DAOProductsImpl();
//				product = daoProductImpl.getProductByCode(productCode);
//
//				od.setProduct(product);
//				od.setQuantityOrdered(rs.getInt("quantityOrdered"));
//				od.setPriceEach(rs.getDouble("priceEach"));
//				od.setOrderLineNumber(rs.getInt("orderLineNumber"));
//
//				orderDetails.add(od);
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
//		return orderDetails;
//
//	}
	
}
