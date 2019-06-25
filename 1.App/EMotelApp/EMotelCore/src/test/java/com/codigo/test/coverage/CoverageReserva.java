package com.codigo.test.coverage;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.codigo.core.entity.Administrador;
import com.codigo.core.entity.Distrito;
import com.codigo.core.entity.Hotel;
import com.codigo.core.entity.Provincia;
import com.codigo.core.entity.Reserva;
import com.codigo.core.entity.Restaurante;
import com.codigo.core.entity.Rol;
import com.codigo.core.entity.TipoHotel;
import com.codigo.core.services.IAdministradorService;
import com.codigo.core.services.IHotelService;
import com.codigo.core.services.IReservaService;
import com.codigo.core.services.IRestauranteService;
import com.codigo.core.services.ITipoHotelService;
import com.codigo.core.services.ReservaService;

public class CoverageReserva {
	@Autowired
	IReservaService serviceReserva;
	
	ReservaService r = new ReservaService();

	//PRUEBA
	@Test
	public void test1() throws ParseException {
		Date d = new Date(119, 5, 12);;
		
			Reserva reserva = new Reserva();
			
			//HOTEL
			Hotel hotel=new Hotel();
			hotel.setId(0);
			hotel.setNombre("aaa");
			hotel.setPrecio(20.4);
			
			TipoHotel tipohotel=new TipoHotel();
			tipohotel.setId(0);
			tipohotel.setNombre("aaa");
			tipohotel.setDescripcion("ssss");
			hotel.setTipohotel(tipohotel);
			
			Distrito distrito=new Distrito();
			distrito.setId(0);
			distrito.setNombre("ppp");
			Provincia provincia=new Provincia();
			provincia.setId(0);
			provincia.setNombre("aaa");
			distrito.setProvincia(provincia);
			hotel.setDistritos(distrito);
			hotel.setUbicacion("aaa");
			
			//RESTAURANTE
			Restaurante restaurante=new Restaurante();
			restaurante.setId(0);
			restaurante.setDescripcion("aaa");
			restaurante.setDistrito(distrito);
			restaurante.setNombre("aaa");
			restaurante.setPrecio(20.5);
			restaurante.setUbicacion("aaa");
			
			//ADMINISTRACION
			Administrador admin=new Administrador();
			admin.setId(0);
			admin.setNombre("aaa");
			admin.setApellido("aaa");
			admin.setCorreo("bbb");
			admin.setFecha(d);
			admin.setPassword("aaa");
			
			Rol rol=new Rol();
			rol.setId(0);
			rol.setNombre("aaa");
			admin.setRol(rol);
			
			
			reserva.setHotel(hotel);
			reserva.setRestaurante(restaurante);
			reserva.setAdministrador(admin);
			reserva.setDiasreserva(2);
			reserva.setCostototal(300);
			reserva.setFechareserva(d);
			
			assertEquals(false,r.agregar(reserva));	
	}

	@Test
	public void test2() {
		Date d = new Date(119, 5, 12);;
		
		Reserva reserva = new Reserva();
		
		//HOTEL
		Hotel hotel=new Hotel();
		hotel.setId(0);
		hotel.setNombre("aaa");
		hotel.setPrecio(20.4);
		
		TipoHotel tipohotel=new TipoHotel();
		tipohotel.setId(0);
		tipohotel.setNombre("aaa");
		tipohotel.setDescripcion("ssss");
		hotel.setTipohotel(tipohotel);
		
		Distrito distrito=new Distrito();
		distrito.setId(0);
		distrito.setNombre("ppp");
		Provincia provincia=new Provincia();
		provincia.setId(0);
		provincia.setNombre("aaa");
		distrito.setProvincia(provincia);
		hotel.setDistritos(distrito);
		hotel.setUbicacion("aaa");
		
		//RESTAURANTE
		Restaurante restaurante=new Restaurante();
		restaurante.setId(0);
		restaurante.setDescripcion("aaa");
		restaurante.setDistrito(distrito);
		restaurante.setNombre("aaa");
		restaurante.setPrecio(20.5);
		restaurante.setUbicacion("aaa");
		
		//ADMINISTRACION
		Administrador admin=new Administrador();
		admin.setId(0);
		admin.setNombre("aaa");
		admin.setApellido("aaa");
		admin.setCorreo("bbb");
		admin.setFecha(d);
		admin.setPassword("aaa");
		
		Rol rol=new Rol();
		rol.setId(0);
		rol.setNombre("aaa");
		admin.setRol(rol);
		
		
		reserva.setHotel(null);
		reserva.setRestaurante(restaurante);
		reserva.setAdministrador(admin);
		reserva.setDiasreserva(2);
		reserva.setCostototal(300);
		reserva.setFechareserva(d);
		
		assertEquals(false,r.agregar(reserva));
       
	}
	
