package com.facundotorrez.pruebatecnca.models;

import java.util.Set;

import javax.persistence.CascadeType;
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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="modelo")
public class Modelo {
	
	@Id
	@Column(name="id_modelo")
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int idModelo;
	
	@Column(name="modelo", nullable=false, length=45)
	private String modelo;
	
	@ManyToOne
	@JoinColumn(name="id_marca",nullable=false)

	private Marca marca;
	
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY, mappedBy="modelo")
	@JsonIgnore
	private Set<Vehiculo> vehiculos;

	
	public Modelo() {
		super();
	}


	public Modelo(int idModelo, String modelo, Marca marca) {
		super();
		this.idModelo = idModelo;
		this.modelo = modelo;
		this.marca = marca;
	}


	public int getIdModelo() {
		return idModelo;
	}


	public void setIdModelo(int idModelo) {
		this.idModelo = idModelo;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public Marca getMarca() {
		return marca;
	}


	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
	


	public Set<Vehiculo> getVehiculos() {
		return vehiculos;
	}


	public void setVehiculos(Set<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}


	@Override
	public String toString() {
		return "Modelo [idModelo=" + idModelo + ", modelo=" + modelo + ", marca=" + marca + "]";
	}
	
	
	

	
}
