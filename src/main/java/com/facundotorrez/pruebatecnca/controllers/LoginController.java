package com.facundotorrez.pruebatecnca.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.facundotorrez.pruebatecnca.services.UsuarioService;



@Controller
public class LoginController {
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/login")
	public String login(Model model,
						@RequestParam(name="error",required=false) String error,
						@RequestParam(name="logout", required=false) String logout) {
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		
		return "acceso/login";
	}
	
	@GetMapping("/logout")
	public String logout(Model model) {
		SecurityContextHolder.clearContext();
		return "redirect:/login";
		
	}
	
	@GetMapping("/loginsuccess")
	public String loginCheckGet() {
		return "redirect:/";
	}
	
	
	
	
}
