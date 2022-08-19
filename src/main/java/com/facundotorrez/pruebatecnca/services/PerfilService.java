package com.facundotorrez.pruebatecnca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facundotorrez.pruebatecnca.interfaceServices.IPerfilService;
import com.facundotorrez.pruebatecnca.models.Perfil;
import com.facundotorrez.pruebatecnca.repositories.IPerfilRepository;

@Service
public class PerfilService implements IPerfilService {
    @Autowired 
    private IPerfilRepository perfilRepository;
	
    @Override
	public List<Perfil> listar() {
		// TODO Auto-generated method stub
		return perfilRepository.findAll();
	}

}
