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

@Entity
@Table(name="marca")
public class Marca {
	@Id
	@Column(name="id_marca")
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int idMarca;
	
	@Column(name="marca", nullable=false, length=45)
	private String marca;
	
	@ManyToOne
	@JoinColumn(name="id_modelo",nullable=false)
	private Modelo modelo;
	
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY, mappedBy="marca")
	private Set<Vehiculo> vehiculos;


	public Marca() {
		super();
	}


	public Marca(String marca, Modelo modelo, Set<Vehiculo> vehiculos) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.vehiculos = vehiculos;
	}


	public int getIdMarca() {
		return idMarca;
	}


	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public Modelo getModelo() {
		return modelo;
	}


	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}


	public Set<Vehiculo> getVehiculos() {
		return vehiculos;
	}


	public void setVehiculos(Set<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}


	@Override
	public String toString() {
		return "Marca [idMarca=" + idMarca + ", marca=" + marca + ", modelo=" + modelo + ", vehiculos=" + vehiculos
				+ "]";
	}
	
	
	
	



	
	
	
	
	
	
	

}
