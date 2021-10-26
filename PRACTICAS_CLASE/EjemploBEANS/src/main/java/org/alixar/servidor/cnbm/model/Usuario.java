package org.alixar.servidor.cnbm.model;

import java.io.Serializable;

public class Usuario implements Serializable{

	private String nombre;
	private String apellidos;
	private String direccion;
	private String[] aficiones;
	private int edad;
	
	public Usuario() {
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String[] getAficiones() {
		return aficiones;
	}

	public void setAficiones(String[] aficiones) {
		this.aficiones = aficiones;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
}
