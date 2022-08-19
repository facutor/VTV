package com.facundotorrez.pruebatecnca.repositories;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.facundotorrez.pruebatecnca.models.Inspector;
@Repository
public interface IInspectorRepository extends JpaRepository<Inspector, Serializable>{
	@Query("SELECT i FROM Inspector i WHERE i.dni=(:dni)")
	Optional<Inspector>findByDni(@Param("dni") long dni);
}
