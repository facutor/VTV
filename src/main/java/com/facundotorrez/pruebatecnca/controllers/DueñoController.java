package com.facundotorrez.pruebatecnca.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.facundotorrez.pruebatecnca.interfaceServices.IDueñoService;
import com.facundotorrez.pruebatecnca.models.Dueño;
import com.facundotorrez.pruebatecnca.models.Inspector;
import com.facundotorrez.pruebatecnca.models.Dueño.TipoDueño;

@RequestMapping("/conductores")
@Controller
public class DueñoController {
	@Autowired
	private IDueñoService dueñoService;
	
	@GetMapping("/lista")
	public ResponseEntity<?> traerDueños(){
		List<Dueño> lDueños= dueñoService.listar();
		return new ResponseEntity<List<Dueño>>(lDueños,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> traerDueñoId(@PathVariable(name="id") int id){		
		java.util.Optional<Dueño> dueñoBuscado = dueñoService.traerId(id);
		if(dueñoBuscado.isEmpty()) {
			return new ResponseEntity<String>("El dueño buscado no existe", HttpStatus.NOT_FOUND);
		} else return new ResponseEntity<Dueño>(dueñoBuscado.get(), HttpStatus.FOUND);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminarUsuario(@PathVariable("id")int id) throws Exception{
			dueñoService.delete(id);
			return new ResponseEntity<String>("El usuario con id="+id+" fue eliminado", HttpStatus.OK);
	}
	
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<?> actualizarUsuario(@RequestBody Dueño dueñoModificado, @PathVariable(name = "id") int id) throws Exception{
	
		java.util.Optional<Dueño> d =dueñoService.traerId(id);
		if(d.isEmpty()) {
			return new ResponseEntity<String>("Este usuario no existe", HttpStatus.BAD_REQUEST);
		}else {
			dueñoModificado.setIdPersona(id);
			return new ResponseEntity<Dueño>(dueñoService.saveOrUpdate(dueñoModificado), HttpStatus.OK);
		}
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<?> nuevoDueño(@RequestBody Dueño dueñoNuevo) throws Exception{
		java.util.Optional<Dueño> d = dueñoService.listarDNI(dueñoNuevo.getDni());
		if(d.isEmpty()) {
			return new ResponseEntity<Dueño>(dueñoService.saveOrUpdate(dueñoNuevo), HttpStatus.CREATED);
		}else {
			
			return new ResponseEntity<String>("El dueño ingresado ya exite", HttpStatus.OK);
		}
		
		
	}



	/************************************************ */

	@PostMapping("/save")
	public String guardar(@Validated @ModelAttribute("conductor") Dueño d, Model model) {
		
		try {
			System.out.println(d);
			dueñoService.saveOrUpdate(d);
		} catch (Exception e) {
			model.addAttribute("errorMsg",e.getMessage());
			return "conductor/agregarConductor";
		}
		return "redirect:/";
	}
	
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("conductor",new Dueño());
		model.addAttribute("tipos", TipoDueño.values());
		return "conductor/agregarConductor";
	}
	
	

	
	
	


}
