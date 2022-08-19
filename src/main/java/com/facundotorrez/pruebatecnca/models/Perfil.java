package com.facundotorrez.pruebatecnca.models;

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

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="perfil")
public class Perfil {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int idPerfil;
	
	@Column(name="perfil", nullable=false, length=45)
	private String perfil;
	
	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER, mappedBy="perfil")
	private Set<Usuario> usuarios = new HashSet<Usuario>();

	public Perfil() {
		super();
	}

	public Perfil(String perfil, Set<com.facundotorrez.pruebatecnca.models.Usuario> usuarios) {
		super();
		this.perfil = perfil;
		this.usuarios = usuarios;
	}

	public int getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public String toString() {
		return "Perfil [idPerfil=" + idPerfil + ", perfil=" + perfil + ", usuarios=" + usuarios + "]";
	}
	
	
	

	
	
	

}
