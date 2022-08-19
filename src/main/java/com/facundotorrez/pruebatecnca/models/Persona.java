package com.facundotorrez.pruebatecnca.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="personas")
@Inheritance( strategy = InheritanceType.JOINED)
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPersona;
	
	@Column(name="nombre", nullable=false, length=45)
	private String nombre;
	
	@Column(name="apellido", nullable=false, length=45)
	private String apellido;
	
	@Column(name="dni", nullable=false)
	private long dni;

	

	
	public Persona() {
		super();
	}

	public Persona(String nombre, String apellido, long dni) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
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

	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ "]";
	}
	
	

}
