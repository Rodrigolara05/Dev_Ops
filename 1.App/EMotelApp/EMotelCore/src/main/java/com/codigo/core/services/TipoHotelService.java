package com.codigo.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codigo.core.repository.ITipoHotelRepository;

import com.codigo.core.entity.TipoHotel;

@Service
public class TipoHotelService implements ITipoHotelService {

	@Autowired
	ITipoHotelRepository repository;
	
	@Override
	public boolean agregar(TipoHotel tipohotel) {
		boolean flag = false;
		
		try {
			TipoHotel objTipoHotel= repository.save(tipohotel);
			
			if(objTipoHotel != null) {
				flag = true;
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return flag;
	}

	@Override
	public List<TipoHotel> listar() {
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
	public TipoHotel cargarHotel(int id) {
		// TODO Auto-generated method stub
		TipoHotel objTipoHotel = null;
		try {
			objTipoHotel = repository.getOne(id);
			//objAutor = autorRepo.findById(id).get();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return objTipoHotel;
	}
	
}
