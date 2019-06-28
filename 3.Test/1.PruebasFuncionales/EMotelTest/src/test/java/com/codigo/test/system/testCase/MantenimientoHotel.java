package com.codigo.test.system.testCase;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.codigo.test.system.selenium.page.AdminPage;
import com.codigo.test.system.selenium.page.HomePage;
import com.codigo.test.system.selenium.page.HotelPage;
import com.codigo.test.system.selenium.page.LoguinPage;


public class MantenimientoHotel {
	private String urlInicial = "http://localhost:8080/EMotelWeb/";
	private WebDriver webDriver = null;
	private HomePage homePage;
	private LoguinPage loguinPage;
	private AdminPage adminPage;
	private HotelPage hotelPage;
	
	@BeforeTest
	public void inicioClase() throws Exception {
		this.homePage = new HomePage(this.urlInicial);
		this.webDriver = homePage.getWebDriver();
		this.loguinPage = new LoguinPage(webDriver);
		this.adminPage = new AdminPage(webDriver);
		this.hotelPage = new HotelPage(webDriver);
	}
	
	@Test(priority = 0)
	public void A_insertarHotel_FlujoBasico() throws Exception {
		try {
			String valorEsperado = "Hotel guardado";
			homePage.hacerClicLoguin();
			loguinPage.Loguin("admin@gmail.com", "password");
			adminPage.IrRegistrarHotel();
			String valorObtenido = hotelPage.RegistrarHotel_FlujoBasico();
			Assert.assertEquals(valorObtenido, valorEsperado);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(dependsOnMethods = {"A_insertarHotel_FlujoBasico"}, priority = 1)
	public void A_insertarHotel_FlujoAlternativo() throws Exception {
		try {
			String valorEsperado = "Registrar Hotel";
			homePage.hacerClicLoguin();
			loguinPage.Loguin("admin@gmail.com", "password");
			adminPage.IrRegistrarHotel();
			String valorObtenido = hotelPage.RegistrarHotel_FlujoAlternativo();
			Assert.assertEquals(valorObtenido, valorEsperado);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(priority = 2)
	public void B_mostrarHotel_FlujoBasico() throws Exception {
		try {
			String valorEsperado = "Listado de hoteles";
			adminPage.IrListarHotel();
			String valorObtenido = hotelPage.ListarHotel_FlujoBasico();
			Assert.assertEquals(valorObtenido, valorEsperado);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(priority = 3)
	public void C_actualizarHotel_FlujoBasico() throws Exception {
		try {
			String valorEsperado = "Hotel guardado";
			adminPage.IrListarHotel();
			String valorObtenido = hotelPage.ActualizarHotel_FlujoBasico();
			Assert.assertEquals(valorObtenido, valorEsperado);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(dependsOnMethods = {"C_actualizarHotel_FlujoBasico"}, priority = 4)
	public void C_actualizarHotel_FlujoAlternativo() throws Exception {
		try {
			String valorEsperado = "Editar Hotel";
			adminPage.IrListarHotel();
			String valorObtenido = hotelPage.ActualizarHotel_FlujoAlternativo();
			Assert.assertEquals(valorObtenido, valorEsperado);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(priority = 5)
	public void D_eliminarHotel_FlujoBasico() throws Exception {
		try {
			String valorEsperado = "Hotel eliminado";
			adminPage.IrListarHotel();
			String valorObtenido = hotelPage.EliminarHotel_FlujoBasico();
			Assert.assertEquals(valorObtenido, valorEsperado);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
