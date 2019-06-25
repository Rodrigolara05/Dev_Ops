package com.codigo.core.service;

import java.util.List;

import com.codigo.core.entity.Distrito;
import com.codigo.core.repository.DistritoRepository;

public class DistritoServices {

	private final DistritoRepository distritoDao = new DistritoRepository();
	
	public boolean insertar(Distrito distrito) throws Exception{
		return this.distritoDao.insertar(distrito);
	}
	
	public void actualizar(Distrito distrito) throws Exception{
		this.distritoDao.actualizar(distrito);
	}
	
	public boolean eliminar(int id) throws Exception{
		return this.distritoDao.eliminar(id);
	}
	
	public Distrito obtener(int idProducto)throws Exception{
		return this.distritoDao.obtener(new Distrito(idProducto));
	}
	
	public List<Distrito> listar() throws Exception{
		return this.distritoDao.listar();
	}
	
}
