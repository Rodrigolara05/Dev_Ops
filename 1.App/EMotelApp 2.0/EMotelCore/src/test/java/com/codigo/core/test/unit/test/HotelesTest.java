package com.codigo.core.test.unit.test;



import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import com.codigo.core.entity.Distrito;
import com.codigo.core.entity.Hotel;
import com.codigo.core.entity.TipoHotel;
import com.codigo.core.service.HotelServices;
import com.codigo.core.test.unit.suit.PruebasUnitariasTest;

@Category(PruebasUnitariasTest.class)
@RunWith(MockitoJUnitRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HotelesTest {
	
	@Mock
	Hotel hotel = new Hotel();
		
	@Mock
	HotelServices hotelServ;
	
	@BeforeClass
	public static void superInit() {
		System.out.println("Soy las pruebas de Hoteles");
	}
		
	@Test
	public void Test_registrar() {
		try {
			System.out.println("Soy la prueba de Registrar");
			when(hotel.getId()).thenReturn(1);
			when(hotel.getNombre()).thenReturn("Sheraton");
			when(hotel.getPrecio()).thenReturn(10.0);
			when(hotel.getUbicacion()).thenReturn("Cedros de villa");
			when(hotel.getDistritos()).thenReturn(new Distrito());
			when(hotel.getTipohotel()).thenReturn(new TipoHotel());

            when(hotelServ.insertar(Matchers.any())).thenReturn(true);
            
			hotelServ.insertar(hotel);
			
			Assert.assertTrue(hotel.getId() > 0);
			
		} catch (Exception e) {
			// TODO: handle exception
			Assert.fail();
		}
	}
	
	@Test
	public void Test_listar() {
		try {
			System.out.println("Soy la prueba de Listar");
			List<Hotel> listaHoteles = spy(new ArrayList<Hotel>());
			when(listaHoteles.add(Matchers.any())).thenReturn(true);
	        when(listaHoteles.add(Matchers.any())).thenReturn(true);
	        
	        when(hotelServ.listar()).thenReturn(listaHoteles);
			
	        List<Hotel> lista = hotelServ.listar();
	        Assert.assertTrue(lista.size() > 0);
	        
			
		} catch (Exception e) {
			e.printStackTrace();
            Assert.fail();
		}
	}
	
    @Test
    public void Test_eliminar() {
        try {
            System.out.println("Soy la prueba de Eliminar");
            when(hotelServ.eliminar(hotel.getId())).thenReturn(true);
            hotelServ.eliminar(hotel.getId());
            Assert.assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void Test_cargar() {
        try {
            System.out.println("Soy la prueba de cargar");
            Hotel hotelBuscado;
            when(hotel.getNombre()).thenReturn("Sheraton");
            when(hotel.getId()).thenReturn(1);
            when(hotelServ.obtener(hotel.getId())).thenReturn(hotel);
            hotelBuscado = hotelServ.obtener(hotel.getId());
            Assert.assertNotNull(hotelBuscado);            
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
    
    @Test
    public void Test_editar() {
    	 try {
             System.out.println("Soy la prueba de editar");
             Hotel hotelBuscado;
             when(hotel.getNombre()).thenReturn("Sheraton");
             when(hotel.getId()).thenReturn(1);
             when(hotelServ.obtener(hotel.getId())).thenReturn(hotel);
             hotelBuscado = hotelServ.obtener(hotel.getId());
             
             when(hotelServ.insertar(Matchers.any())).thenReturn(true);
             hotelServ.insertar(hotel);
             
             Assert.assertEquals(hotel.getNombre(),hotelBuscado.getNombre());
         } catch (Exception e) {
             e.printStackTrace();
             Assert.fail();
         }
    }
	
}
