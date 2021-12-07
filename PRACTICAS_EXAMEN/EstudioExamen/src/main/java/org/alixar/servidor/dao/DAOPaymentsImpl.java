package org.alixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.alixar.servidor.db.PoolDB;
import org.alixar.servidor.model.Payments;

public class DAOPaymentsImpl implements DAOPayments{

	@Override
	public List<Payments> getAllPayments() {
		
		ArrayList<Payments> paymentsList = new ArrayList<>();
		Payments customer;
		Connection con = null;

		try {

			String sql = "select * from payments";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				Payments payment = new Payments();

				payment.setCustomerNumber(rs.getInt("customerNumber"));
				payment.setCheckNumber(rs.getString("checkNumber"));
				payment.setDate(rs.getString("paymentDate"));
				payment.setAmount(rs.getDouble("amount"));

				paymentsList.add(payment);

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

		return paymentsList;
		
	}

	@Override
	public Payments getPayment(int customerNumber, String checkNumber) {
		
		Payments payment = null;
		Connection con = null;

		try {

			String sql = "select * from payments where customerNumber= ? and checkNumber= ?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, customerNumber);
			statement.setString(2, checkNumber);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				payment = new Payments();

				payment.setCustomerNumber(rs.getInt("customerNumber"));
				payment.setCheckNumber(rs.getString("checkNumber"));
				payment.setDate(rs.getString("paymentDate"));
				payment.setAmount(rs.getDouble("amount"));

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

		return payment;
		
	}

	@Override
	public boolean removePayment(int customerNumber, String checkNumber) {
		
		int resultado=0;
		Connection con = null;
		
		try {

			String sql = "delete from payments where customerNumber=? and checkNumber=?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, customerNumber);
			statement.setString(2, checkNumber);

			resultado = statement.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}

		return (resultado==0?false:true);
		
	}

	@Override
	public boolean updatePayment(Payments payment) {
		
		int resultado=0;
		Connection con = null;
		
		try {

			String sql = "update payments set paymentDate= ?, amount=? where customerNumber = ? and checkNumber = ?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setString(1,payment.getDate());
			statement.setDouble(2, payment.getAmount());
			statement.setInt(3, payment.getCustomerNumber());
			statement.setString(4, payment.getCheckNumber());
			

			resultado = statement.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}

		return (resultado==0?false:true);
		
	}

	@Override
	public boolean addPayment(Payments payment) {
		
		int resultado=0;
		Connection con = null;
		
		try {

			String sql = "insert into payments values(?,?,?,?)";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setInt(1, payment.getCustomerNumber());
			statement.setString(2, payment.getCheckNumber());
			statement.setString(3,payment.getDate());
			statement.setDouble(4, payment.getAmount());
			

			resultado = statement.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}

		return (resultado==0?false:true);
		
	}

}
