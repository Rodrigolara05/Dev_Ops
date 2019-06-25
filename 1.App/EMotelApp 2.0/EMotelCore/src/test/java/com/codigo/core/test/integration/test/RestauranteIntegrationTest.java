package com.codigo.core.test.integration.test;

import static org.mockito.Mockito.doNothing;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.junit.Assert;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.codigo.core.entity.Distrito;
import com.codigo.core.entity.Provincia;
import com.codigo.core.entity.Restaurante;
import com.codigo.core.entity.TipoHotel;
import com.codigo.core.service.RestauranteServices;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class RestauranteIntegrationTest {
	private final RestauranteServices restauranteServices = new RestauranteServices();
	private static Restaurante restaurante = new Restaurante();
	private String mensaje = "";
	private String nombreRestaurante = "";
	private Double precioRestaurante = 0.0;
	private String descripcionRestaurante = "";
	private String ubicacionRestaurante = "";
	private String nombreDistrito;
	Distrito distrito;
	Provincia provincia;
	@Mock
	private HttpServletResponse response;

	@Given("^despues  de iniciar sesion en la aplicacion$")
	public void Restaurante_despues_de_iniciar_sesion_en_la_aplicacion() throws Throwable {
		MockitoAnnotations.initMocks(this);
		doNothing().when(response).sendRedirect("http://localhost/login");
		Assert.assertTrue(true);
	}

	@When("^hago  click en la opción de Registrar Restaurante en la parte izquierda de la página del dashboard del administrador$")
	public void Restaurante_hago_click_en_la_opción_de_Registrar_Restaurante_en_la_parte_izquierda_de_la_página_del_dashboard_del_administrador() throws Throwable {
		doNothing().when(response).sendRedirect("http://localhost/admin/restaurante_registrar.xhtml");
		Assert.assertTrue(true);
	}

	@When("^en  la pantalla escribo en campo Nombre el valor de \"([^\"]*)\"$")
	public void Restaurante_en_la_nueva_pantalla_escribo_en_campo_Nombre_el_valor_de(String arg1) throws Throwable {
		nombreRestaurante = arg1;
		restaurante.setNombre(nombreRestaurante);
	}
	
	@When("^en  la pantalla escribo en campo Precio el valor de \"([^\"]*)\"$")
	public void Restaurante_en_la_nueva_pantalla_escribo_en_campo_Precio_el_valor_de(String arg1) throws Throwable {
		precioRestaurante = Double.parseDouble(arg1);
		restaurante.setPrecio(precioRestaurante);
	}

	@When("^en  la pantalla escribo en campo Descripción el valor de \"([^\"]*)\"$")
	public void Restaurante_en_la_pantalla_escribo_en_campo_Descripción_el_valor_de(String arg1) throws Throwable {
		descripcionRestaurante = arg1;
		restaurante.setDescripcion(descripcionRestaurante);
	}
	
	
	@When("^en  la pantalla escribo en campo Ubicacion el valor de \"([^\"]*)\"$")
	public void Restaurante_en_la_nueva_pantalla_escribo_en_campo_Ubicacion_el_valor_de(String arg1) throws Throwable {
		ubicacionRestaurante = arg1;
		restaurante.setUbicacion(ubicacionRestaurante);
	}
	
	@When("^busco  en el campo Distrito el valor de \"([^\"]*)\"$")
	public void Restaurante_busco_en_el_campo_Distrito_el_valor_de(String arg1) throws Throwable {
		nombreDistrito = arg1;
		provincia.setId(1);
		
		distrito.setId(11);
		distrito.setNombre(nombreDistrito);
		distrito.setProvincia(provincia);
		
		restaurante.setDistrito(distrito);
	}
	
	
	@When("^presiono  el boton de Guardar$")
	public void Restaurante_presiono_el_boton_de_Guardar() throws Throwable {
		try {
			restauranteServices.insertar(restaurante);
			mensaje = "Restaurante guardado";
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Error: " + e.getMessage());
		}
	}

	@Then("^el  sistema me muestra el mensaje de: \"([^\"]*)\"$")
	public void Restaurante_el_sistema_me_muestra_el_mensaje_de(String arg1) throws Throwable {
		try {
			Assert.assertEquals(arg1, mensaje);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Error: " + e.getMessage());
		}
	}

	
	@When("^hago  click en la opción de Listar Restaurantes en la parte izquierda de la página del dashboard del administrador$")
	public void Restaurante_hago_click_en_la_opción_de_Listar_Restaurantes_en_la_parte_izquierda_de_la_página_del_dashboard_del_administrador() throws Throwable {
		try {
			List<Restaurante> lista = restauranteServices.listar();
			Assert.assertTrue(lista.size() > 0);
			restaurante = lista.get(0);
			doNothing().when(response).sendRedirect("http://localhost:8080/admin/restaurante_registrar.xhtml");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Error: " + e.getMessage());
		}

	}

	@When("^luego  hago click en el enlace de editar de un registro$")
	public void Restaurante_luego_hago_click_en_el_enlace_de_editar_de_un_registro() throws Throwable {
		doNothing().when(response).sendRedirect("http://localhost:8080/admin/restaurante_registrar.html");
		Assert.assertTrue(true);
	}

	@When("^presiono  el boton de Actualizar Restaurante$")
	public void Restaurante_presiono_el_boton_de_Actualizar() throws Throwable {
		try {
			
			restauranteServices.insertar(restaurante);
			mensaje = "Restaurante Guardado";
			List<Restaurante> lista = restauranteServices.listar();
			Assert.assertTrue(lista.size() > 0);
			Assert.assertEquals(lista.get(0).getNombre().toUpperCase(), restaurante.getNombre().toUpperCase());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Error: " + e.getMessage());
		}
	}

	@When("^luego  hago click en el enlace de eliminar de un registro$")
	public void Restaurante_luego_hago_click_en_el_enlace_de_eliminar_de_un_registro() throws Throwable {
		try {
			restauranteServices.eliminar(restaurante.getId());
			mensaje = "Restaurante eliminado";
			Assert.assertTrue(true);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Error: " + e.getMessage());
		}
	}
}
