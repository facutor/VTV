package com.facundotorrez.pruebatecnca.repositories;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.facundotorrez.pruebatecnca.models.Vehiculo;
@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Serializable>{
	@Query("SELECT v FROM Vehiculo v  WHERE  v.dominio = (:dominio)")
	public Optional<Vehiculo> findByDominio(@Param("dominio") String dominio);
	

}
