package org.iesalixar.servidor.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="grado")
public class Grado implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	
	@Column(nullable=false)
	private String nombre;
	
	@OneToMany(mappedBy="grado", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Asignatura> asignaturas = new HashSet<>();
	
	public Grado() {
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

	public Set<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(Set<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}
	
	//HELPERS
	public void addAsignatura(Asignatura asignatura)  {
		this.asignaturas.add(asignatura);
		asignatura.setGrado(this);
	}
	
	public void removeAsignatura(Asignatura asignatura) {
		this.asignaturas.remove(asignatura);
		asignatura.setGrado(null);
	}
	
}
