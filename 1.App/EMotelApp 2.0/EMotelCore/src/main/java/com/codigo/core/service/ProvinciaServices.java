package com.codigo.core.service;

import java.util.List;

import com.codigo.core.entity.Provincia;
import com.codigo.core.repository.ProvinciaRepository;

public class ProvinciaServices {

	private final ProvinciaRepository provinciaDao = new ProvinciaRepository();
	
	public boolean insertar(Provincia provincia) throws Exception{
		return this.provinciaDao.insertar(provincia);
	}
	
	public void actualizar(Provincia provincia) throws Exception{
		this.provinciaDao.actualizar(provincia);
	}
	
	public boolean eliminar(int provincia) throws Exception{
		return this.provinciaDao.eliminar(provincia);
	}
	
	public Provincia obtener(int idProducto)throws Exception{
		return this.provinciaDao.obtener(new Provincia(idProducto));
	}
	
	public List<Provincia> listar() throws Exception{
		return this.provinciaDao.listar();
	}
	
}
