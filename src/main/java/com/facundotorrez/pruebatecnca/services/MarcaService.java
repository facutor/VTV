package com.facundotorrez.pruebatecnca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facundotorrez.pruebatecnca.interfaceServices.IMarcaService;
import com.facundotorrez.pruebatecnca.models.Marca;
import com.facundotorrez.pruebatecnca.repositories.IMarcaRepository;

@Service
public class MarcaService implements IMarcaService{

	@Autowired
	private IMarcaRepository marcaRepository;
	@Override
	public List<Marca> listar() {
		// TODO Auto-generated method stub
		return marcaRepository.findAll();
	}

	@Override
	public Optional<Marca> traerId(int id) {
		// TODO Auto-generated method stub
		return marcaRepository.findById(id);
	}

}