	@Test
	public void test3() {
		Date d = new Date(119, 5, 12);;
		
		Reserva reserva = new Reserva();
		
		//HOTEL
		Hotel hotel=new Hotel();
		hotel.setId(0);
		hotel.setNombre("aaa");
		hotel.setPrecio(20.4);
		
		TipoHotel tipohotel=new TipoHotel();
		tipohotel.setId(0);
		tipohotel.setNombre("aaa");
		tipohotel.setDescripcion("ssss");
		hotel.setTipohotel(tipohotel);
		
		Distrito distrito=new Distrito();
		distrito.setId(0);
		distrito.setNombre("ppp");
		Provincia provincia=new Provincia();
		provincia.setId(0);
		provincia.setNombre("aaa");
		distrito.setProvincia(provincia);
		hotel.setDistritos(distrito);
		hotel.setUbicacion("aaa");
		
		//RESTAURANTE
		Restaurante restaurante=new Restaurante();
		restaurante.setId(0);
		restaurante.setDescripcion("aaa");
		restaurante.setDistrito(distrito);
		restaurante.setNombre("aaa");
		restaurante.setPrecio(20.5);
		restaurante.setUbicacion("aaa");
		
		//ADMINISTRACION
		Administrador admin=new Administrador();
		admin.setId(0);
		admin.setNombre("aaa");
		admin.setApellido("aaa");
		admin.setCorreo("bbb");
		admin.setFecha(d);
		admin.setPassword("aaa");
		
		Rol rol=new Rol();
		rol.setId(0);
		rol.setNombre("aaa");
		admin.setRol(rol);
		
		
		reserva.setHotel(hotel);
		reserva.setRestaurante(null);
		reserva.setAdministrador(admin);
		reserva.setDiasreserva(2);
		reserva.setCostototal(300);
		reserva.setFechareserva(d);
		
		assertEquals(false,r.agregar(reserva));	}

	@Test
	public void test4() {
		Date d = new Date(119, 5, 12);;
		
		Reserva reserva = new Reserva();
		
		//HOTEL
		Hotel hotel=new Hotel();
		hotel.setId(0);
		hotel.setNombre("aaa");
		hotel.setPrecio(20.4);
		
		TipoHotel tipohotel=new TipoHotel();
		tipohotel.setId(0);
		tipohotel.setNombre("aaa");
		tipohotel.setDescripcion("ssss");
		hotel.setTipohotel(tipohotel);
		
		Distrito distrito=new Distrito();
		distrito.setId(0);
		distrito.setNombre("ppp");
		Provincia provincia=new Provincia();
		provincia.setId(0);
		provincia.setNombre("aaa");
		distrito.setProvincia(provincia);
		hotel.setDistritos(distrito);
		hotel.setUbicacion("aaa");
		
		//RESTAURANTE
		Restaurante restaurante=new Restaurante();
		restaurante.setId(0);
		restaurante.setDescripcion("aaa");
		restaurante.setDistrito(distrito);
		restaurante.setNombre("aaa");
		restaurante.setPrecio(20.5);
		restaurante.setUbicacion("aaa");
		
		//ADMINISTRACION
		Administrador admin=new Administrador();
		admin.setId(0);
		admin.setNombre("aaa");
		admin.setApellido("aaa");
		admin.setCorreo("bbb");
		admin.setFecha(d);
		admin.setPassword("aaa");
		
		Rol rol=new Rol();
		rol.setId(0);
		rol.setNombre("aaa");
		admin.setRol(rol);
		
		
		reserva.setHotel(null);
		reserva.setRestaurante(null);
		reserva.setAdministrador(admin);
		reserva.setDiasreserva(2);
		reserva.setCostototal(300);
		reserva.setFechareserva(d);
		
		assertEquals(false,r.agregar(reserva));       
	}
	@Test
	public void test5() {
		Date d = new Date(119, 5, 13);
		
		Reserva reserva = new Reserva();
			
			assertEquals(r.agregar(reserva),false);
       
	}
	
	
}
