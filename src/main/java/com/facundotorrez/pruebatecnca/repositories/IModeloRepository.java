package com.facundotorrez.pruebatecnca.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.facundotorrez.pruebatecnca.models.Marca;
import com.facundotorrez.pruebatecnca.models.Modelo;
import com.facundotorrez.pruebatecnca.models.VehiculoInspector;

@Repository
public interface IModeloRepository extends  JpaRepository<Modelo , Serializable>{
	@Query("SELECT m FROM Modelo m JOIN FETCH  m.marca ma where ma.idMarca =(:idMarca)")
	public List<Modelo> findModeloByMarca(@Param("idMarca")int idMarca);
	

}
