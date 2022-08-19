package com.facundotorrez.pruebatecnca.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.facundotorrez.pruebatecnca.models.Dueño;
@Repository
public interface IDueñoRepository extends JpaRepository<Dueño, Serializable>{
	@Query("SELECT D FROM Dueño D  WHERE  D.dni = (:dni)")
	 java.util.Optional<Dueño> findByDni(@Param("dni") long dni);
	@Query("SELECT d  FROM Dueño d JOIN   d.vehiculos v JOIN  v.vehiculosInspectores ")
	List<Dueño> dueñosConVehiculo();

}
