package com.codigo.core.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codigo.core.entity.Restaurante;

@Service
public interface IRestauranteService {

	public boolean agregar(Restaurante restaurante);
	public List<Restaurante> listar();
	public boolean eliminar(int id);
	public Restaurante cargarRestaurante(int id);

	List<Restaurante> RestaurantePorDistrito(int id);
}
