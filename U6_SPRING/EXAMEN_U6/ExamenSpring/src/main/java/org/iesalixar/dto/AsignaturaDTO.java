package org.iesalixar.dto;

import java.io.Serializable;

public class AsignaturaDTO implements Serializable {

	private Long profesorId;
	private Long asignaturaId;

	public AsignaturaDTO() {
		// TODO Auto-generated constructor stub
	}

	public Long getProfesorId() {
		return profesorId;
	}

	public void setProfesorId(Long profesorId) {
		this.profesorId = profesorId;
	}

	public Long getAsignaturaId() {
		return asignaturaId;
	}

	public void setAsignaturaId(Long asignaturaId) {
		this.asignaturaId = asignaturaId;
	}

}
