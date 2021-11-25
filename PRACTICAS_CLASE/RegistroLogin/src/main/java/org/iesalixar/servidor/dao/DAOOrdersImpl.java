package org.iesalixar.servidor.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.iesalixar.servidor.bd.ConexionBD;
import org.iesalixar.servidor.model.Orders;
import org.iesalixar.servidor.model.OrdersDetails;

public class DAOOrdersImpl implements DAOOrders{

	@Override
	public Orders getOrder(int orderNumber) {
		
		Orders order = null;
		
		try {

			String sql = "select * from orders where orderNumber=?";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			statement.setInt(1, orderNumber);
			
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				order = new Orders();
				
				order.setOrderNumber(rs.getInt("orderNumber"));
				order.setOrderDate(rs.getString("orderDate"));
				order.setRequiredDate(rs.getString("requiredDate"));
				order.setShippedDate(rs.getString("shippedDate"));
				order.setStatus(rs.getString("status"));
				order.setComments(rs.getString("comments"));
				order.setCustomerNumber(rs.getInt("customerNumber"));

				DAOOrdersDetailsImpl daoOrdersDetailsImpl = new DAOOrdersDetailsImpl();
				ArrayList<OrdersDetails> ordersDetails = daoOrdersDetailsImpl.getOrdersDetails(orderNumber);
				
				order.setOrdersDetails(ordersDetails);
				
			}

			ConexionBD.close();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return order;
	}
	

	@Override
	public ArrayList<Orders> getAllOrders() {
		
		ArrayList <Orders> ordersList = new ArrayList<>();
		Orders order;
		
		try {

			String sql = "select * from orders";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				ordersList = new ArrayList<Orders>();
				order = new Orders();
				
				order.setOrderNumber(rs.getInt("orderNumber"));
				order.setOrderDate(rs.getString("orderDate"));
				order.setRequiredDate(rs.getString("requiredDate"));
				order.setShippedDate(rs.getString("shippedDate"));
				order.setStatus(rs.getString("status"));
				order.setComments(rs.getString("comments"));
				order.setCustomerNumber(rs.getInt("customerNumber"));
				
				DAOOrdersDetailsImpl daoOrdersDetailsImpl = new DAOOrdersDetailsImpl();
				ArrayList<OrdersDetails> ordersDetails = daoOrdersDetailsImpl.getOrdersDetails(0);
				
				order.setOrdersDetails(ordersDetails);
				
				ordersList.add(order);
			}

			ConexionBD.close();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return ordersList;
		
	}

//	//Pedidos de un usuario concreto
//	@Override
//	public ArrayList<Orders> getOrders(int customerNumber) {
//		
//		ArrayList <Orders> ordersList = new ArrayList<>();
//		Orders order;
//		
//		try {
//
//			String sql = "select * from orders where customerNumber=?";
//			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
//
//			ResultSet rs = statement.executeQuery();
//
//			while (rs.next()) {
//
//				order = new Orders();
//				
//				order.setOrderNumber(rs.getInt("orderNumber"));
//				order.setOrderDate(rs.getString("orderDate"));
//				order.setRequiredDate(rs.getString("requiredDate"));
//				order.setShippedDate(rs.getString("shippedDate"));
//				order.setStatus(rs.getString("status"));
//				order.setComments(rs.getString("comments"));
//				order.setCustomerNumber(rs.getInt("customerNumber"));
////				order.setOrdersDetails(rs.getString("ordersDetails"));
//				
//				ordersList.add(order);
//			}
//
//			ConexionBD.close();
//		} catch (SQLException ex) {
//			System.out.println(ex.getMessage());
//		}
//
//		return ordersList;
//	}

}
