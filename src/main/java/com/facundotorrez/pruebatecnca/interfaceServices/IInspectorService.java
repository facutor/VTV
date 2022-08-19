package com.facundotorrez.pruebatecnca.interfaceServices;

import java.util.List;
import java.util.Optional;


import com.facundotorrez.pruebatecnca.models.Inspector;

public interface IInspectorService {
	public List<Inspector>listar();
	public Optional<Inspector>traerId(int id);
	public Optional<Inspector> listarDNI(long dni) throws Exception;
	public Inspector saveOrUpdate(Inspector i) throws Exception;
	public void delete(int id) throws Exception;
	

}
