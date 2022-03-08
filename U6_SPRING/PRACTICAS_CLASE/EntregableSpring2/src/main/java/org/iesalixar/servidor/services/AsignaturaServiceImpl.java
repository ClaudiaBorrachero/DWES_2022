package org.iesalixar.servidor.services;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.model.Asignatura;
import org.iesalixar.servidor.model.Grado;
import org.iesalixar.servidor.repository.AsignaturaRepository;
import org.iesalixar.servidor.repository.GradoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsignaturaServiceImpl implements AsignaturaService {

	@Autowired
	AsignaturaRepository asignaturaRepo;
	
	@Autowired
	GradoRepository gradoRepo;

	@Override
	public List<Asignatura> getAllAsignaturas() {

		List<Asignatura> asignBD = asignaturaRepo.findAll();

		if (asignBD != null && asignBD.size() > 0) {

			return asignBD;
		}

		return new ArrayList<Asignatura>();
	}

	@Override
	public Optional<Asignatura> findAsignaturaById(Long id) {
		
		return asignaturaRepo.findById(id);
		
	}

	@Override
	public Asignatura actualizarAsignatura(Asignatura asignatura) {
		
		if (asignatura==null || asignatura.getId()==null || asignatura.getNombre()==null) {
			return null;			
		}
		return asignaturaRepo.save(asignatura);
	}

	@Override
	public Asignatura getAsignaturaByName(String nombre) {
		if (nombre!=null) {
			
			Asignatura asignatura = asignaturaRepo.findByNombre(nombre);
			
			return asignatura; 			
		}
		
		return null;
	}	
	
	@Override
	public Asignatura insertarAsignatura(Asignatura asignatura) {
		
		if (asignatura!=null && getAsignaturaByName(asignatura.getNombre())==null) {
			Asignatura asign = asignaturaRepo.save(asignatura);
			return asign;
		}
		
		return null;
	}

	@Override
	public Optional<Asignatura> findAsignaturaByGrado(Long id) {
		
		Optional<Asignatura> asignatura = null;
		
		if (id!=null) {
			asignatura = asignaturaRepo.findById(id);
		}
		return asignatura;
	}

}
