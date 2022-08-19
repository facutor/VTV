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
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="duenios")
public class Dueño {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int idDueño;
	
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

	public Dueño(int idDueño, String nombre, String apellido, long dni, LocalDateTime createdAt,
			LocalDateTime updatedAt, TipoDueño tipo) {
		super();
		this.idDueño = idDueño;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.tipo = tipo;
	}

	public int getIdDueño() {
		return idDueño;
	}

	public void setIdDueño(int idDueño) {
		this.idDueño = idDueño;
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

	public Set<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(Set<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public TipoDueño getTipo() {
		return tipo;
	}

	public void setTipo(TipoDueño tipoDueño) {
		this.tipo = tipoDueño;
	}

	@Override
	public String toString() {
		return "Dueño [idDueño=" + idDueño + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", tipoDueño=" + tipo + "]";
	}
	
	
	
	

	
	
	
	
	
	
	

}
