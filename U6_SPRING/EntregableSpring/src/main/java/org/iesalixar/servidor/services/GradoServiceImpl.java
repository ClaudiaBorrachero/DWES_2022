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
public class GradoServiceImpl implements GradoService {

	@Autowired
	GradoRepository gradoRepo;
	
	@Autowired
	AsignaturaRepository asignaturaRepo;

	@Override
	public List<Grado> getAllGrados() {		
		
		List<Grado> gradosBD = gradoRepo.findAll();		
		
		if (gradosBD!= null && gradosBD.size()> 0) {
			
			return gradosBD;
		}
		
		return new ArrayList<Grado>(); 
		
	}
	
	@Override
	public Grado getGradoByName(String nombre) {
		
		if (nombre!=null) {
			
			Grado grado = gradoRepo.findByNombre(nombre);
			
			return grado; 			
		}
		
		return null;
	}

	@Override
	public Grado insertarGrado(Grado grado) {
		
		if (grado!=null && getGradoByName(grado.getNombre())==null) {
			Grado gradito = gradoRepo.save(grado);
			return gradito;
		}
		
		return null;
	}

	@Override
	public Optional<Grado> findGradoById(Long id) {
		Optional<Grado> grado = null;
		
		if (id!=null) {
			grado = gradoRepo.findById(id);
		}
		
		return grado;
	}

	
}
