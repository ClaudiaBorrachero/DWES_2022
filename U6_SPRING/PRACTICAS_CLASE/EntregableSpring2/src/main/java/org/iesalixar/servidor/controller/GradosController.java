package org.iesalixar.servidor.controller;

import java.util.List;
import java.util.Optional;

import org.iesalixar.dto.AsignaturaDTO;
import org.iesalixar.dto.GradosDTO;
import org.iesalixar.servidor.model.Asignatura;
import org.iesalixar.servidor.model.Grado;
import org.iesalixar.servidor.services.AsignaturaServiceImpl;
import org.iesalixar.servidor.services.GradoServiceImpl;
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
public class GradosController {
	
	@Autowired
	GradoServiceImpl gradoService;
	
	@Autowired
	AsignaturaServiceImpl asignaturaService;
	
	@Autowired
	ProfesorServiceImpl profesorService;
	
	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("contenido","INICIO");
		return "index";
	}
		
	@RequestMapping("/grados")
	public String grados(Model model) {
		
		List<Grado> grados = gradoService.getAllGrados();
		
		model.addAttribute("contenido","GRADOS");
		model.addAttribute("grados",grados);
		return "grados";
	}
	
	@GetMapping("/grados/asignaturas")
	public String asignaturasGrado(@RequestParam(required=false,name="codigo") String codigo,Model model) {
		
		Grado gradoEntity = gradoService.findGradoById(Long.parseLong(codigo));
		
		if (codigo==null || gradoEntity==null) {
			return "redirect:/grados/";
		}
		
		model.addAttribute("grado",gradoEntity);
					
		return "gradosAsignatura";
	}
		
	@GetMapping("/grados/addGrado")
	public String addGradoGet(@RequestParam(required=false,name="error") String error,
			@RequestParam(required=false,name="grado") String nombre,
			Model model) {
		
		GradosDTO grado = new GradosDTO();
		
		model.addAttribute("gradito", grado);
		model.addAttribute("error", error);
		model.addAttribute("previo", nombre);
		return "addGrado";
	}
	
	
	@PostMapping("/grados/addGrado")
	public String addGradoPost(@ModelAttribute GradosDTO gradoDTO, Model model) {
		
		Grado gradoBD = new Grado();
		gradoBD.setNombre(gradoDTO.getNombre());
		
		if (gradoService.insertarGrado(gradoBD)==null) {
			return "redirect:/grados/addGrado?error=Existe&grado="+gradoDTO.getNombre();
		}
		
		return "redirect:/grados/";
	}
	
	
	//ESTO NO FUNCIONA
	
	@GetMapping("/grados/addasignatura")
	public String addAsignaturaGet(@RequestParam(required=false,name="error") String error,
			@RequestParam(required=false,name="asignatura") String nombre,
			Model model) {
		
		AsignaturaDTO asignaturaDB = new AsignaturaDTO();
		List<Asignatura> asignaturas = asignaturaService.getAllAsignaturas();
		List<Grado> grados = gradoService.getAllGrados();
		
		model.addAttribute("grados",grados);
		model.addAttribute("asignaturas", asignaturas);
		
		model.addAttribute("asignatura", asignaturaDB);
		model.addAttribute("error", error);
		model.addAttribute("previo", nombre);
		
		return "addAsignatura";
	}
	
	
	@PostMapping("/grados/addasignatura")
	public String addAsignaturaPost(@ModelAttribute AsignaturaDTO asignaturaDTO, Model model) {
		
		Grado grados = gradoService.findGradoById(asignaturaDTO.getGradoId());
		Optional<Asignatura> asignaturas = asignaturaService.findAsignaturaById(asignaturaDTO.getAsignaturaId());
		
		Asignatura asignatura = asignaturas.get();
		asignatura.setGrado(grados);
		
		if (asignaturaService.actualizarAsignatura(asignatura) == null) {
			return "redirect:/grados/addasignatura?error=Existe&grado="+asignaturaDTO.getAsignaturaId();
		}		
				
		return "redirect:/grados/asignaturas?codigo="+asignaturaDTO.getGradoId();
	}
	
	
	//DESVINCULAR ASIGNATURA DE GRADO
	
	@GetMapping("/grados/asignaturas/delete")
	public String borrarAsignaturaGrado(@RequestParam(required=false,name="codigo") String codigo, Model model) {
		
		Asignatura asignEntity = asignaturaService.findAsignaturaById(Long.parseLong(codigo)).get();
		Long gradoId = asignEntity.getGrado().getId();
		
		asignEntity.setGrado(null);
		
		asignaturaService.actualizarAsignatura(asignEntity);
		
		return "redirect:/grados/asignaturas?codigo="+gradoId;
		
	}
	

}
