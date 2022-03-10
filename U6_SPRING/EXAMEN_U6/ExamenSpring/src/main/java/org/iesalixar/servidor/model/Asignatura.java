package org.iesalixar.servidor.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="asignatura")
public class Asignatura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String nombre;
	
	@Column(nullable=false)
	private Double creditos;
	
	@Column(nullable=false)
	private String tipo;
	
	@Column(nullable=false)
	private Integer curso;
	
	@Column(nullable=false)
	private Integer cuatrimestre;
	
//	@ManyToOne
//	@JoinColumn(name="id_grado")
//	private Grado grado;
	
	@ManyToOne
	@JoinColumn(name="id_profesor")
	private Profesor profesor;
	
	public Asignatura() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getCreditos() {
		return creditos;
	}

	public void setCreditos(Double creditos) {
		this.creditos = creditos;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getCurso() {
		return curso;
	}

	public void setCurso(Integer curso) {
		this.curso = curso;
	}

	public Integer getCuatrimestre() {
		return cuatrimestre;
	}

	public void setCuatrimestre(Integer cuatrimestre) {
		this.cuatrimestre = cuatrimestre;
	}	

//	public Grado getGrado() {
//		return grado;
//	}
//
//	public void setGrado(Grado grado) {
//		this.grado = grado;
//	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(creditos, cuatrimestre, curso, id, nombre, profesor, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Asignatura other = (Asignatura) obj;
		return Objects.equals(creditos, other.creditos) && Objects.equals(cuatrimestre, other.cuatrimestre)
				&& Objects.equals(curso, other.curso) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(profesor, other.profesor)
				&& Objects.equals(tipo, other.tipo);
	}

	@Override
	public String toString() {
		return "Asignatura [id=" + id + ", nombre=" + nombre + ", creditos=" + creditos + ", tipo=" + tipo + ", curso="
				+ curso + ", cuatrimestre=" + cuatrimestre + ", profesor=" + profesor + "]";
	}

	
	
	
}
