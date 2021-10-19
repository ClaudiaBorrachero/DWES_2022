package org.alixar.servidor.cnbm.model;

import java.io.Serializable;

public class Usuarios implements Serializable {

	private String nombre;

	public Usuarios() {
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
