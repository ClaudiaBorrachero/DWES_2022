package org.alixar.servidor.cnbm.model;

public class Usuarios {

	private String nombre;
	private String email;
	private String rol;
	private String password;
	
	public Usuarios() {
		
	}

	public Usuarios(String nombre, String email, String rol, String password) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.rol = rol;
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
