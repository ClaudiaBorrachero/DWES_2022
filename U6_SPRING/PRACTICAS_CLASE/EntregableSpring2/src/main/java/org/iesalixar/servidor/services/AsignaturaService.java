package org.iesalixar.servidor.services;

import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.model.Asignatura;
import org.iesalixar.servidor.model.Grado;

public interface AsignaturaService {
	
	public List<Asignatura> getAllAsignaturas();
	public Optional<Asignatura> findAsignaturaById(Long id);
	public Asignatura getAsignaturaByName(String nombre);
	public Asignatura insertarAsignatura(Asignatura asignatura);
	public Optional<Asignatura> findAsignaturaByGrado(Long id);
	public Asignatura actualizarAsignatura(Asignatura asignatura);

}
