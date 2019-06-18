package com.codigo.core.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codigo.core.repository.IHotelRepository;
import com.codigo.core.repository.IReservaRepository;
import com.codigo.core.repository.IRestauranteRepository;
import com.codigo.core.entity.Hotel;
import com.codigo.core.entity.Reserva;
import com.codigo.core.entity.Restaurante;

@Service
public class ReservaService implements IReservaService {
	@Autowired
	IReservaRepository repository;
	IHotelRepository hotelrepo;
	IRestauranteRepository restauranterepo;
	IDistritoService serviceDistrito;
	
	@Override
	public boolean agregar(Reserva reserva) {
		
		boolean flag = false;
		
		Hotel hotel = reserva.getHotel();
		Restaurante restaurante = reserva.getRestaurante();
		
		try {
			if(hotel.getId()==0 || restaurante.getId()==0)
			{
				flag=false;
				
			}else
			{
				if(reserva.getFechareserva() == null) {
					Date d = new Date(116, 5, 12);
					reserva.setFechareserva(d);
				}
				Reserva objReserva= repository.save(reserva);
				
					if(objReserva != null) 
					{
						flag = true;
					}else
					{
						flag = false;
					}
			}
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return flag;
	}

	@Override
	public List<Reserva> listar() {
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
	public Reserva cargarReserva(int id) {
		// TODO Auto-generated method stub
		Reserva objReserva = null;
		try {
			objReserva = repository.getOne(id);
			//objAutor = autorRepo.findById(id).get();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return objReserva;
	}
	@Override
	public List<Reserva> buscarPorParametro(int hotel, int restaurante) {
		// TODO Auto-generated method stub
		return repository.buscarPorParametro(hotel, restaurante);
	}
}
