package com.facundotorrez.pruebatecnca.models;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="vehiculos")
public class Vehiculo {
	@Id
	@Column(name="id_vehiculo")
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int idVehiculo;
	
	@Column(name="marca", nullable=false, length=45)
	private String marca;
	
	@Column(name="dominio", nullable=false, length=45)
	private String dominio;
	
	@Column(name="modelo", nullable=false,length = 45)
	private String modelo;
	
	@Column(name="createdat")
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@Column(name="updatedat")
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
	@ManyToOne
	@JoinColumn(name="id_dueño",nullable=false)
	private Dueño duenio;
	
	@OneToMany(mappedBy = "vehiculo",fetch = FetchType.LAZY, orphanRemoval = true )
	private Set<VehiculoInspector> vehiculosInspectores = new HashSet<>();

	public Vehiculo() {
		super();
	}
	



	public Vehiculo(String marca, String dominio, String modelo, LocalDateTime createdAt, LocalDateTime updatedAt,
			Dueño duenio) {
		super();
		this.marca = marca;
		this.dominio = dominio;
		this.modelo = modelo;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.duenio = duenio;
	}




	public int getIdVehiculo() {
		return idVehiculo;
	}


	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getDominio() {
		return dominio;
	}


	public void setDominio(String dominio) {
		this.dominio = dominio;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
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




	public Dueño getDuenio() {
		return duenio;
	}




	public void setDuenio(Dueño duenio) {
		this.duenio = duenio;
	}




	public Set<VehiculoInspector> getVehiculosInspectores() {
		return vehiculosInspectores;
	}




	public void setVehiculosInspectores(Set<VehiculoInspector> vehiculosInspectores) {
		this.vehiculosInspectores = vehiculosInspectores;
	}




	@Override
	public String toString() {
		return "Vehiculo [idVehiculo=" + idVehiculo + ", marca=" + marca + ", dominio=" + dominio + ", modelo=" + modelo
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", duenio=" + duenio + "]";
	}



	

	
	
	
	
	
	
	

}
