package com.facundotorrez.pruebatecnca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.facundotorrez.pruebatecnca.models.Modelo;
import com.facundotorrez.pruebatecnca.models.VehiculoInspector;
import com.facundotorrez.pruebatecnca.services.ModeloService;

@RequestMapping("/modelos")
@Controller
public class ModeloController {
	
	@Autowired
	private ModeloService modeloService;
	

	@GetMapping("/lista/modelo/{idMarca}")
	public ResponseEntity<?>traerModeloIdMarca(@PathVariable(name="idMarca") int idMarca){
		List<Modelo> modeloBuscado = modeloService.listarPorMarca(idMarca);
		if(modeloBuscado.isEmpty()) {
			return new ResponseEntity<String>("la marca buscada no existe", HttpStatus.NOT_FOUND);
		} else return new ResponseEntity<List<Modelo>>(modeloBuscado, HttpStatus.FOUND);
	}
	

}
