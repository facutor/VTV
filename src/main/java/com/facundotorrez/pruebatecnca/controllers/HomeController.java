package com.facundotorrez.pruebatecnca.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.facundotorrez.pruebatecnca.interfaceServices.IDueñoService;
import com.facundotorrez.pruebatecnca.interfaceServices.IInspectorService;
import com.facundotorrez.pruebatecnca.services.VehiculoInspectorService;
import com.facundotorrez.pruebatecnca.services.VehiculoService;

@RequestMapping("/")
@Controller
public class HomeController {
	@Autowired
	VehiculoService vehiculoService;
	@Autowired
	VehiculoInspectorService vIService;
	@Autowired 
	IInspectorService iService;
	@Autowired
	IDueñoService dueñoService;
	
	@GetMapping("")
	public String inicio(Model model) {
		model.addAttribute("vehiculos",vehiculoService.listar());
		model.addAttribute("inspecciones", vIService.list());
		model.addAttribute("inspectores", iService.listar());
		model.addAttribute("duenios", dueñoService.listar());
		return "home.html";
	}

}
