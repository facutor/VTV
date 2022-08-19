package com.facundotorrez.pruebatecnca.models;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="duenios")
@PrimaryKeyJoinColumn(name = "idDuenio")
public class Dueño extends Persona{
	@Column(name="createdat")
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@Column(name="updatedat")
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY, mappedBy="duenio")
	private Set<Vehiculo> vehiculos;
	
	@Column(name="tipo", nullable = false )
    @Enumerated(value = EnumType.ORDINAL)
	private TipoDueño tipo;
	
	public enum TipoDueño{
		COMUN,
		EXENTO,
	}

	public Dueño() {
		super();
	}

	public Dueño(String nombre, String apellido, long dni, LocalDateTime createdAt, LocalDateTime updatedAt,
			Set<Vehiculo> vehiculos, TipoDueño tipo) {
		super(nombre, apellido, dni);
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.vehiculos = vehiculos;
		this.tipo = tipo;
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

	public Set<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(Set<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public TipoDueño getTipo() {
		return tipo;
	}

	public void setTipo(TipoDueño tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Dueño [createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", vehiculos=" + vehiculos + ", tipo="
				+ tipo + "]";
	}

	
	
	
	
	

	
	
	
	
	
	
	

}
