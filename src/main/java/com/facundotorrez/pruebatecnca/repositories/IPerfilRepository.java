package com.facundotorrez.pruebatecnca.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.facundotorrez.pruebatecnca.models.Perfil;

@Repository
public interface IPerfilRepository extends JpaRepository<Perfil, Serializable>{

}
