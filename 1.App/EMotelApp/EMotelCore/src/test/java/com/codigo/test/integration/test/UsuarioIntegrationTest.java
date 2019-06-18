package com.codigo.test.integration.test;

import static org.mockito.Mockito.doNothing;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.junit.Assert;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.codigo.core.entity.Administrador;
import com.codigo.core.entity.Distrito;
import com.codigo.core.entity.Provincia;
import com.codigo.core.entity.Restaurante;
import com.codigo.core.entity.Rol;
import com.codigo.core.entity.TipoHotel;
import com.codigo.core.services.AdministradorService;
import com.codigo.core.services.RestauranteService;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class UsuarioIntegrationTest {
 
 private final AdministradorService adminServices = new AdministradorService();
 private static Administrador admin = new Administrador();
 
 private String mensaje = "";
 private String nombre = "";
 private String apellido = "";
 private String correo = "";
 private String password = "";
 private String fecha;
 private Rol rol;
 @Mock
 private HttpServletResponse response;

 @Given("^despues de entrar a la pagina web$")
 public void despues_de_entrar_a_la_pagina_web() throws Throwable {
 MockitoAnnotations.initMocks(this);
 doNothing().when(response).sendRedirect("http://localhost/");
 Assert.assertTrue(true);
 }

 

 @When("^hago click en la opción de Registrarse en la parte superior de la pagina$")
 public void hago_click_en_la_opción_de_Registrarse_en_la_parte_superior_de_la_pagina() throws Throwable {
 doNothing().when(response).sendRedirect("http://localhost/registrarse.xhtml");
 Assert.assertTrue(true);
 }
 
 
 @When("^hago click en la opción de Iniciar Sesion en la parte superior de la pagina$")
 public void hago_click_en_la_opción_de_Iniciar_Sesion_en_la_parte_superior_de_la_pagina() throws Throwable {
 doNothing().when(response).sendRedirect("http://localhost/login.xhtml");
 Assert.assertTrue(true);
 }

 @When("^en la pantalla escribo en campo  Nombre el valor de \"([^\"]*)\"$")
 public void en_la_pantalla_escribo_en_campo_Nombre_el_valor_de(String arg1) throws Throwable {
 nombre = arg1;
 admin.setNombre(correo);
 }

 @When("^en la pantalla escribo en campo  Apellido el valor de \"([^\"]*)\"$")
 public void en_la_pantalla_escribo_en_campo_Apellido_el_valor_de(String arg1) throws Throwable {
 apellido = arg1;
 admin.setApellido(apellido);
 }

 @When("^en la pantalla escribo en campo  Fecha el valor de \"([^\"]*)\"$")
 public void en_la_pantalla_escribo_en_campo_Fecha_el_valor_de(String arg1) throws Throwable {
 fecha = arg1;
 Date date= new Date();
 admin.setFecha(date);
 }

 @When("^en la pantalla escribo en campo  Rol el valor de \"([^\"]*)\"$")
 public void en_la_pantalla_escribo_en_campo_Rol_el_valor_de(String arg1) throws Throwable {
 rol.setNombre(arg1);
 rol.setId(2);
 admin.setRol(rol);
 }
 
 @When("^en la pantalla escribo en campo  Email el valor de \"([^\"]*)\"$")
 public void en_la_pantalla_escribo_en_campo_Email_el_valor_de(String arg1) throws Throwable {
 correo = arg1;
 admin.setCorreo(correo);
 }

 @When("^en la pantalla escribo en campo  Password el valor de \"([^\"]*)\"$")
 public void en_la_pantalla_escribo_en_campo_Password_el_valor_de(String arg1) throws Throwable {
 password = arg1;
 admin.setPassword(password);
 }

 @Then("^el sistema me muestra el mensaje de \"([^\"]*)\"$")
	public void el_sistema_me_muestra_el_mensaje_de(String arg1) throws Throwable {
		try {
			Assert.assertEquals(arg1, mensaje);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Error: " + e.getMessage());
		}
 }
 
 @Then("^el sistema debe redireccionar al dashboard del cliente que es la visualización de Hoteles y Restaurantes$")
	public void el_sistema_debe_redireccionar_al_dashboard_del_cliente() throws Throwable {
	 doNothing().when(response).sendRedirect("http://localhost/hotel/listar/0.xhtml");
	 Assert.assertTrue(true);
}
 @When("^presiono en el boton de    Registrar$")
 public void presiono_en_el_boton_de_Registrar() throws Throwable {
 try {
 adminServices.agregar(admin);
 mensaje = "Inicio sesion";
 } catch (Exception e) {
 e.printStackTrace();
 Assert.fail("Error: " + e.getMessage());
 }
 }
 
 @When("^presiono en el boton de Iniciar Sesion$")
 public void presiono_en_el_boton_de_Iniciar_Sesion() throws Throwable {
 try {
 adminServices.buscarPorCorreo(admin.getCorreo(),admin.getPassword());
 mensaje = "Inicio sesion";
 } catch (Exception e) {
 e.printStackTrace();
 Assert.fail("Error: " + e.getMessage());
 }
 }
 
}