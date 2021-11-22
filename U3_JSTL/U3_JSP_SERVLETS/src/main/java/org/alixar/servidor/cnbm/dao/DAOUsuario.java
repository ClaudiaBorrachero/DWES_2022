package org.alixar.servidor.cnbm.dao;

import org.alixar.servidor.cnbm.model.Usuario;

public interface DAOUsuario {

	public Usuario getUsuario(String nombre);
	public boolean registerUsuario(Usuario usuario);
	public boolean updatePassword(Usuario usuario);
	
}
