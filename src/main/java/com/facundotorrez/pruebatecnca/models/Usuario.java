package com.facundotorrez.pruebatecnca.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="usuarios")
public class Usuario {
	
	@Id
	@Column(name="id_usuario")
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int idUsuario;
	
	@Column(name="nombreUsurio", nullable=false, length=45)
	private String nombreUsuario;
	
	@Column(name="contraseña", nullable=false, length=100)
	private String contraseña;
	
	@Column(name="isEnable")
	private boolean isEnable;
	

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_perfil")
	private Perfil perfil;
	

	public Usuario() {
		super();
	}

	public Usuario(Perfil perfil,int idUsuario, String nombreUsuario, String contraseña) {
		super();
	    this.perfil= perfil;
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.contraseña = contraseña;
		this.isEnable= true;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	

	public boolean isEnable() {
		return isEnable;
	}

	public void setEnable(boolean isEnable) {
		this.isEnable = isEnable;
	}
	
	
	


	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", contraseña=" + contraseña
				+ "]";
	}
	
	
	
	
	
	

}
