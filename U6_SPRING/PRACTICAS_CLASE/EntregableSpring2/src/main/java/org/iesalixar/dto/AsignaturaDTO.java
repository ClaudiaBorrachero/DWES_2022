package org.iesalixar.dto;

import java.io.Serializable;

public class AsignaturaDTO implements Serializable {

	private Long gradoId;
	private Long asignaturaId;
	
	public AsignaturaDTO() {
		// TODO Auto-generated constructor stub
	}

	public Long getGradoId() {
		return gradoId;
	}

	public void setGradoId(Long gradoId) {
		this.gradoId = gradoId;
	}

	public Long getAsignaturaId() {
		return asignaturaId;
	}

	public void setAsignaturaId(Long asignaturaId) {
		this.asignaturaId = asignaturaId;
	}
		
}
