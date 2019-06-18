package com.codigo.core.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codigo.core.entity.TipoHotel;

@Service
public interface ITipoHotelService {

	public boolean agregar(TipoHotel tipohotel);
	public List<TipoHotel> listar();
	public boolean eliminar(int id);
	public TipoHotel cargarHotel(int id);
}
