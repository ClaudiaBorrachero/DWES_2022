package org.alixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.alixar.servidor.db.PoolDB;
import org.alixar.servidor.model.OrderDetails;
import org.alixar.servidor.model.Orders;

public class DAOOrdersImpl implements DAOOrders {

	@Override
	public Orders getOrder(int orderNumber) {

		Orders order = null;
		Connection con = null;

		try {

			String sql = "select * from orders where orderNumber=?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
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

				DAOOrderDetailsImpl daoOrdersDetailsImpl = new DAOOrderDetailsImpl();
				ArrayList<OrderDetails> ordersDetails = daoOrdersDetailsImpl.getDetailsFromOrder(orderNumber);

				order.setOrderDetails(ordersDetails);

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

		return order;

	}

	@Override
	public ArrayList<Orders> getAllOrders() {

		ArrayList<Orders> ordersList = new ArrayList<>();
		Orders order;
		Connection con = null;

		try {

			String sql = "select * from orders";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);

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

				DAOOrderDetailsImpl daoOrdersDetailsImpl = new DAOOrderDetailsImpl();
				ArrayList<OrderDetails> ordersDetails = daoOrdersDetailsImpl.getDetailsFromOrder(order.getOrderNumber());

				order.setOrderDetails(ordersDetails);

				ordersList.add(order);
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

		return ordersList;

	}

}
