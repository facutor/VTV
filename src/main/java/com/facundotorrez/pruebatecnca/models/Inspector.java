package com.facundotorrez.pruebatecnca.models;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="inspectors")
@PrimaryKeyJoinColumn(name = "idInspector")
public class Inspector extends Persona{
	
	
	@Column(name="createdat")
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@Column(name="updatedat")
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
	@OneToMany(mappedBy = "inspector",cascade = CascadeType.ALL)
	private Set<VehiculoInspector> vehiculosInspectores = new HashSet<>();
	
	


	

	public Inspector() {
		super();
	}

	public Inspector(String nombre, String apellido, long dni, LocalDateTime createdAt, LocalDateTime updatedAt,
			Set<VehiculoInspector> vehiculosInspectores) {
		super(nombre, apellido, dni);
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.vehiculosInspectores = vehiculosInspectores;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Set<VehiculoInspector> getVehiculosInspectores() {
		return vehiculosInspectores;
	}

	public void setVehiculosInspectores(Set<VehiculoInspector> vehiculosInspectoreSet) {
		this.vehiculosInspectores = vehiculosInspectoreSet;
	}

	@Override
	public String toString() {
		return "Inspector [createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", vehiculosInspectores="
				+ vehiculosInspectores + "]";
	}
	
	


	
	
	

}
