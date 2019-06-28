package com.codigo.test.system.testCase;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.codigo.test.system.selenium.page.HomePage;
import com.codigo.test.system.selenium.page.LoguinPage;
import com.codigo.test.system.selenium.page.ReservaPage;
import com.codigo.test.system.selenium.page.UserPage;

public class MantenimientoReservaUser {
	private String urlInicial = "http://localhost:8080/EMotelWeb/";
	private WebDriver webDriver = null;
	private HomePage homePage;
	private LoguinPage loguinPage;
	private UserPage userPage;
	private ReservaPage reservaPage;
	
	@BeforeTest
	public void inicioClase() throws Exception {
		this.homePage = new HomePage(this.urlInicial);
		this.webDriver = homePage.getWebDriver();
		this.loguinPage = new LoguinPage(webDriver);
		this.userPage = new UserPage(webDriver);
		this.reservaPage = new ReservaPage(webDriver);
	}
	
	@Test(priority = 0)
	public void A_insertarReserva_FlujoBasico() throws Exception {
		try {
			String valorEsperado = "reserva guardada";
			homePage.hacerClicLoguin();
			loguinPage.Loguin("test@gmail.com", "test");
			userPage.IrRegistrarReserva();
			String valorObtenido = reservaPage.RegistrarReserva_FlujoBasico();
			Assert.assertEquals(valorObtenido, valorEsperado);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(dependsOnMethods = {"A_insertarReserva_FlujoBasico"}, priority=1)
	public void A_insertarReserva_FlujoAlternativo() throws Exception {
		try {
			String valorEsperado = "Registrar Reserva";
			userPage.IrRegistrarReserva();
			String valorObtenido = reservaPage.RegistrarReserva_FlujoAlternativo();
			Assert.assertEquals(valorObtenido, valorEsperado);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(priority=2)
	public void B_mostrarReserva_FlujoBasico() throws Exception {
		try {
			String valorEsperado = "Listado de Reservas";
			userPage.IrListarReserva();
			String valorObtenido = reservaPage.ListarReserva_FlujoBasico();
			Assert.assertEquals(valorObtenido, valorEsperado);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(priority=3)
	public void C_actualizarReserva_FlujoBasico() throws Exception {
		try {
			String valorEsperado = "reserva guardada";
			userPage.IrListarReserva();
			//userPage.IrEditarReserva();
			String valorObtenido = reservaPage.ActualizarReserva_FlujoBasico();
			Assert.assertEquals(valorObtenido, valorEsperado);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(dependsOnMethods = {"C_actualizarReserva_FlujoBasico"}, priority=4)
	public void C_actualizarReserva_FlujoAlternativo() throws Exception {
		try {
			String valorEsperado = "Editar Reserva";
			userPage.IrListarReserva();
			String valorObtenido = reservaPage.ActualizarReserva_FlujoAlternativo();
			Assert.assertEquals(valorObtenido, valorEsperado);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(priority=5)
	public void D_eliminarReserva_FlujoBasico() throws Exception {
		try {
			String valorEsperado = "reserva eliminada";
			userPage.IrListarReserva();
			String valorObtenido = reservaPage.EliminarReserva_FlujoBasico();
			Assert.assertEquals(valorObtenido, valorEsperado);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
