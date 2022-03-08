package org.iesalixar.servidor.services;

import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.model.Asignatura;
import org.iesalixar.servidor.model.Grado;

public interface GradoService {
	
	public List<Grado> getAllGrados();
	public Grado getGradoByName(String nombre);
	public Grado insertarGrado(Grado grado);
	public Grado actualizarGrado(Grado grado);
	public Grado findGradoById(Long id);
//	public Asignatura getAsignaturaByName(String nombre);
//	public Grado insertarAsignatura(Asignatura asignatura);
	
}
