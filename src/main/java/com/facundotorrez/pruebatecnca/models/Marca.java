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
@Table(name="marca")
public class Marca {
	@Id
	@Column(name="id_marca")
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int idMarca;
	
	@Column(name="marca", nullable=false, length=45)
	private String marca;
	
	
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY, mappedBy="marca")
	@JsonIgnore
	private Set<Modelo> modelos;
	
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY, mappedBy="marca")
	@JsonIgnore
	private Set<Vehiculo> vehiculos;


	public Marca() {
		super();
	}


	


	public Marca(int idMarca, String marca, Set<Modelo> modelos, Set<Vehiculo> vehiculos) {
		super();
		this.idMarca = idMarca;
		this.marca = marca;
		this.modelos = modelos;
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


	

	public Set<Modelo> getModelos() {
		return modelos;
	}





	public void setModelos(Set<Modelo> modelos) {
		this.modelos = modelos;
	}





	public Set<Vehiculo> getVehiculos() {
		return vehiculos;
	}


	public void setVehiculos(Set<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}





	@Override
	public String toString() {
		return "Marca [idMarca=" + idMarca + ", marca=" + marca + ", modelos=" + modelos + ", vehiculos=" + vehiculos
				+ "]";
	}


	
	
	
	
	



	
	
	
	
	
	
	

}
