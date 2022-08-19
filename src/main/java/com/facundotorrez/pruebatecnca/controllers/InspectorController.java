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

import com.facundotorrez.pruebatecnca.interfaceServices.IInspectorService;
import com.facundotorrez.pruebatecnca.models.Dueño;
import com.facundotorrez.pruebatecnca.models.Inspector;
import com.facundotorrez.pruebatecnca.models.Vehiculo;
import com.facundotorrez.pruebatecnca.repositories.IInspectorRepository;

@RequestMapping("/inspectores")
@Controller
public class InspectorController {
	@Autowired
	private IInspectorService inspectorService;
	
	@GetMapping("/lista")
	public ResponseEntity<?> traerInspectore(){
		List<Inspector> inspectores= inspectorService.listar();
		return new ResponseEntity<List<Inspector>>(inspectores,HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> traerInspectorId(@PathVariable(name="id") int id){		
		java.util.Optional<Inspector> inspectorBuscado = inspectorService.traerId(id);
		if(inspectorBuscado.isEmpty()) {
			return new ResponseEntity<String>("El inspector buscado no existe", HttpStatus.NOT_FOUND);
		} else return new ResponseEntity<Inspector>(inspectorBuscado.get(), HttpStatus.FOUND);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminarInspector(@PathVariable("id")int id) throws Exception{
			inspectorService.delete(id);
			return new ResponseEntity<String>("El inspector con id="+id+" fue eliminado", HttpStatus.OK);
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<?> nuevoInspector(@RequestBody Inspector inspectorNuevo) throws Exception{
		java.util.Optional<Inspector> i = inspectorService.listarDNI(inspectorNuevo.getDni());
		if(i.isEmpty()) {
			return new ResponseEntity<Inspector>(inspectorService.saveOrUpdate(inspectorNuevo), HttpStatus.CREATED);
		}else {
			
			return new ResponseEntity<String>("El inspector ingresado ya exite", HttpStatus.OK);
		}	
	}
	
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<?> actualizarInspector(@RequestBody Inspector inspectorModificado, @PathVariable(name = "id") int id) throws Exception{
	
		java.util.Optional<Inspector> i =inspectorService.traerId(id);
		if(i.isEmpty()) {
			return new ResponseEntity<String>("Este inspector no existe", HttpStatus.BAD_REQUEST);
		}else {
			inspectorModificado.setIdInspector(id);
			return new ResponseEntity<Inspector>(inspectorService.saveOrUpdate(inspectorModificado), HttpStatus.OK);
		}
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@PostMapping("/save")
	public String guardar(@Validated @ModelAttribute("inspector") Inspector p, Model model) {
		
		try {
			inspectorService.saveOrUpdate(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			model.addAttribute("errorMsg",e.getMessage());
			return "persona/agregarPersona";
		}
		return "redirect:/";
	}
	
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("inspector",new Inspector());
		return "persona/agregarPersona";
	}
	
	@GetMapping("/edit/{idInspector}")
	public String editar(@PathVariable int idInspector, Model model) {
		Optional<Inspector> inspector = inspectorService.traerId(idInspector);
		
		model.addAttribute("inspector", inspector.get());
		model.addAttribute("inspectores", inspectorService.listar());
		model.addAttribute("editMode", true);

		
		return "persona/agregarPersona";
	}

	@GetMapping("/delete/{idInspector}")
	public String delete(Model model, @PathVariable int idInspector) throws Exception {
		inspectorService.delete(idInspector);
		return "redirect:/";
	}

}
