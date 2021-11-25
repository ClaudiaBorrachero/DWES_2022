package org.iesalixar.servidor.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.iesalixar.servidor.bd.ConexionBD;
import org.iesalixar.servidor.model.OrdersDetails;
import org.iesalixar.servidor.model.Product;

public class DAOOrdersDetailsImpl implements DAOOrdersDetails{

	@Override
	public ArrayList<OrdersDetails> getOrdersDetails(int orderNumber) {
		
		ArrayList<OrdersDetails> ordersDetails = new ArrayList<OrdersDetails>();
		OrdersDetails od = null;
		Product product = null;
		
		try {

			String sql = "select * from ordersDetails where orderNumber=?";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				od = new OrdersDetails();
				
				String productCode = rs.getString("productCode");
				DAOProductImpl daoProductImpl = new DAOProductImpl();
				product = daoProductImpl.getProductByCode(productCode);
				
				od.setProduct(product);
				od.setQuantityOrdered(rs.getInt("quantityOrdered"));
				od.setPriceEach(rs.getDouble("priceEach"));
				od.setOrderLineNumber(rs.getInt("orderLineNumber"));
				
				ordersDetails.add(od);
				
			}

			ConexionBD.close();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return ordersDetails;
	}

}
