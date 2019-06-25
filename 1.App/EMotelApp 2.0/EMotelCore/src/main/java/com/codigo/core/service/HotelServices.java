package com.codigo.core.service;

import java.util.List;

import com.codigo.core.entity.Hotel;
import com.codigo.core.repository.HotelRepository;

public class HotelServices {

	private final HotelRepository hotelDao = new HotelRepository();
	
	public boolean insertar(Hotel hotel) throws Exception{
		return this.hotelDao.insertar(hotel);
	}
	
	public void actualizar(Hotel hotel) throws Exception{
		this.hotelDao.actualizar(hotel);
	}
	
	public boolean eliminar(int id) throws Exception{
		return this.hotelDao.eliminar(id);
	}
	
	public Hotel obtener(int idProducto)throws Exception{
		return this.hotelDao.obtener(new Hotel(idProducto));
	}
	
	public List<Hotel> listar() throws Exception{
		return this.hotelDao.listar();
	}

	public List<Hotel> HotelPorDistrito(int id) {
		return this.hotelDao.HotelPorDistrito(id);
	}
	
}
