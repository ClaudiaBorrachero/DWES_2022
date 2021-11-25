package org.alixar.servidor.cnbm.dao;

import java.util.List;

import org.alixar.servidor.cnbm.model.Usuarios;

public interface DAOUsuarios {

	public List<Usuarios> getAllUsuarios();
	public Usuarios getUsuarios(String nombre, String email);
	public boolean removeUsuarios(String nombre, String email);
	public boolean updateUsuarios(Usuarios users);
	public boolean addUsuarios(Usuarios users);
	
}
