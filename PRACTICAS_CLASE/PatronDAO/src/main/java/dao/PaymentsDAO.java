package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bd.ConexionBD;

public class PaymentsDAO {

	public static List<Payments> getPayments(){
		Connection con = ConexionBD.getConnection();
		ArrayList<Payments> lista_payments = new ArrayList<Payments>();
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from payments");
			
			while (rs.next()) {
				Payments p = new Payments(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4));
				lista_payments.add(p);
			}
		
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		
		return lista_payments;
	}
		
}
