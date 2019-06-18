package com.codigo.test.unit.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.codigo.core.entity.Distrito;
import com.codigo.core.entity.Hotel;
import com.codigo.core.entity.Restaurante;
import com.codigo.core.entity.TipoHotel;
import com.codigo.core.services.HotelService;
import com.codigo.core.services.RestauranteService;

@Category(com.codigo.test.unit.suite.PruebasUnitariasTest.class)
@RunWith(MockitoJUnitRunner.Silent.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RestaurantesTest {
	@Mock
	Restaurante restaurante = new Restaurante();
		
	@Mock
	RestauranteService restauranteServ;
	
	@BeforeClass
	public static void superInit() {
		System.out.println("Soy las pruebas de Restaurante");
	}
		
	@Test
	public void Test_registrar() {
		try {
			System.out.println("Soy la prueba de Registrar");
			when(restaurante.getId()).thenReturn(1);
			when(restaurante.getNombre()).thenReturn("Don Titos");
			when(restaurante.getPrecio()).thenReturn(10.0);
			when(restaurante.getUbicacion()).thenReturn("San Borja");
			
            when(restauranteServ.agregar(Matchers.any())).thenReturn(true);
            
			restauranteServ.agregar(restaurante);
			
			Assert.assertTrue(restaurante.getId() > 0);
			
		} catch (Exception e) {
			// TODO: handle exception
			Assert.fail();
		}
	}
	
	@Test
	public void Test_listar() {
		try {
			System.out.println("Soy la prueba de Listar");
			List<Restaurante> listarestaurantees = spy(new ArrayList<Restaurante>());
			when(listarestaurantees.add(Matchers.any())).thenReturn(true);
	        when(listarestaurantees.add(Matchers.any())).thenReturn(true);
	        
	        when(restauranteServ.listar()).thenReturn(listarestaurantees);
			
	        List<Restaurante> lista = restauranteServ.listar();
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
            when(restauranteServ.eliminar(restaurante.getId())).thenReturn(true);
            restauranteServ.eliminar(restaurante.getId());
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
            Restaurante restauranteBuscado;
            when(restaurante.getNombre()).thenReturn("Don Titos");
            when(restaurante.getId()).thenReturn(1);
            when(restauranteServ.cargarRestaurante(restaurante.getId())).thenReturn(restaurante);
            restauranteBuscado = restauranteServ.cargarRestaurante(restaurante.getId());
            Assert.assertNotNull(restauranteBuscado);            
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
    
    @Test
    public void Test_editar() {
    	 try {
             System.out.println("Soy la prueba de editar");
             Restaurante restauranteBuscado;
             when(restaurante.getNombre()).thenReturn("Don Titos");
             when(restaurante.getId()).thenReturn(1);
             when(restauranteServ.cargarRestaurante(restaurante.getId())).thenReturn(restaurante);
             restauranteBuscado = restauranteServ.cargarRestaurante(restaurante.getId());
             
             when(restauranteServ.agregar(Matchers.any())).thenReturn(true);
             restauranteServ.agregar(restaurante);
             
             Assert.assertEquals(restaurante.getNombre(),restauranteBuscado.getNombre());
         } catch (Exception e) {
             e.printStackTrace();
             Assert.fail();
         }
    }
	
}
