package com.codigo.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codigo.core.repository.IRestauranteRepository;

import com.codigo.core.entity.Restaurante;

@Service
public class RestauranteService implements IRestauranteService {
	@Autowired
	IRestauranteRepository repository;
	
	@Override
	public boolean agregar(Restaurante restaurante) {
		boolean flag = false;
		
		try {
			Restaurante objRestaurante= repository.save(restaurante);
			
			if(objRestaurante != null) {
				flag = true;
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return flag;
	}

	@Override
	public List<Restaurante> listar() {
		return repository.findAll();
	}
	@Override
	public boolean eliminar(int id) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			repository.deleteById(id);
			flag = true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return flag;
	}

	@Override
	public Restaurante cargarRestaurante(int id) {
		
		Restaurante objRestaurante = null;
		try {
			objRestaurante = repository.getOne(id);
			//objAutor = autorRepo.findById(id).get();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return objRestaurante;
	}

	@Override
	public List<Restaurante> RestaurantePorDistrito(int id) {
		// TODO Auto-generated method stub
		return repository.RestaurantePorDistrito(id);
	}
}
