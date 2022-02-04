package org.iesalixar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/company/")
public class CompanyController {
	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("contenido","INICIO");
		return "index";
	}
	
	@GetMapping("/servicios")
	public String servicios(
			@RequestParam(name="domicilio", required = false, defaultValue="A domicilio: 1€") String domicilio,
			@RequestParam(name="recoger", required = false, defaultValue="Recoger en local") String recoger,
			@RequestParam(name="reserva", required = false, defaultValue="Reserva") String reserva
			, Model model) {
		
		model.addAttribute("contenido","SERVICIOS");
		model.addAttribute("domicilio", domicilio);
		model.addAttribute("recoger",recoger);
		model.addAttribute("reserva",reserva);
		
		return "servicios";
	}
	
	@GetMapping("/productos")
	public String productos(
			@RequestParam(name="product", required = false, defaultValue="Café") String product,
			@RequestParam(name="brand", required = false, defaultValue="L'or") String brand,
			@RequestParam(name="category", required = false, defaultValue="Colombia") String category
			, Model model) {
		
		model.addAttribute("contenido","PRODUCTOS");
		model.addAttribute("product",product);
		model.addAttribute("brand",brand);
		model.addAttribute("category",category);
		
		return "productos";
	}
	
	@GetMapping("/about")
	public String about(Model model) {
		model.addAttribute("contenido","SOBRE NOSOTROS");
		return "about";
	}
}
