package org.alixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.alixar.servidor.db.PoolDB;
import org.alixar.servidor.model.Customers;
import org.alixar.servidor.model.Usuarios;

public class DAOUsuariosImpl implements DAOUsuarios{

	@Override
	public Usuarios getUsuario(String nombre) {
	
		Usuarios usuario = null;
		Connection con = null;
		
		try {
			
			String sql = "select * from usuarios where usuario=?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setString(1, nombre);
			
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {

				usuario = new Usuarios();

				usuario.setUsuario(rs.getString("usuario"));
				usuario.setPassword(rs.getString("password"));
				usuario.setEmail(rs.getString("email"));
				usuario.setRole(rs.getString("role"));
				usuario.setFirstName(rs.getString("firstName"));
				usuario.setLastName(rs.getString("lastName"));
				
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

		return usuario;
		
	}

	@Override
	public boolean registerUsuario(Usuarios usuario) {
		
		int resultado=0;
		Connection con = null;
		
		try {

			String sql = "insert into usuarios values(?,?,?,?,?,?)";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setString(1, usuario.getUsuario());
			statement.setString(2, usuario.getPassword());
			statement.setString(3,usuario.getEmail());
			statement.setString(4, usuario.getRole());
			statement.setString(5, usuario.getFirstName());
			statement.setString(6, usuario.getLastName());

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
	public boolean updatePassword(Usuarios usuario) {
		
		int resultado=0;
		Connection con = null;
		
		try {

			String sql = "update usuarios set password= ? where usuario= ?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setString(1, usuario.getPassword());
			statement.setString(2, usuario.getUsuario());
			
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
	public ArrayList<Usuarios> getAllUsuarios() {
		
		ArrayList<Usuarios> usuariosList = new ArrayList<>();
		Connection con = null;

		try {

			String sql = "select * from usuarios";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				Usuarios usuario = new Usuarios();

				usuario.setUsuario(rs.getString("usuario"));
				usuario.setPassword(rs.getString("password"));
				usuario.setEmail(rs.getString("email"));
				usuario.setRole(rs.getString("role"));
				usuario.setFirstName(rs.getString("firstName"));
				usuario.setLastName(rs.getString("lastName"));
				
				usuariosList.add(usuario);
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

		return usuariosList;

		
	}

}
