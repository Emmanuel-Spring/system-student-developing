package com.talentyco.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
	
	
	/** Mapeo a la Página de inicio principal index.html
	 */
	@GetMapping({"/", "", " ", "index", "home"})
	public String home(Model modelo) {
		
		modelo.addAttribute("title", "UsuarioApp");
		modelo.addAttribute("titulo", "Bienvenidos a UsuarioApp");
		
		
		return "index";
	}

}
