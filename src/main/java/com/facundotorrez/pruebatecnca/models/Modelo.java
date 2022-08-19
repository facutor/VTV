package com.facundotorrez.pruebatecnca.models;

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

@Entity
@Table(name="modelo")
public class Modelo {
	
	@Id
	@Column(name="id_modelo")
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int idModelo;
	
	@Column(name="modelo", nullable=false, length=45)
	private String modelo;
	
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY, mappedBy="modelo")
	private Set<Marca> marcas;

	
	public Modelo() {
		super();
	}


	public Modelo(int idModelo, String modelo, Set<Marca> marcas) {
		super();
		this.idModelo = idModelo;
		this.modelo = modelo;
		this.marcas = marcas;
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


	public Set<Marca> getMarcas() {
		return marcas;
	}


	public void setMarcas(Set<Marca> marcas) {
		this.marcas = marcas;
	}


	@Override
	public String toString() {
		return "Modelo [idModelo=" + idModelo + ", modelo=" + modelo + ", marcas=" + marcas + "]";
	}
	
	
	

	
}
