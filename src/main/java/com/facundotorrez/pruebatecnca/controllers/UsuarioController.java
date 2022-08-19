package com.facundotorrez.pruebatecnca.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.facundotorrez.pruebatecnca.models.Usuario;
import com.facundotorrez.pruebatecnca.services.PerfilService;
import com.facundotorrez.pruebatecnca.services.UsuarioService;




@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	@Autowired 
	private UsuarioService usuarioService;
	
	@Autowired 
	private PerfilService perfilService;
	
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("usuario",new Usuario());
		model.addAttribute("perfiles", perfilService.listar());
		
		return "/usuario/agregarUsuario";
	}
	
	@PostMapping("/save")
	public String guardar(@Validated @ModelAttribute("usuario") Usuario u, Model model) {
		u.setEnable(true);
		
		usuarioService.saveOrUpdate(u);
		return "redirect:/";
	}
	@GetMapping("/cancelAction")
	public String cancelarAccion() {
		return "redirect:/login";
	}
	


}
