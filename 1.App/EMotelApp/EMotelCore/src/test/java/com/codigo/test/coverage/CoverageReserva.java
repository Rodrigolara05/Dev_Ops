package com.codigo.test.coverage;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.codigo.core.entity.Administrador;
import com.codigo.core.entity.Hotel;
import com.codigo.core.entity.Reserva;
import com.codigo.core.entity.Restaurante;
import com.codigo.core.services.IAdministradorService;
import com.codigo.core.services.IHotelService;
import com.codigo.core.services.IReservaService;
import com.codigo.core.services.IRestauranteService;
import com.codigo.core.services.ITipoHotelService;
import com.codigo.core.services.ReservaService;

public class CoverageReserva {
	@Autowired
	IReservaService serviceReserva;
	IAdministradorService adminService;
	IHotelService hotelservise;
	IRestauranteService resturanteservice;
	IAdministradorService adminservice;
	
	ReservaService r = new ReservaService();

	//PRUEBA
	@Test
	public void test1() throws ParseException {
		Date d = new Date(119, 5, 12);;
		
			Reserva reserva = new Reserva();	
			reserva.setHotel(hotelservise.listar().get(0));
			reserva.setRestaurante(resturanteservice.listar().get(0));
			reserva.setAdministrador(adminservice.listar().get(0));
			reserva.setDiasreserva(2);
			reserva.setCostototal(300);
			reserva.setFechareserva(d);
			
			assertEquals(true,r.agregar(reserva));	
	}

	@Test
	public void test2() {
		Date d = new Date(119, 5, 12);;
		
		Reserva reserva = new Reserva();	
		
		reserva.setHotel(hotelservise.listar().get(0));
		reserva.setRestaurante(resturanteservice.listar().get(0));
		reserva.setAdministrador(adminservice.listar().get(0));	reserva.setDiasreserva(2);
		reserva.setDiasreserva(2);
		reserva.setCostototal(300);
		reserva.setFechareserva(d);
			
		assertEquals(r.agregar(reserva),false);
       
	}
	
	@Test
	public void test3() {
		Date d = new Date(119, 5, 12);;
		
		Reserva reserva = new Reserva();	
		reserva.setHotel(hotelservise.listar().get(0));
		reserva.setRestaurante(resturanteservice.listar().get(0));
		reserva.setAdministrador(adminservice.listar().get(0));
		reserva.setDiasreserva(2);
		reserva.setCostototal(300);
		reserva.setFechareserva(d);
			
		assertEquals(r.agregar(reserva),false);
       
	}

	@Test
	public void test4() {
		Date d = new Date(119, 5, 12);;
		
		Reserva reserva = new Reserva();	
		reserva.setHotel(hotelservise.listar().get(0));
		reserva.setRestaurante(resturanteservice.listar().get(0));
		reserva.setAdministrador(adminservice.listar().get(0));	reserva.setDiasreserva(2);
		reserva.setDiasreserva(2);
		reserva.setCostototal(300);
		reserva.setFechareserva(d);
			
		assertEquals(r.agregar(reserva),false);
       
	}
	@Test
	public void test5() {
		Date d = new Date(119, 5, 13);
		
		Reserva reserva = new Reserva();
			
			assertEquals(r.agregar(reserva),false);
       
	}
	
	
}
