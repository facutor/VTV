package com.facundotorrez.pruebatecnca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facundotorrez.pruebatecnca.interfaceServices.IInspectorService;
import com.facundotorrez.pruebatecnca.models.Dueño;
import com.facundotorrez.pruebatecnca.models.Inspector;
import com.facundotorrez.pruebatecnca.repositories.IInspectorRepository;

@Service
public class InspectorService implements IInspectorService{
	@Autowired
	private IInspectorRepository inspectorRepository;

	@Override
	public List<Inspector> listar() {
		// TODO Auto-generated method stub
		return inspectorRepository.findAll();
	}

	@Override
	public Optional<Inspector> traerId(int id) {
		// TODO Auto-generated method stub
		return inspectorRepository.findById(id);
	}

	@Override
	public Optional<Inspector> listarDNI(long dni) throws Exception {
		// TODO Auto-generated method stub
		return inspectorRepository.findByDni(dni);
	}

	@Override
	public Inspector saveOrUpdate(Inspector inspector) {
		// TODO Auto-generated method stub
		int idInspector = inspector.getIdInspector();
		Optional<Inspector> inspectorbd = inspectorRepository.findById(idInspector);
		if( inspectorbd.isEmpty() ) {
			return inspectorRepository.save(inspector);
		}else {
			map(inspector, inspectorbd.get());
			return inspectorRepository.save(inspectorbd.get());
		}
	}
	
	void map(Inspector registroModificado,Inspector preModificado ){
		
		if(registroModificado.getApellido()!=null) {
			preModificado.setApellido(registroModificado.getApellido());
		}
		if (registroModificado.getNombre()!=null) {
			preModificado.setNombre(registroModificado.getNombre());
		}
}

	@Override
	public void delete(int id) throws Exception {
		// TODO Auto-generated method stub
		if (inspectorRepository.findById(id) == null)
			throw new Exception("La persona con id: " + id + " no existe");
		else inspectorRepository.deleteById(id);
		
	}
	

}
