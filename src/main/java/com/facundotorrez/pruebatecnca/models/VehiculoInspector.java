package com.facundotorrez.pruebatecnca.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name="vehiculos_inspectores")
public class VehiculoInspector {
	@Id
	@Column(name = "id_vehiculo_inspector")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVehiculoInspector;
	
	@ManyToOne
	@JoinColumn(name="id_vehiculo")
	@JsonIgnoreProperties(value ="vehiculosInspectores")
	private Vehiculo vehiculo;
	
	@ManyToOne
	@JoinColumn(name="id_inspector")
	@JsonIgnoreProperties(value ="vehiculosInspectores")
	private Inspector inspector;
	
	@Column(name="createdat")
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@Column(name="updatedat")
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
	@Column(name="valor")
	private float valor;
	
	@Column(name="estado", nullable = false )
    @Enumerated(value = EnumType.ORDINAL)
	private Estado estado;
	
	@Column(name="medicion", nullable = false )
    @Enumerated(value = EnumType.ORDINAL)
	private Estado medicion;
	
	@Column(name="observacion", nullable = false )
    @Enumerated(value = EnumType.ORDINAL)
	private Estado observacion;
	
	public enum Estado{
		APTO,
		CONDICIONAL,
		RECHAZADO
	}
	

	public VehiculoInspector() {
		super();
	}
	
	
	public VehiculoInspector(Vehiculo vehiculo, Inspector inspector, LocalDateTime createdAt, LocalDateTime updatedAt,
			float valor, Estado estado, Estado medicion, Estado observacion) {
		super();
		this.vehiculo = vehiculo;
		this.inspector = inspector;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.valor = valor;
		this.estado = estado;
		this.medicion = medicion;
		this.observacion = observacion;
	}


	public int getIdVehiculoInspector() {
		return idVehiculoInspector;
	}

	public void setIdVehiculoInspector(int idVehiculoInspector) {
		this.idVehiculoInspector = idVehiculoInspector;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Inspector getInspector() {
		return inspector;
	}

	public void setInspector(Inspector inspector) {
		this.inspector = inspector;
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

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Estado getMedicion() {
		return medicion;
	}

	public void setMedicion(Estado medicion) {
		this.medicion = medicion;
	}

	public Estado getObservacion() {
		return observacion;
	}

	public void setObservacion(Estado observacion) {
		this.observacion = observacion;
	}


	@Override
	public String toString() {
		return "VehiculoInspector [idVehiculoInspector=" + idVehiculoInspector + ", vehiculo=" + vehiculo
				+ ", inspector=" + inspector + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", valor="
				+ valor + ", estado=" + estado + ", medicion=" + medicion + ", observacion=" + observacion + "]";
	}

	
	
	

}
