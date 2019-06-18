package com.codigo.test.integration.test;

import static org.mockito.Mockito.doNothing;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.swing.Spring;

import org.hibernate.service.spi.InjectService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.codigo.core.entity.Distrito;
import com.codigo.core.entity.Hotel;
import com.codigo.core.entity.Provincia;
import com.codigo.core.entity.TipoHotel;
import com.codigo.core.services.DistritoService;
import com.codigo.core.services.HotelService;
import com.codigo.core.services.IHotelService;
import com.codigo.core.services.ITipoHotelService;
import com.codigo.core.services.TipoHotelService;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
@RunWith(SpringRunner.class)
@SpringBootTest
public class HotelIntegrationTest {

	@Autowired
	private IHotelService hotelServices;
	@Autowired
	private ITipoHotelService tipoHotelServices;
	private DistritoService distritoServices = new DistritoService();

	private static Hotel hotel = new Hotel();
	private String mensaje = "";
	private String nombreHotel = "";
	private Double precioHotel = 0.0;
	private String direccionHotel = "";
	private String nombreDistrito;
	private String nombreTipoHotel;
	private Provincia provincia;
	private Distrito distrito;
	private TipoHotel tipoHotel;
	@Mock
	private HttpServletResponse response;

	@Given("^despues de iniciar sesion en la aplicacion$")
	public void despues_de_iniciar_sesion_en_la_aplicacion() throws Throwable {
		MockitoAnnotations.initMocks(this);
		doNothing().when(response).sendRedirect("http://localhost/login");
		Assert.assertTrue(true);
	}
	
	@When("^hago click en la opción de Registrar Hotel en la parte izquierda de la página del dashboard del administrador$")
	public void hago_click_en_la_opción_de_Registrar_Hotel_en_la_parte_izquierda_de_la_página_del_dashboard_del_administrador() throws Throwable {
		doNothing().when(response).sendRedirect("http://localhost/admin/hotel_registrar.xhtml");
		Assert.assertTrue(true);
	}

	@When("^en la pantalla escribo en campo Nombre el valor de \"([^\"]*)\"$")
	public void en_la_nueva_pantalla_escribo_en_campo_Nombre_el_valor_de(String arg1) throws Throwable {
		nombreHotel = arg1;
		hotel.setNombre(nombreHotel);
	}
	
	@When("^en la pantalla escribo en campo Precio el valor de \"([^\"]*)\"$")
	public void en_la_nueva_pantalla_escribo_en_campo_Precio_el_valor_de(String arg1) throws Throwable {
		precioHotel = Double.parseDouble(arg1);
		hotel.setPrecio(precioHotel);
	}

	@When("^en la pantalla escribo en campo Direccion el valor de \"([^\"]*)\"$")
	public void en_la_nueva_pantalla_escribo_en_campo_Direccion_el_valor_de(String arg1) throws Throwable {
		direccionHotel = arg1;
		hotel.setUbicacion(direccionHotel);
	}
	
	@When("^busco   en el campo Distrito el valor de \"([^\"]*)\"$")
	public void busco_en_el_campo_Distrito_el_valor_de(String arg1) throws Throwable {
		nombreDistrito = arg1;
		
		try {
			List<Distrito> lista = distritoServices.listar();
			System.out.print("TAMAÑO"+ lista.size());
			distrito= lista.get(11);
			Assert.assertTrue(lista.size() > 0);
			hotel.setDistritos(distrito);	
		} catch (Exception e) {
			// TODO: handle exception
			Assert.fail("Error: " + e.getMessage());
		}
	}
	
	@When("^busco en el campo Tipo de Hotel el valor de \"([^\"]*)\"$")
	public void busco_en_el_campo_Tipo_de_Hotel_el_valor_de(String arg1) throws Throwable {
		nombreTipoHotel = arg1;		
		try {
			List<TipoHotel> lista = tipoHotelServices.listar();
			tipoHotel= lista.get(0);
			
			Assert.assertTrue(lista.size()>0);
			hotel.setTipohotel(tipoHotel);
		} catch (Exception e) {
			// TODO: handle exception
			Assert.fail("Error: " + e.getMessage());
		}
	}
	
	@When("^presiono en el boton de Registrar$")
	public void presiono_en_el_boton_de_Registrar() throws Throwable {
		try {
			hotelServices.agregar(hotel);
			mensaje = "Hotel guardado";
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Error: " + e.getMessage());
		}
	}

	@Then("^el sistema me muestra el mensaje de : \"([^\"]*)\"$")
	public void el_sistema_me_muestra_el_mensaje_de(String arg1) throws Throwable {
		try {
			Assert.assertEquals(arg1, mensaje);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Error: " + e.getMessage());
		}
	}

	
	@When("^hago click en la opción de Listar Hoteles en la parte izquierda de la página del dashboard del administrador$")
	public void hago_click_en_la_opción_de_Listar_Hoteles_en_la_parte_izquierda_de_la_página_del_dashboard_del_administrador() throws Throwable {
		try {
			List<Hotel> lista = hotelServices.listar();
			Assert.assertTrue(lista.size() > 0);
			hotel = lista.get(0);
			doNothing().when(response).sendRedirect("http://localhost/admin/hotel/listar.xhtml");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Error: " + e.getMessage());
		}
	}

	@When("^luego hago click en el boton de Editar$")
	public void luego_hago_click_en_el_boton_de_Editar() throws Throwable {
		doNothing().when(response).sendRedirect("http://localhost/admin/hotel/editar.xhtml");
		Assert.assertTrue(true);
	}

	@When("^presiono el boton de Actualizar$")
	public void presiono_el_boton_de_Actualizar() throws Throwable {
		try {
			hotelServices.agregar(hotel);
			mensaje = "Hotel Guardado";
			List<Hotel> lista = hotelServices.listar();
			Assert.assertTrue(lista.size() > 0);
			Assert.assertEquals(lista.get(0).getNombre().toUpperCase(), hotel.getNombre().toUpperCase());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Error: " + e.getMessage());
		}
	}

	@When("^luego hago click en el boton de Eliminar$")
	public void luego_hago_click_en_el_boton_de_Eliminar() throws Throwable {
		try {
			hotelServices.eliminar(hotel.getId());
			mensaje = "Hotel eliminado";
			Assert.assertTrue(true);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Error: " + e.getMessage());
		}
	}

}

