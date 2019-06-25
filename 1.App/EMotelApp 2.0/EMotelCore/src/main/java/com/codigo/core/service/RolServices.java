package com.codigo.core.service;

import java.util.List;

import com.codigo.core.entity.Rol;
import com.codigo.core.repository.RolRepository;

public class RolServices {

	private final RolRepository rolDao = new RolRepository();
	
	public boolean insertar(Rol rol) throws Exception{
		return this.rolDao.insertar(rol);
	}
	
	public void actualizar(Rol rol) throws Exception{
		this.rolDao.actualizar(rol);
	}
	
	public boolean eliminar(int rol) throws Exception{
		return this.rolDao.eliminar(rol);
	}
	
	public Rol obtener(int idProducto)throws Exception{
		return this.rolDao.obtener(new Rol(idProducto));
	}
	
	public List<Rol> listar() throws Exception{
		return this.rolDao.listar();
	}
	
}
