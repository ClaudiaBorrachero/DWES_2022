package org.alixar.servidor.cnbm.model;

import java.io.Serializable;

public class Usuario implements Serializable{
	private String user;
	private String pass;
	
	public Usuario() {
		
	}
	
	public String getUsuario() {
		return user;
	}

	public void setUsuario(String usuario) {
		this.user = usuario;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public boolean isUsuarioValid() {
		return (user.equals("admin") && pass.equals("admin")) ||
				(user.equals("usuario") && pass.equals("usuario"));
	}

	
}
