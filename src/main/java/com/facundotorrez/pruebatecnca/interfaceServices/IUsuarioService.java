package com.facundotorrez.pruebatecnca.interfaceServices;

import com.facundotorrez.pruebatecnca.models.Dueño;
import com.facundotorrez.pruebatecnca.models.Usuario;

public interface IUsuarioService {
	
	public Usuario saveOrUpdate(Usuario U) throws Exception;

}
