package com.codigo.core.service;

import java.util.List;

import com.codigo.core.entity.TipoHotel;
import com.codigo.core.repository.TipoHotelRepository;

public class TipoHotelServices {

	private final TipoHotelRepository tipohotelDao = new TipoHotelRepository();
	
	public boolean insertar(TipoHotel tipohotel) throws Exception{
		return this.tipohotelDao.insertar(tipohotel);
	}
	
	public void actualizar(TipoHotel tipohotel) throws Exception{
		this.tipohotelDao.actualizar(tipohotel);
	}
	
	public boolean eliminar(int tipohotel) throws Exception{
		return this.tipohotelDao.eliminar(tipohotel);
	}
	
	public TipoHotel obtener(int idProducto)throws Exception{
		return this.tipohotelDao.obtener(new TipoHotel(idProducto));
	}
	
	public List<TipoHotel> listar() throws Exception{
		return this.tipohotelDao.listar();
	}
	
}
