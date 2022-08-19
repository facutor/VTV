package com.facundotorrez.pruebatecnca.services; 

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facundotorrez.pruebatecnca.interfaceServices.IVehiculoInspectorService;
import com.facundotorrez.pruebatecnca.models.Dueño;
import com.facundotorrez.pruebatecnca.models.Vehiculo;
import com.facundotorrez.pruebatecnca.models.VehiculoInspector;
import com.facundotorrez.pruebatecnca.models.VehiculoInspector.Estado;
import com.facundotorrez.pruebatecnca.repositories.IVehiculoInspectorRepository;

@Service
public class VehiculoInspectorService implements IVehiculoInspectorService{
	@Autowired
	
	private IVehiculoInspectorRepository vehiculoInspectorRepository;

	@Override
	public List<VehiculoInspector> list() {
		// TODO Auto-generated method stub
		return vehiculoInspectorRepository.findAll();
	}

	@Override
	public Optional<VehiculoInspector> traerById(int id) {
		// TODO Auto-generated method stub
		return vehiculoInspectorRepository.findById(id);
	}

	@Override
	public List<VehiculoInspector> traerInspeccionesPorIdDueño(int idDueño) {
		// TODO Auto-generated method stub
		return vehiculoInspectorRepository.findInspeccionByIdDueño(idDueño);
	}

	@Override
	public List<VehiculoInspector> traerEstado(Estado estado) {
		// TODO Auto-generated method stub
		return vehiculoInspectorRepository.findVehiculoByEstado(estado);
	}

	public VehiculoInspector saveOrUpdate(VehiculoInspector v) throws Exception {
		// TODO Auto-generated method stub
		int idVehiculoInspector = v.getIdVehiculoInspector();
		Optional<VehiculoInspector> vehiculoiBd =vehiculoInspectorRepository.findById(idVehiculoInspector);
		if (vehiculoiBd.isEmpty()) {

			v.setEstado(determinarEstado(v.getMedicion(), v.getObservacion()));

			return vehiculoInspectorRepository.save(v);
		}else {
			map(v, vehiculoiBd.get());;
			vehiculoiBd.get().setEstado(determinarEstado(vehiculoiBd.get().getMedicion(), vehiculoiBd.get().getObservacion()));
			return vehiculoInspectorRepository.save(vehiculoiBd.get());
		}
		
	}
	
	void map(VehiculoInspector inspeccionModificado, VehiculoInspector preModificado) {
		if(inspeccionModificado.getMedicion()!=null) {
			preModificado.setMedicion(inspeccionModificado.getMedicion());
		}
		if(inspeccionModificado.getObservacion()!=null) {
			preModificado.setObservacion(inspeccionModificado.getObservacion());
		}
		if(inspeccionModificado.getObservacion()!=null) {
			preModificado.setObservacion(inspeccionModificado.getObservacion());
		}
	}

	@Override
	public void delete(int id) throws Exception {
		// TODO Auto-generated method stub
		if (vehiculoInspectorRepository.findById(id).isEmpty()) {
			throw new Exception("El vehiculo con id: " + id + " no existe");
		}else vehiculoInspectorRepository.deleteById(id);
	
	}
	
	public Estado determinarEstado(Estado medicion, Estado Observacion) {
		String apto=Estado.APTO.name();
		String condicional=Estado.CONDICIONAL.name();
		String rechazado=Estado.RECHAZADO.name();
		Estado resultado = null;
		if (medicion.name().equals(apto)&&Observacion.name().equals(apto)) {
			resultado = Estado.APTO;		
		}
		if (medicion.name().equals(rechazado)&&Observacion.name().equals(rechazado)) {
			resultado = Estado.RECHAZADO;		
		}
		if (medicion.name().equals(apto)&&Observacion.name().equals(rechazado)) {
			resultado = Estado.RECHAZADO;		
		}
		if (medicion.name().equals(rechazado)&&Observacion.name().equals(apto)) {
			resultado = Estado.RECHAZADO;
		}
		if (medicion.name().equals(rechazado)&&Observacion.name().equals(condicional)) {
			resultado = Estado.RECHAZADO;		
		}
		if (medicion.name().equals(condicional)&&Observacion.name().equals(rechazado)) {
			resultado = Estado.RECHAZADO;		
		}
		if (medicion.name().equals(condicional)&&Observacion.name().equals(apto)) {
			resultado = Estado.CONDICIONAL;		
		}
		if (medicion.name().equals(apto)&&Observacion.name().equals(condicional)) {
			resultado = Estado.CONDICIONAL;		
		}
		return resultado;
		
		
	}

	


}
