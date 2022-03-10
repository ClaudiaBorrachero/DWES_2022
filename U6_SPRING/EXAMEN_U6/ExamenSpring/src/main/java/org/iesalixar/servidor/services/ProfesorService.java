package org.iesalixar.servidor.services;

import java.util.List;

import java.util.Optional;

import org.iesalixar.servidor.model.Asignatura;
import org.iesalixar.servidor.model.Profesor;

public interface ProfesorService {

	public List<Profesor> getAllProfesores();
	public Profesor findProfesorById(Long id);
	public Profesor getProfesorByName(String nombre);
	public Profesor insertarProfesor(Profesor profesor);
	public Profesor actualizarProfesor(Profesor profesor);
	
}
