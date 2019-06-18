package com.codigo.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codigo.core.repository.IHotelRepository;
import com.codigo.core.repository.IReservaRepository;
import com.codigo.core.entity.Distrito;
import com.codigo.core.entity.Hotel;
import com.codigo.core.entity.Reserva;
import com.codigo.core.entity.TipoHotel;

@Service
public class HotelService implements IHotelService {
	@Autowired
	 IHotelRepository repository;
	 IReservaRepository reservarepo;
	 
	
	@Override
	public boolean agregar(Hotel hotel) {
		boolean flag = false;
		TipoHotel tipoH=hotel.getTipohotel();
		Distrito distrito=hotel.getDistritos();
		
		try {
			if(tipoH==null||distrito==null)
			{
				flag=false;
			}else
			{
				Hotel objHotel= repository.save(hotel);
			
				if(objHotel != null) {
					flag = true;
				}
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return flag;
		/*
		boolean flag = false;
		
		try {
			Hotel objHotel= repository.save(hotel);
			
			if(objHotel != null) {
				flag = true;
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return flag;
		*/
	}

	@Override
	public List<Hotel> listar() {
		return repository.findAll();
	}
	
	@Override
	public boolean eliminar(int id) {		
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
	public Hotel cargarHotel(int id) {
		// TODO Auto-generated method stub
		Hotel objHotel = null;
		try {
			objHotel = repository.getOne(id);
			//objAutor = autorRepo.findById(id).get();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return objHotel;
	}

	@Override
	public List<Hotel> HotelPorDistrito(int id) {
		// TODO Auto-generated method stub
		return repository.HotelPorDistrito(id);
	}

}
