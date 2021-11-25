package org.alixar.servidor.cnbm.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.alixar.servidor.cnbm.bd.ConexionDB;
import org.alixar.servidor.cnbm.model.Payments;

public class DAOPaymentsImpl implements DAOPayments {

	public DAOPaymentsImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Payments getPayments(int customerNumber, String checkNumber) {
		
		Payments payments = null;
		
		try {
			
			String sql = "select * from payments where customerNumber= ? and checkNumber = ?";
			PreparedStatement statement = ConexionDB.getConnection().prepareStatement(sql);
			statement.setInt(1, customerNumber);
			statement.setString(2, checkNumber);
			
			ResultSet rs = statement.executeQuery();
			
			//Como el campo de búsqueda es la clave solo debería obtener un resultado
			//si no es así estaremos machacando cada vez el valor de customer y 
			while (rs.next() ) {
				
				payments = new Payments();
				
				payments.setCustomerNumber(rs.getInt("customerNumber"));
				payments.setCheckNumber(rs.getString("checkNumber"));
				payments.setPaymentDate(rs.getString("paymentDate"));
				payments.setAmount(rs.getDouble("amount"));
				
			}
			
			ConexionDB.close();
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		
		
		return payments;
		
	}

	@Override
	public ArrayList<Payments> getAllPayments() {
		
		ArrayList<Payments> paymentsList = new ArrayList<>();
		Payments payments;
		
		try {
			
			String sql = "select * from payments";
			PreparedStatement statement = ConexionDB.getConnection().prepareStatement(sql);			
			
			ResultSet rs = statement.executeQuery();
			
			 
			while (rs.next() ) {
				
				payments = new Payments();
				
				payments.setCustomerNumber(rs.getInt("customerNumber"));
				payments.setCheckNumber(rs.getString("checkNumber"));
				payments.setPaymentDate(rs.getString("paymentDate"));
				payments.setAmount(rs.getDouble("amount"));
				
				paymentsList.add(payments);
				
			}
			
			ConexionDB.close();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}		
		
		return paymentsList;
		
		
	}

	@Override
	public boolean removePayments(int customerNumber, String checkNumber) {
		
		int rs = 0;
		
		try {
			
			String sql = "delete * from payments where customerNumber= ? and checkNumber = ?";
			PreparedStatement statement = ConexionDB.getConnection().prepareStatement(sql);
			statement.setInt(1, customerNumber);
			statement.setString(2, checkNumber);
			
			rs = statement.executeUpdate();
						
			ConexionDB.close();
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return (rs==0 ? false : true);
		
	}

	@Override
	public boolean updatePayments(Payments payment) {

		int rs = 0;
		
		try {
			
			String sql = "update payments set value(?,?,?,?) where customerNumber = ? and checkNumber = ?";
			PreparedStatement statement = ConexionDB.getConnection().prepareStatement(sql);
			statement.setInt(1, payment.getCustomerNumber());
			statement.setString(2, payment.getCheckNumber());
			statement.setString(3, payment.getPaymentDate());
			statement.setDouble(4, payment.getAmount());
			statement.setInt(5, payment.getCustomerNumber());
			statement.setString(6, payment.getCheckNumber());
			
			rs = statement.executeUpdate(sql);
						
			ConexionDB.close();
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return (rs==0 ? false : true);
		
	}

}
