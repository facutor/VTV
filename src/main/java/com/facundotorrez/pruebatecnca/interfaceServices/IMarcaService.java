package com.facundotorrez.pruebatecnca.interfaceServices;

import java.util.List;
import java.util.Optional;

import com.facundotorrez.pruebatecnca.models.Marca;



public interface IMarcaService {
	public List<Marca>listar();
	public Optional<Marca>traerId(int id);

}
