package com.codigo.test.system.testCase;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.codigo.test.system.selenium.page.AdminPage;
import com.codigo.test.system.selenium.page.HomePage;
import com.codigo.test.system.selenium.page.LoguinPage;
import com.codigo.test.system.selenium.page.RestaurantePage;

public class MantenimientoRestaurante {
	private String urlInicial = "http://localhost:8080/";
	private WebDriver webDriver = null;
	private HomePage homePage;
	private LoguinPage loguinPage;
	private AdminPage adminPage;
	private RestaurantePage restaurantePage;
	
	@BeforeTest
	public void inicioClase() throws Exception {
		this.homePage = new HomePage(this.urlInicial);
		this.webDriver = homePage.getWebDriver();
		this.loguinPage = new LoguinPage(webDriver);
		this.adminPage = new AdminPage(webDriver);
		this.restaurantePage = new RestaurantePage(webDriver);
	}
	
	@Test
	public void A_insertarRestaurante_FlujoBasico() throws Exception {
		try {
			String valorEsperado = "Restaurante guardado";
			homePage.hacerClicLoguin();
			loguinPage.Loguin("admin@gmail.com", "password");
			adminPage.IrRegistrarRestaurante();
			String valorObtenido = restaurantePage.RegistrarRestaurante_FlujoBasico();
			Assert.assertEquals(valorObtenido, valorEsperado);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(dependsOnMethods = {"A_insertarRestaurante_FlujoBasico"})
	public void A_insertarRestaurante_FlujoAlternativo() throws Exception {
		try {
			String valorEsperado = "Registrar Restaurante";
			adminPage.IrRegistrarRestaurante();
			String valorObtenido = restaurantePage.RegistrarRestaurante_FlujoAlternativo();
			Assert.assertEquals(valorObtenido, valorEsperado);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void B_mostrarRestaurante_FlujoBasico() throws Exception {
		try {
			String valorEsperado = "Listado de Restaurantes";
			adminPage.IrListarRestaurante();
			String valorObtenido = restaurantePage.ListarRestaurante_FlujoBasico();
			Assert.assertEquals(valorObtenido, valorEsperado);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void C_actualizarRestaurante_FlujoBasico() throws Exception {
		try {
			String valorEsperado = "Restaurante guardado";
			adminPage.IrListarRestaurante();
			String valorObtenido = restaurantePage.ActualizarRestaurante_FlujoBasico();
			Assert.assertEquals(valorObtenido, valorEsperado);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(dependsOnMethods = {"C_actualizarRestaurante_FlujoBasico"})
	public void C_actualizarRestaurante_FlujoAlternativo() throws Exception {
		try {
			String valorEsperado = "Editar Restaurante";
			adminPage.IrListarRestaurante();
			String valorObtenido = restaurantePage.ActualizarRestaurante_FlujoAlternativo();
			Assert.assertEquals(valorObtenido, valorEsperado);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void D_eliminarRestaurante_FlujoBasico() throws Exception {
		try {
			String valorEsperado = "Restaurante eliminado";
			adminPage.IrListarRestaurante();
			String valorObtenido = restaurantePage.EliminarRestaurante_FlujoBasico();
			Assert.assertEquals(valorObtenido, valorEsperado);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
