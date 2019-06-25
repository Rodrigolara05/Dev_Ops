package com.codigo.core.service;

import java.util.List;

import com.codigo.core.entity.Restaurante;
import com.codigo.core.repository.RestauranteRepository;

public class RestauranteServices {

	private final RestauranteRepository restauranteDao = new RestauranteRepository();
	
	public boolean insertar(Restaurante restaurante) throws Exception{
		return this.restauranteDao.insertar(restaurante);
	}
	
	public void actualizar(Restaurante restaurante) throws Exception{
		this.restauranteDao.actualizar(restaurante);
	}
	
	public boolean eliminar(int restaurante) throws Exception{
		return this.restauranteDao.eliminar(restaurante);
	}
	
	public Restaurante obtener(int idProducto)throws Exception{
		return this.restauranteDao.obtener(new Restaurante(idProducto));
	}
	
	public List<Restaurante> listar() throws Exception{
		return this.restauranteDao.listar();
	}

	public List<Restaurante> RestaurantePorDistrito(int id) throws Exception {
		return this.restauranteDao.RestaurantePorDistrito(id);
	}
	
}
