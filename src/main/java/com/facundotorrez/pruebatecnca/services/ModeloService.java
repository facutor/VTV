package com.facundotorrez.pruebatecnca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facundotorrez.pruebatecnca.interfaceServices.IModeloService;
import com.facundotorrez.pruebatecnca.models.Modelo;
import com.facundotorrez.pruebatecnca.repositories.IModeloRepository;

@Service
public class ModeloService implements IModeloService {
	@Autowired
	private IModeloRepository modeloRepository;

	@Override
	public List<Modelo> listar() {
		// TODO Auto-generated method stub
		return modeloRepository.findAll();
	}

	@Override
	public List<Modelo> listarPorMarca(int idMarca) {
		// TODO Auto-generated method stub
		return modeloRepository.findModeloByMarca(idMarca);
	}

	@Override
	public Optional<Modelo> traerPorId(int id) {
		// TODO Auto-generated method stub
		return modeloRepository.findById(id);
	}
	
	

}
