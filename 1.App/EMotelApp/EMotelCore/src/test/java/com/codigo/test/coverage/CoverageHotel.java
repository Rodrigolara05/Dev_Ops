package com.codigo.test.coverage;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.codigo.core.entity.Distrito;
import com.codigo.core.entity.Hotel;
import com.codigo.core.entity.TipoHotel;
import com.codigo.core.services.HotelService;
import com.codigo.core.services.IDistritoService;
import com.codigo.core.services.IHotelService;
import com.codigo.core.services.ITipoHotelService;

public class CoverageHotel {
	@Autowired
	ITipoHotelService serviceTipoHotel;
	IDistritoService serviceDistrito;
	IHotelService serviceHotel;
	
	HotelService s = new HotelService();
		
	//camino1
	@Test
	public void testAgregar1() {
	
		Hotel hotel = new Hotel();
		
		hotel.setNombre("miHotel");
		hotel.setPrecio(12.5);
		hotel.setUbicacion("av. Alameda Sur");
		hotel.setTipohotel(serviceTipoHotel.listar().get(0));
		hotel.setDistritos(serviceDistrito.listar().get(0));
		
		assertEquals(true, s.agregar(hotel));
	}
	@Test
	public void testAgregar2() {
	
		Hotel hotel = new Hotel();
		
		hotel.setNombre("miHotel");
		hotel.setPrecio(12.5);
		hotel.setUbicacion("av. Alameda Sur");
		hotel.setTipohotel(null);
		hotel.setDistritos(serviceDistrito.listar().get(0));
		
		assertEquals(false, s.agregar(hotel));
	}
	@Test
	public void testAgregar3() {
	
		Hotel hotel = new Hotel();
		
		hotel.setNombre("miHotel");
		hotel.setPrecio(12.5);
		hotel.setUbicacion("av. Alameda Sur");
		hotel.setTipohotel(null);
		hotel.setDistritos(null);
		
		assertEquals(false, s.agregar(hotel));
	}
	@Test
	public void testAgregar4() {
	
		Hotel hotel = new Hotel();
		
		hotel.setNombre("miHotel");
		hotel.setPrecio(12.5);
		hotel.setUbicacion("av. Alameda Sur");
		hotel.setTipohotel(serviceTipoHotel.listar().get(0));
		hotel.setDistritos(null);
		
		assertEquals(true, s.agregar(hotel));
	}
	
	@Test
	public void testAgregar5() {
	
		Hotel hotel = new Hotel();		
		assertEquals(true, s.agregar(hotel));
	}

}
