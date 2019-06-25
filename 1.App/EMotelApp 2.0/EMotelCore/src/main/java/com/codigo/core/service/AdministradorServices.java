package com.codigo.core.service;

import java.util.List;

import com.codigo.core.entity.Administrador;
import com.codigo.core.repository.AdministradorRepository;

public class AdministradorServices {

	private final AdministradorRepository administradorDao = new AdministradorRepository();
	
	public boolean insertar(Administrador administrador) throws Exception{
		return this.administradorDao.insertar(administrador);
	}
	
	public void actualizar(Administrador administrador) throws Exception{
		this.administradorDao.actualizar(administrador);
	}
	
	public boolean eliminar(int id) throws Exception{
		return this.administradorDao.eliminar(id);
	}
	
	public Administrador obtener(int idProducto)throws Exception{
		return this.administradorDao.obtener(new Administrador(idProducto));
	}
	
	public List<Administrador> listar() throws Exception{
		return this.administradorDao.listar();
	}
	
	public Administrador buscarPorCorreo(String correo, String password) throws Exception{
		
		return this.administradorDao.buscarPorCorreo(correo,password);
	}
}
