package org.iesalixar.servidor.services;

import java.util.ArrayList;
import java.util.List;

import org.iesalixar.servidor.model.Departamento;
import org.iesalixar.servidor.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

	@Autowired
	DepartamentoRepository departamentoRepo;

	@Override
	public List<Departamento> getAllDepartments() {		
		
		List<Departamento> deptsBD = departamentoRepo.findAll();		
		
		if (deptsBD!= null && deptsBD.size()> 0) {
			
			return deptsBD;
		}
		
		return new ArrayList<Departamento>(); 
		
	}

	@Override
	public Departamento getDepartamentByName(String nombre) {
		
		if (nombre!=null) {
		
			Departamento dpto = departamentoRepo.findByNombre(nombre);
			
			return dpto; 			
		}
		
		return null;
	}

	@Override
	public Departamento insertarDepartamento(Departamento departamento) {
		
		if (departamento!=null && getDepartamentByName(departamento.getNombre())==null) {
			Departamento dpto = departamentoRepo.save(departamento);
			return dpto;
		}
		
		return null;
	}

	@Override
	public Departamento actualizarDepartamento(Departamento departamento) {
				
		if (departamento==null || departamento.getId() ==null || departamento.getNombre()==null) {
			return null;
		}
		
		return departamentoRepo.save(departamento); 
		
	}

	@Override
	public Departamento findDepartamentoById(Long id) {
		
		return departamentoRepo.findById(id).get();
	}
	
	
}
