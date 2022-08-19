package com.facundotorrez.pruebatecnca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facundotorrez.pruebatecnca.interfaceServices.IVehiculoService;
import com.facundotorrez.pruebatecnca.models.Vehiculo;
import com.facundotorrez.pruebatecnca.repositories.IVehiculoRepository;
@Service
public class VehiculoService implements IVehiculoService{
	@Autowired
	private IVehiculoRepository vehiculoRepository;

	@Override
	public List<Vehiculo> listar() {
		// TODO Auto-generated method stub
		return vehiculoRepository.findAll();
	}

	@Override
	public Optional<Vehiculo> listarId(int id) {
		// TODO Auto-generated method stub
		return vehiculoRepository.findById(id);
	}
	@Override
	public Optional<Vehiculo> listarDominio(String dominio) {
		// TODO Auto-generated method stub
		return vehiculoRepository.findByDominio(dominio);
	}

	@Override
	public Vehiculo saveOrUpdate(Vehiculo v) throws Exception {
		// TODO Auto-generated method stub
		int idVehiculo = v.getIdVehiculo();
		System.out.println("ENTRE SERVICE "+ idVehiculo);
		Optional<Vehiculo> vehiculoBd =vehiculoRepository.findById(idVehiculo);
		if (vehiculoBd.isEmpty()) {
			return vehiculoRepository.save(v);
		}else {
			map(v, vehiculoBd.get());;
			return vehiculoRepository.save(vehiculoBd.get());
		}
		
	}
	
	void map(Vehiculo vehiculoModificado, Vehiculo preModificado) {
		if(vehiculoModificado.getMarca()!=null) {
			preModificado.setMarca(vehiculoModificado.getMarca());
		}
		if(vehiculoModificado.getDominio()!=null) {
			preModificado.setDominio(vehiculoModificado.getDominio());
		}
		if(vehiculoModificado.getDuenio()!=null){
			preModificado.setDuenio(vehiculoModificado.getDuenio());
		}
		
	}

	@Override
	public void delete(int id) throws Exception {
		// TODO Auto-generated method stub
		if (vehiculoRepository.findById(id).isEmpty()) {
			throw new Exception("El vehiculo con id: " + id + " no existe");
		}else vehiculoRepository.deleteById(id);
	
	}

	
	

}
