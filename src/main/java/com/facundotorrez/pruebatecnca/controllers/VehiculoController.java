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
import com.facundotorrez.pruebatecnca.interfaceServices.IMarcaService;
import com.facundotorrez.pruebatecnca.interfaceServices.IModeloService;
import com.facundotorrez.pruebatecnca.interfaceServices.IVehiculoService;
import com.facundotorrez.pruebatecnca.models.Dueño;
import com.facundotorrez.pruebatecnca.models.Inspector;
import com.facundotorrez.pruebatecnca.models.Vehiculo;

@RequestMapping("/vehiculos")
@Controller
public class VehiculoController {
	@Autowired
	private IVehiculoService vehiculoService;
	@Autowired
	private IDueñoService dueñoService;
	@Autowired 
	private IMarcaService marcaService;
	
	@Autowired
	private IModeloService modeloService;
	
	@GetMapping("/lista")
	public ResponseEntity<?> traerVehiculos(){
		List<Vehiculo> listaVehiculos = vehiculoService.listar();
		return new ResponseEntity<List<Vehiculo>>(listaVehiculos, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> traerVehiculoId(@PathVariable(name="id") int id){		
		java.util.Optional<Vehiculo> vehiculoBuscado = vehiculoService.listarId(id);
		if(vehiculoBuscado.isEmpty()) {
			return new ResponseEntity<String>("El vehiculo buscado no existe", HttpStatus.NOT_FOUND);
		} else return new ResponseEntity<Vehiculo>(vehiculoBuscado.get(), HttpStatus.FOUND);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminarUsuario(@PathVariable("id")int id) throws Exception{
			vehiculoService.delete(id);
			return new ResponseEntity<String>("El vehiculo con id="+id+" fue eliminado", HttpStatus.OK);
	}
	@PostMapping("/agregar")
	public ResponseEntity<?> nuevoVehiculo(@RequestBody Vehiculo vehiculo) throws Exception{
		java.util.Optional<Vehiculo> v = vehiculoService.listarDominio(vehiculo.getDominio());
		if(v.isEmpty()) {
			return new ResponseEntity<Vehiculo>(vehiculoService.saveOrUpdate(vehiculo), HttpStatus.CREATED);
		}else {
			return new ResponseEntity<String>("El vehiculo ingresado ya exite", HttpStatus.OK);
		}
		
		
	}
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<?> actualizarUsuario(@RequestBody Vehiculo vehiculo, @PathVariable(name = "id") int id) throws Exception{
	
		java.util.Optional<Vehiculo> v =vehiculoService.listarId(id);
		if(v.isEmpty()) {
			return new ResponseEntity<String>("Este vehiculo no existe", HttpStatus.BAD_REQUEST);
		}else {
			vehiculo.setIdVehiculo(id);
			return new ResponseEntity<Vehiculo>(vehiculoService.saveOrUpdate(vehiculo), HttpStatus.OK);
		}
	}
	
	////////////////////////////////////////////////////
	@PostMapping("/save")
	public String guardar(@Validated @ModelAttribute("vehiculo") Vehiculo vehiculo,
			@Validated @ModelAttribute("conductor") Dueño dueño, Model model) {
		
		try {
			System.out.println("vehicuo modificado"+vehiculo);
			Optional<Dueño> dueñoBuscado = dueñoService.listarDNI(dueño.getDni());
			vehiculo.setDuenio(dueñoBuscado.get());
			vehiculoService.saveOrUpdate(vehiculo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			model.addAttribute("errorMsg",e.getMessage());
			return "vehiculo/agregarVehiculo";
		}
		return "redirect:/";
	}
	
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("conductor",new Dueño());
		model.addAttribute("vehiculo",new Vehiculo());

		model.addAttribute("conductores", dueñoService.listar());
		model.addAttribute("marcas", marcaService.listar());
		model.addAttribute("modelos", modeloService.listar());
		return "vehiculo/agregarVehiculo";
	}
	@GetMapping("/edit/{idVehiculo}")
	public String editar(@PathVariable int idVehiculo, Model model) {
		Optional<Vehiculo> vehiculo = vehiculoService.listarId(idVehiculo);
		model.addAttribute("vehiculo", vehiculo.get());
		model.addAttribute("vehiculos", vehiculoService.listar());
		model.addAttribute("editMode", true);
		model.addAttribute("conductor",new Dueño());
		model.addAttribute("conductores", dueñoService.listar());

		
		return "vehiculo/agregarVehiculo";
	}

	@GetMapping("/delete/{idVehiculo}")
	public String delete(Model model, @PathVariable int idVehiculo) throws Exception {
		vehiculoService.delete(idVehiculo);
		return "redirect:/";
	}

}