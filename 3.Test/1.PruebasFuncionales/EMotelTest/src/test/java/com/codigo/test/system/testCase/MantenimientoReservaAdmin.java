package com.codigo.test.system.testCase;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.codigo.test.system.selenium.page.AdminPage;
import com.codigo.test.system.selenium.page.HomePage;
import com.codigo.test.system.selenium.page.LoguinPage;
import com.codigo.test.system.selenium.page.ReservaPage;

public class MantenimientoReservaAdmin {
	private String urlInicial = "http://localhost:8080/EMotelWeb/";
	private WebDriver webDriver = null;
	private HomePage homePage;
	private LoguinPage loguinPage;
	private AdminPage adminPage;
	private ReservaPage reservaPage;
	
	@BeforeTest
	public void inicioClase() throws Exception {
		this.homePage = new HomePage(this.urlInicial);
		this.webDriver = homePage.getWebDriver();
		this.loguinPage = new LoguinPage(webDriver);
		this.adminPage = new AdminPage(webDriver);
		this.reservaPage = new ReservaPage(webDriver);
	}
	
	@Test(priority = 0)
	public void A_mostrarReserva_FlujoBasico() throws Exception {
		try {
			String valorEsperado = "Listado de Reservas";
			homePage.hacerClicLoguin();
			loguinPage.Loguin("admin@gmail.com", "password");
			adminPage.IrListarReserva();
			String valorObtenido = reservaPage.ListarReserva_FlujoBasico();
			Assert.assertEquals(valorObtenido, valorEsperado);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
