package com.facundotorrez.pruebatecnca.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.facundotorrez.pruebatecnca.interfaceServices.IDueñoService;
import com.facundotorrez.pruebatecnca.interfaceServices.IInspectorService;
import com.facundotorrez.pruebatecnca.interfaceServices.IVehiculoInspectorService;
import com.facundotorrez.pruebatecnca.interfaceServices.IVehiculoService;
import com.facundotorrez.pruebatecnca.models.Dueño;
import com.facundotorrez.pruebatecnca.models.Vehiculo;
import com.facundotorrez.pruebatecnca.models.VehiculoInspector;
import com.facundotorrez.pruebatecnca.models.Dueño.TipoDueño;
import com.facundotorrez.pruebatecnca.models.Inspector;
import com.facundotorrez.pruebatecnca.models.VehiculoInspector.Estado;
import com.facundotorrez.pruebatecnca.services.VehiculoInspectorService;

@Controller
@RequestMapping("/inspecciones")
public class VehiculoInspectorController {
	
	@Autowired
	private IVehiculoInspectorService vhService;
	
	@Autowired
	private IVehiculoService vService;
	
	@Autowired
	private IInspectorService inspectorService;
	
	@Autowired
	private IDueñoService dueñoService;
	
	/*@GetMapping("/lista")
	public ResponseEntity<?> traerInspecciones(){
		List<VehiculoInspector> inspecciones= vhService.list();
		return new ResponseEntity<List<VehiculoInspector>>(inspecciones,HttpStatus.OK);
	}*/
	
	@GetMapping("/lista/dueño/{idDueño}")
	public ResponseEntity<?>traerInspeccionesIdDueño(@PathVariable(name="idDueño") int idDueño){
		List<VehiculoInspector> inspeccionBuscada = vhService.traerInspeccionesPorIdDueño(idDueño);
		if(inspeccionBuscada.isEmpty()) {
			return new ResponseEntity<String>("El dueño buscado no existe", HttpStatus.NOT_FOUND);
		} else return new ResponseEntity<List<VehiculoInspector>>(inspeccionBuscada, HttpStatus.FOUND);
	}
	
	@GetMapping("/lista/estado")
	public ResponseEntity<?>traerInspeccionesEstado(@RequestParam("estado") int estado){
		List<VehiculoInspector> inspeccionBuscada = null;
		if (estado==Estado.APTO.ordinal()) {
			System.out.println("entro");
		   inspeccionBuscada = vhService.traerEstado(Estado.APTO);
		}
		if (estado==Estado.RECHAZADO.ordinal()) {
			System.out.println("entro");
		   inspeccionBuscada = vhService.traerEstado(Estado.RECHAZADO);
		}
		if (estado==Estado.CONDICIONAL.ordinal()) {
			System.out.println("entro");
		   inspeccionBuscada = vhService.traerEstado(Estado.CONDICIONAL);
		}
		
		if(inspeccionBuscada.isEmpty()) {
			return new ResponseEntity<String>("El dueño buscado no existe", HttpStatus.NOT_FOUND);
		} else return new ResponseEntity<List<VehiculoInspector>>(inspeccionBuscada, HttpStatus.FOUND);
		
	}
/////////////////////////////////////////////////////////////

	
	@PostMapping("/save")
	public String guardar(@Validated @ModelAttribute("inspeccion") VehiculoInspector vehiculoInspector,
			@Validated @ModelAttribute("vehiculo") Vehiculo vehiculo, @Validated @ModelAttribute("inspector") Inspector inspector,
			Model model) {
		
		try {
			Optional<Vehiculo> vehiculoBuscado = vService.listarDominio(vehiculo.getDominio());
			Optional<Inspector> inspectorBuscado = inspectorService.listarDNI(inspector.getDni());
			vehiculoInspector.setVehiculo(vehiculoBuscado.get());
			vehiculoInspector.setInspector(inspectorBuscado.get());
			vhService.saveOrUpdate(vehiculoInspector);
			System.out.println("paso el save");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			model.addAttribute("errorMsg",e.getMessage());
			return "inspeccion/agregarInspeccion";
		}
		return "redirect:/";
	}
	
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("inspeccion",new VehiculoInspector());
		model.addAttribute("vehiculo",new Vehiculo());
		model.addAttribute("inspector",new Inspector());

		model.addAttribute("vehiculos", vService.listar());
		model.addAttribute("inspectores", inspectorService.listar());
		model.addAttribute("tipos", Estado.values());
		return "inspeccion/agregarInspeccion";
	}
	@GetMapping("/lista")
	public String filtarPorDueño(Model model) {
		model.addAttribute("duenios", dueñoService.listar());
		model.addAttribute("duenio", new Dueño());
		return "/inspeccion/traerInspecciones";
		
	}
	@PostMapping("/filtrarPorDueño")
	public String traerPorDniDueño(@Validated @ModelAttribute("duenio") Dueño dueño, Model model) throws Exception{
		Optional<Dueño> d= dueñoService.listarDNI(dueño.getDni());
		List<VehiculoInspector> inspecciones = vhService.traerInspeccionesPorIdDueño(d.get().getIdDueño());
		model.addAttribute("inspecciones", inspecciones);
		model.addAttribute("duenios", dueñoService.listar());
		model.addAttribute("duenio", new Dueño());
		return "/inspeccion/traerInspecciones";
	}
	@GetMapping("/estado")
	public String filtarPorEstado(Model model) {
		model.addAttribute("tipos", Estado.values());
		model.addAttribute("inspeccion", new VehiculoInspector());
		return "/inspeccion/traerInspeccionEstado";
		
	}
	@PostMapping("/filtrarPorEstado")
	public String traerPorEstado(@Validated @ModelAttribute("inspeccion")VehiculoInspector vi, Model model) throws Exception{
		List<VehiculoInspector> inspecciones = vhService.traerEstado(vi.getEstado());
		model.addAttribute("inspecciones", inspecciones);
		model.addAttribute("inspeccion", new VehiculoInspector());
		model.addAttribute("tipos", Estado.values());
		return "/inspeccion/traerInspeccionEstado";
	}
	
	@GetMapping("/edit/{idVehiculoInspector}")
	public String editar(@PathVariable int idVehiculoInspector, Model model) {
	
		Optional<VehiculoInspector> vehiculoIns = vhService.traerById(idVehiculoInspector);
       
		model.addAttribute("inspeccion", vehiculoIns.get());
		model.addAttribute("inspectores", inspectorService.listar());
		model.addAttribute("vehiculos", vService.listar());
		model.addAttribute("tipos", Estado.values());
		model.addAttribute("editMode", true);
		model.addAttribute("vehiculo",new Vehiculo());
		model.addAttribute("inspector",new Inspector());

		
		return "inspeccion/agregarInspeccion";
	}
	
	@GetMapping("/delete/{idVehiculoInspector}")
	public String delete(Model model, @PathVariable int idVehiculoInspector) throws Exception {
		vhService.delete(idVehiculoInspector);
		return "redirect:/";
	}

	

}
