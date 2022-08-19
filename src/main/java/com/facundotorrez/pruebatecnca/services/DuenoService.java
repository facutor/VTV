package com.facundotorrez.pruebatecnca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facundotorrez.pruebatecnca.interfaceServices.IDueñoService;
import com.facundotorrez.pruebatecnca.models.Dueño;
import com.facundotorrez.pruebatecnca.repositories.IDueñoRepository;
@Service
public class DuenoService implements IDueñoService {
	@Autowired
	
	private IDueñoRepository dueñoRepository;

	@Override
	public List<Dueño> listar() {
		// TODO Auto-generated method stub
		return dueñoRepository.findAll();
	}

	@Override
	public Optional<Dueño> traerId(int id) {
		// TODO Auto-generated method stub
		return dueñoRepository.findById(id);
	}

	@Override
	public Optional<Dueño> listarDNI(long dni) throws Exception {
		// TODO Auto-generated method stub
		return dueñoRepository.findByDni(dni);
	}

	@Override
	public Dueño saveOrUpdate(Dueño dueño){
		// TODO Auto-generated method stub
		Optional<Dueño> dueñobd = dueñoRepository.findById(dueño.getIdDueño());
		if( dueñobd.isEmpty() ) {
			System.out.println("ENTRA ACA"+dueño.getTipo().values());
			return dueñoRepository.save(dueño);
		}else {
			map(dueño, dueñobd.get());
			System.out.println("hola"+dueño.getTipo().values());
			return dueñoRepository.save(dueñobd.get());
		}
	}


	@Override
	public void delete(int id) throws Exception {
		// TODO Auto-generated method stub
		if (dueñoRepository.findById(id) == null)
			throw new Exception("La persona con id: " + id + " no existe");
		else dueñoRepository.deleteById(id);
		
	}
	
	void map(Dueño registroModificado, Dueño preModificado ){
			
			if(registroModificado.getApellido()!=null) {
				preModificado.setApellido(registroModificado.getApellido());
			}
			if (registroModificado.getNombre()!=null) {
				preModificado.setNombre(registroModificado.getNombre());
			}
			if (registroModificado.getTipo()!=null) {
				preModificado.setTipo(registroModificado.getTipo());
			}
	}
	
	

}
