package com.facundotorrez.pruebatecnca.interfaceServices;

import java.util.List;
import java.util.Optional;

import com.facundotorrez.pruebatecnca.models.Dueño;
import com.facundotorrez.pruebatecnca.models.VehiculoInspector;
import com.facundotorrez.pruebatecnca.models.VehiculoInspector.Estado;

public interface IVehiculoInspectorService  {
	public List<VehiculoInspector>list();
	public Optional<VehiculoInspector>traerById(int id);
	public List<VehiculoInspector>traerEstado(Estado estado);
	public List<VehiculoInspector>traerInspeccionesPorIdDueño(int idDueño);
	public VehiculoInspector saveOrUpdate(VehiculoInspector i) throws Exception;
	public void delete(int id) throws Exception;
}