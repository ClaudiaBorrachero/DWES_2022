package org.alixar.servidor.dao;

import org.alixar.servidor.model.Usuario;

public interface DAOUsuario {

	public Usuario getUsuario(String nombre);
	public Usuario getUsuarioEmail(String email);
	public boolean registerUsuario(Usuario usuario);
	public boolean updatePassword(Usuario usuario);
	
}
