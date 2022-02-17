package org.iesalixar.servidor.controller;

import java.util.Optional;

import org.iesalixar.servidor.model.Profesor;
import org.iesalixar.servidor.services.ProfesorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/profesor")
public class ProfesorController {

	@Autowired
	ProfesorServiceImpl profesorService;
	
	@GetMapping("/") 
	public String asignaturas(Model model) {
		
		model.addAttribute("profesor", profesorService.getAllProfesores());
		
		return "profesor";
	}
	
	
	@GetMapping("/asignaturas")
	public String asignaturasAlumnos(@RequestParam(required=false,name="codigo") String codigo,Model model) {
		
		//Obtengo el parámetro de la URL (en caso de no esta vuelvo a la lista de asignaturas
		if (codigo==null) {
			return "redirect:/profesor";
		}
		
		Optional<Profesor> profesor = profesorService.findProfesorById(Long.parseLong(codigo));
		model.addAttribute("profesor",profesor.get());				
		return "asignaturasProfesor";
	}
	
}
