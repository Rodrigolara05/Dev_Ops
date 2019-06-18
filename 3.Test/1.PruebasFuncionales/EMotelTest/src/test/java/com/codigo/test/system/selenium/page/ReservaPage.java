package com.codigo.test.system.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReservaPage {
	private WebDriver webDriver = null;
	private By titulo3 = By.id("TituloReservaListar");
	private By titulo2 = By.id("TituloReservaRegistrar");
	private By titulo = By.id("TituloReservaEditar");
	private By selectHotel = By.id("hotel");
	private By selectRestaurante = By.id("restaurante");
	private By selectAdministrador = By.id("administrador");
	private By fecha = By.id("fecha");
	private By numeroDias = By.id("dias");
	private By botonGuardarReserva = By.id("GuardarReserva");
	private By mensajeResultado = By.xpath("html/body/div/div/div[1]/div[1]/p");
	private By linkEliminarReserva = By.xpath("/html/body/div/div/div[1]/table/tbody/tr[1]/td[9]/a[2]");
	private By linkEditarReserva = By.xpath("/html/body/div/div/div[1]/table/tbody/tr[1]/td[9]/a[1]");
	
	public ReservaPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public String ListarReserva_FlujoBasico() throws Exception{
		Thread.sleep(2000);
		return webDriver.findElement(titulo3).getText();
	}
	
	public String RegistrarReserva_FlujoBasico() throws Exception{
		webDriver.findElement(selectRestaurante).getClass();
		webDriver.findElement(selectHotel).getClass();
		webDriver.findElement(selectAdministrador).getClass();
		webDriver.findElement(fecha).click();
		webDriver.findElement(numeroDias).clear();
		webDriver.findElement(numeroDias).sendKeys("2");
		
		webDriver.findElement(botonGuardarReserva).click();
		Thread.sleep(2000);
		return webDriver.findElement(mensajeResultado).getText();
	}
	
	public String RegistrarReserva_FlujoAlternativo() throws Exception{
		webDriver.findElement(selectRestaurante).getClass();
		webDriver.findElement(selectHotel).getClass();
		webDriver.findElement(selectAdministrador).getClass();
		webDriver.findElement(fecha).click();
		webDriver.findElement(numeroDias).clear();
		webDriver.findElement(numeroDias).sendKeys("-1");
		
		webDriver.findElement(botonGuardarReserva).click();
		Thread.sleep(2000);
		return webDriver.findElement(titulo2).getText();
	}
	
	public String ActualizarReserva_FlujoBasico() throws Exception{
		webDriver.findElement(linkEditarReserva).click();
		webDriver.findElement(selectRestaurante).getClass();
		webDriver.findElement(selectHotel).getClass();
		webDriver.findElement(selectAdministrador).getClass();
		webDriver.findElement(fecha).click();
		webDriver.findElement(numeroDias).clear();
		webDriver.findElement(numeroDias).sendKeys("15");
		
		webDriver.findElement(botonGuardarReserva).click();
		Thread.sleep(2000);
		return webDriver.findElement(mensajeResultado).getText();
	}
	
	public String ActualizarReserva_FlujoAlternativo() throws Exception{
		webDriver.findElement(linkEditarReserva).click();
		webDriver.findElement(selectRestaurante).getClass();
		webDriver.findElement(selectHotel).getClass();
		webDriver.findElement(selectAdministrador).getClass();
		webDriver.findElement(fecha).click();
		webDriver.findElement(numeroDias).clear();
		webDriver.findElement(numeroDias).sendKeys("-10");
		
		webDriver.findElement(botonGuardarReserva).click();
		Thread.sleep(2000);
		return webDriver.findElement(titulo).getText();
	}
	

	public String EliminarReserva_FlujoBasico() throws Exception{
		webDriver.findElement(linkEliminarReserva).click();
		Thread.sleep(2000);
		return webDriver.findElement(mensajeResultado).getText();
	}
}
