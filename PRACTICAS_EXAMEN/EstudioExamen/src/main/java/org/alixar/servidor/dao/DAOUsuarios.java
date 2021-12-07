package org.alixar.servidor.dao;

import java.util.ArrayList;

import org.alixar.servidor.model.Usuarios;

public interface DAOUsuarios {

	public Usuarios getUsuario(String nombre);
	public boolean registerUsuario(Usuarios usuario);
	public boolean updatePassword(Usuarios usuario);
	public ArrayList<Usuarios> getAllUsuarios();
	
}
