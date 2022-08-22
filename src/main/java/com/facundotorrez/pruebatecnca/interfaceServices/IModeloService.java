package com.facundotorrez.pruebatecnca.interfaceServices;

import java.util.List;
import java.util.Optional;

import com.facundotorrez.pruebatecnca.models.Inspector;
import com.facundotorrez.pruebatecnca.models.Modelo;

public interface IModeloService {
	public Optional<Modelo>traerPorId(int id);
	public List<Modelo>listar();
	public List<Modelo>listarPorMarca(int idMarca);

}
