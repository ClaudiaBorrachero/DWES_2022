package org.alixar.servidor.cnbm.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.alixar.servidor.cnbm.db.ConexionBD;
import org.alixar.servidor.cnbm.model.Products;

public class DAOProductLineImpl implements DAOProductLine{

	@Override
	public List<Products> getAllProducts() {
		ArrayList<Products> productsList = new ArrayList<>();
		Products product;
		
		try {
			String sql = "select * from productlines";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				Products productLine = new Products();

				productLine.setProductLine(rs.getString("productline"));
				productLine.setHtmlDescription(rs.getString("textDescription"));
				productLine.setTextDescription(rs.getString("htmlDescription"));				

				productsList.add(productLine);

			}

			ConexionBD.close();
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return productsList;
	}

	@Override
	public Products getProducts(String productLine) {
		
		Products product = null;
		
		try {

			String sql = "select * from productlines where productLine= ?";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			statement.setString(1, productLine);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				product = new Products();

				product.setProductLine(rs.getString("productline"));
				product.setHtmlDescription(rs.getString("textDescription"));
				product.setTextDescription(rs.getString("htmlDescription"));				

			}

			ConexionBD.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return product;
	}

	@Override
	public boolean removeProducts(String productLine) {
		
		int resultado = 0;
		
		try {

			String sql = "delete from productlines where productLine=?";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			statement.setString(1, productLine);

			resultado = statement.executeUpdate();

			ConexionBD.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return (resultado==0?false:true);
		
	}

	@Override
	public boolean updateProducts(Products productLine) {
		
	  int resultado = 0;

        try {

            String sql = "update productlines set textDescription= ?, htmlDescription=? where productLine = ?";
            PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
            statement.setString(1, productLine.getTextDescription());
            statement.setString(2, productLine.getHtmlDescription());
            statement.setString(3, productLine.getProductLine());

            resultado = statement.executeUpdate();

            ConexionBD.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return (resultado == 0 ? false : true);
		
	}

	@Override
	public boolean addProducts(Products productLine) {
		
	    int resultado = 0;

        try {

            String sql = "insert into productlines values (?, ?, ?, null)";
            PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
            statement.setString(1, productLine.getProductLine());
            statement.setString(2, productLine.getTextDescription());
            statement.setString(3, productLine.getHtmlDescription());

            resultado = statement.executeUpdate();

            ConexionBD.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return (resultado == 0 ? false : true);
        
	}

	
	
}
