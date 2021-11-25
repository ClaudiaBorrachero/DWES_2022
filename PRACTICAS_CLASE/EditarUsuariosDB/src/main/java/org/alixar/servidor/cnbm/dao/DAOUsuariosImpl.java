package org.alixar.servidor.cnbm.dao;

import java.sql.PreparedStatement;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.alixar.servidor.cnbm.db.ConexionBD;
import org.alixar.servidor.cnbm.model.Usuarios;

public class DAOUsuariosImpl implements DAOUsuarios{

	@Override
	public List<Usuarios> getAllUsuarios() {
		ArrayList<Usuarios> listaUsuarios = new ArrayList<>();
		Usuarios usuario;
		
		try {
			String sql = "select * from usuario";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				Usuarios users = new Usuarios();
				
				users.setNombre(rs.getString("nombre"));
				users.setEmail(rs.getString("email"));
				users.setRol(rs.getString("rol"));
				users.setPassword(rs.getString("password"));
				
				listaUsuarios.add(users);

			}

			ConexionBD.close();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return listaUsuarios;
		
	}

	@Override
	public Usuarios getUsuarios(String nombre, String email) {
		
		Usuarios users = null;
		
		try {

			String sql = "select * from usuario where nombre=? and email=?";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			statement.setString(1, nombre);
			statement.setString(2, email);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				users = new Usuarios();

				users.setNombre(rs.getString("nombre"));
				users.setEmail(rs.getString("email"));
				users.setRol(rs.getString("rol"));
				users.setPassword(rs.getString("password"));

			}

			ConexionBD.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return users;
		
	}

	@Override
	public boolean removeUsuarios(String nombre, String email) {
		
		int resultado = 0;
		
		try {

			String sql = "delete from usuario where nombre=? and email=?";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			statement.setString(1, nombre);
			statement.setString(2, email);

			resultado = statement.executeUpdate();
			
			ConexionBD.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return (resultado==0?false:true);
		
	}

	@Override
	public boolean updateUsuarios(Usuarios users) {
		
		int resultado = 0;
		
		try {

			String sql = "update usuario set nombre=?, email=?, rol=?, password=?";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			statement.setString(1, users.getNombre());
			statement.setString(2, users.getEmail());
			statement.setString(3, users.getRol());
			statement.setString(4, users.getPassword());

			resultado = statement.executeUpdate();
			
			ConexionBD.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return (resultado==0?false:true);
		
	}

	@Override
	public boolean addUsuarios(Usuarios users) {
		
		int resultado = 0;
		
		try {

			String sql = "insert into usuario values(?,?,?,?)";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			statement.setString(1, users.getNombre());
			statement.setString(2, users.getEmail());
			statement.setString(3, users.getRol());
			statement.setString(4, users.getPassword());

			resultado = statement.executeUpdate();
			
			ConexionBD.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return (resultado==0?false:true);
		
	}

}
