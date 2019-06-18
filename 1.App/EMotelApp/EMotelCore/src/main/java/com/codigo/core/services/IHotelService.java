package com.codigo.core.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codigo.core.entity.Hotel;

@Service
public interface IHotelService {
	
	public boolean agregar(Hotel hotel);
	public List<Hotel> listar();
	public boolean eliminar(int id);
	public Hotel cargarHotel(int id);
	
	List<Hotel> HotelPorDistrito(int id);
}
