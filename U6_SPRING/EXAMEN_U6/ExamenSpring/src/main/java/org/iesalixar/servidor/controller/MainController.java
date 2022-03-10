package org.iesalixar.servidor.controller;

import java.util.List;

import java.util.Optional;

import org.iesalixar.dto.AsignaturaDTO;
import org.iesalixar.dto.ProfesorDTO;
import org.iesalixar.servidor.model.Asignatura;
import org.iesalixar.servidor.model.Departamento;
import org.iesalixar.servidor.model.Profesor;
import org.iesalixar.servidor.services.AsignaturaServiceImpl;
import org.iesalixar.servidor.services.DepartamentoServiceImpl;
import org.iesalixar.servidor.services.ProfesorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	@Autowired
	AsignaturaServiceImpl asignaturaService;
	
	@Autowired
	ProfesorServiceImpl profesorService;
	
	@Autowired
	DepartamentoServiceImpl departamentoService;
	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("contenido","INICIO");
		return "index";
	}
		
	@RequestMapping("/profesores")
	public String profesores(Model model) {
		
		List<Profesor> profesores = profesorService.getAllProfesores();
		
		model.addAttribute("contenido","PROFESORES");
		model.addAttribute("profesores",profesores);
		return "profesores";
	}
	
	@GetMapping("/profesores/asignaturas")
	public String asignaturasProfesor(@RequestParam(required=false,name="codigo") String codigo,Model model) {
		
		Profesor profesorEntity = profesorService.findProfesorById(Long.parseLong(codigo));
		
		if (codigo==null || profesorEntity==null) {
			return "redirect:/profesores/";
		}
		
		model.addAttribute("profesor",profesorEntity);
					
		return "asignaturasProfesor";
	}
		
	@GetMapping("/profesores/addProfesor")
	public String addProfesorGet(@RequestParam(required=false,name="error") String error,
			@RequestParam(required=false,name="profesor") String nombre,
			Model model) {
		
		ProfesorDTO profesorDB = new ProfesorDTO();
		List<Departamento> departamentos = departamentoService.getAllDepartments();
		
		model.addAttribute("profesorsito", profesorDB);
		model.addAttribute("departamentos", departamentos);
		model.addAttribute("error", error);
		model.addAttribute("previo", nombre);
		
		return "addProfesor";
	}
	
	//EL PROFESOR SE CREA PERO DA UN ERROR 500
	@PostMapping("/profesores/addProfesor")
	public String addProfesorPost(@ModelAttribute ProfesorDTO profesorDTO, Model model) {
		
		Profesor profesorDB = new Profesor();
		profesorDB.setId(profesorDTO.getId());
		profesorDB.setNombre(profesorDTO.getNombre());
		profesorDB.setApellido1(profesorDTO.getApellido1());
		profesorDB.setApellido2(profesorDTO.getApellido2());
		profesorDB.setNif(profesorDTO.getNif());
		profesorDB.setTelefono(profesorDTO.getTelefono());
		profesorDB.setSexo(profesorDTO.getSexo());
		profesorDB.setCiudad(profesorDTO.getCiudad());
		profesorDB.setDireccion(profesorDTO.getDireccion());
		profesorDB.setFechaNacimiento(profesorDTO.getFecha_nacimiento());
		
		Departamento departamentos = departamentoService.findDepartamentoById(profesorDTO.getDepartamentoId());
				
		profesorDB.setDepartamento(departamentos);
		
		if (profesorService.insertarProfesor(profesorDB)==null) {
			return "redirect:/profesores/addProfesor?error=Existe&profesor="+profesorDTO.getDepartamentoId();
		}
		
		return "redirect:/profesores/asignaturas";
	}
		
	//AÑADE ASIGNATURAS A PROFESORES TANTO NUEVOS COMO YA CREADOS PERFECTAMENTE
	@GetMapping("/profesores/addAsignatura")
	public String addAsignaturaGet(@RequestParam(required=false,name="error") String error,
			@RequestParam(required=false,name="asignatura") String nombre,
			Model model) {
		
		AsignaturaDTO asignaturaDB = new AsignaturaDTO();
		List<Asignatura> asignaturas = asignaturaService.getAllAsignaturas();
		List<Profesor> profesores = profesorService.getAllProfesores();
		
		model.addAttribute("profesores", profesores);
		model.addAttribute("asignaturas", asignaturas);
		
		model.addAttribute("asignatura", asignaturaDB);
		model.addAttribute("error", error);
		model.addAttribute("previo", nombre);
		
		return "addAsignatura";
	}
	
	
	@PostMapping("/profesores/addAsignatura")
	public String addAsignaturaPost(@ModelAttribute AsignaturaDTO asignaturaDTO, Model model) {
		
		Profesor profesores = profesorService.findProfesorById(asignaturaDTO.getProfesorId());
		Optional<Asignatura> asignaturas = asignaturaService.findAsignaturaById(asignaturaDTO.getAsignaturaId());
		
		Asignatura asignatura = asignaturas.get();
		asignatura.setProfesor(profesores);
		
		if (asignaturaService.actualizarAsignatura(asignatura) == null) {
			return "redirect:/profesores/addAsignatura?error=Existe&profesor="+asignaturaDTO.getAsignaturaId();
		}		
				
		return "redirect:/profesores/";
//		return "redirect:/profesores/asignaturas?codigo="+asignaturaDTO.getProfesorId();
	}
	
	
	//DESVINCULAR ASIGNATURA DE GRADO
	
//	@GetMapping("/grados/asignaturas/delete")
//	public String borrarAsignaturaGrado(@RequestParam(required=false,name="codigo") String codigo, Model model) {
//		
//		Asignatura asignEntity = asignaturaService.findAsignaturaById(Long.parseLong(codigo)).get();
//		Long gradoId = asignEntity.getGrado().getId();
//		
//		asignEntity.setGrado(null);
//		
//		asignaturaService.actualizarAsignatura(asignEntity);
//		
//		return "redirect:/grados/asignaturas?codigo="+gradoId;
//		
//	}
	

}
