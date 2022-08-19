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
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="inspectors")
public class Inspector {
	
	@Id
	@Column(name="id_inspector")
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int idInspector;
	
	@Column(name="nombre", nullable=false, length=45)
	private String nombre;
	
	@Column(name="apellido", nullable=false, length=45)
	private String apellido;
	
	@Column(name="dni", nullable=false)
	private long dni;
	
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

	public Inspector(int idInspector, String nombre, String apellido, long dni, LocalDateTime createdAt,
			LocalDateTime updatedAt) {
		super();
		this.idInspector = idInspector;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public int getIdInspector() {
		return idInspector;
	}

	public void setIdInspector(int idInspector) {
		this.idInspector = idInspector;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
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
		return "Inspector [idInspector=" + idInspector + ", nombre=" + nombre + ", apellido=" + apellido + ", dni="
				+ dni + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
	
	
	

}
