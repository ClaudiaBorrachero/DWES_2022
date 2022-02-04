package org.iesalixar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.Matricula;
import com.example.demo.dto.Usuario;

@Controller
@RequestMapping("/forms")
public class FormControler {
	
	
	@GetMapping("/registro")
	public String registro(Model model) {
		
		Usuario usuario = new Usuario();		
		model.addAttribute("usuario", usuario);
		return "forms/registro";
		
	}
	
	@PostMapping("/registro")
	public String registroPost(@ModelAttribute Usuario usuario, Model model) {
		model.addAttribute("usuario", usuario);
		return "forms/registro";		
	}
	
	@GetMapping("/matricula")
	public String matricula(Model model) {
		
		Matricula matricula = new Matricula();		
		model.addAttribute("matricula", matricula);
		return "forms/matricula";
		
	}
	
	@PostMapping("/matricula")
	public String matriculaPost(@ModelAttribute Matricula matricula, Model model) {
		model.addAttribute("matricula", matricula);
		return "forms/matricula";		
	}
	

}
