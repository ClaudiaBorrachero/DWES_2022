package org.iesalixar.servidor.services;

import java.util.ArrayList;

import java.util.List;
import org.iesalixar.servidor.model.Profesor;
import org.iesalixar.servidor.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfesorServiceImpl implements ProfesorService {

	@Autowired
	ProfesorRepository profesorRepo;
	
	@Override
	public List<Profesor> getAllProfesores() {
		List<Profesor> profesorBD = profesorRepo.findAll();


		if (profesorBD != null && profesorBD.size() > 0) {

			return profesorBD;
		}

		return new ArrayList<Profesor>();
	}

	@Override
	public Profesor findProfesorById(Long id) {
		
		return profesorRepo.findById(id).get();
		
	}
	
	@Override
	public Profesor getProfesorByName(String nombre) {
		if (nombre!=null) {
			
			Profesor profesor = profesorRepo.findByNombre(nombre);
			
			return profesor; 			
		}
		
		return null;
	}

	@Override
	public Profesor insertarProfesor(Profesor profesor) {
		if (profesor!=null && getProfesorByName(profesor.getNombre())==null) {
			Profesor profesorsito = profesorRepo.save(profesor);
			return profesorsito;
		}
		return null;
	}

	@Override
	public Profesor actualizarProfesor(Profesor profesor) {
		if (profesor==null || profesor.getId()==null || profesor.getNombre()==null) {
			return null;			
		}
		return profesorRepo.save(profesor);
	}

}
