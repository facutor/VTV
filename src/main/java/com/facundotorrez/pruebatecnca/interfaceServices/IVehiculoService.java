package com.facundotorrez.pruebatecnca.interfaceServices;

import java.util.List;
import java.util.Optional;

import com.facundotorrez.pruebatecnca.models.Vehiculo;

public interface IVehiculoService {
	public List<Vehiculo>listar();
	public Optional<Vehiculo>listarId(int id);
	public Optional<Vehiculo>listarDominio(String dominio);
	
	public Vehiculo saveOrUpdate(Vehiculo v) throws Exception;
	public void delete(int id) throws Exception;

}
