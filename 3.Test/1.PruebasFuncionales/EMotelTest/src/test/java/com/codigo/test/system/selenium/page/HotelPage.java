package com.codigo.test.system.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HotelPage {
	private WebDriver webDriver = null;
	private By textNombre = By.id("HotelNombre");
	private By textPrecio = By.id("HotelPrecio");
	private By textUbicacion = By.id("HotelUbicacion");
	private By selectTipoHotel = By.id("HotelTipoHotel");
	private By selectDistrito = By.id("HotelDistrito");
	private By mensajeResultado = By.xpath("/html/body/div/div/div[2]/div/p");
	private By titulo = By.id("TituloHotelRegistrar");
	private By titulo2 = By.id("TituloHotelEditar");
	private By titulo3 = By.id("TituloHotelListar");
	private By botonGuardarHotel = By.id("GuardarHotel");
	private By linkEditar = By.xpath("/html/body/div/div/div[2]/table/tbody/tr[1]/td[6]/a[1]");
	private By linkEliminar = By.xpath("/html/body/div/div/div[2]/table/tbody/tr[1]/td[6]/a[2]");
	
	public HotelPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public String RegistrarHotel_FlujoBasico() throws Exception{
		webDriver.findElement(textNombre).clear();
		webDriver.findElement(textNombre).sendKeys("A Mi hotel");
		webDriver.findElement(textPrecio).clear();
		webDriver.findElement(textPrecio).sendKeys("50.0");
		webDriver.findElement(textUbicacion).clear();
		webDriver.findElement(textUbicacion).sendKeys("Av. San Marcos 149");
		webDriver.findElement(selectTipoHotel).getClass();
		webDriver.findElement(selectDistrito).getClass();
		webDriver.findElement(botonGuardarHotel).click();
		Thread.sleep(2000);
		return webDriver.findElement(mensajeResultado).getText();
	}
	
	public String RegistrarHotel_FlujoAlternativo() throws Exception{
		webDriver.findElement(textNombre).clear();
		webDriver.findElement(textNombre).sendKeys("");
		webDriver.findElement(textPrecio).clear();
		webDriver.findElement(textPrecio).sendKeys("");
		webDriver.findElement(textUbicacion).clear();
		webDriver.findElement(textUbicacion).sendKeys("");
		webDriver.findElement(selectTipoHotel).getClass();
		webDriver.findElement(selectDistrito).getClass();
		webDriver.findElement(botonGuardarHotel).click();
		Thread.sleep(2000);
		return webDriver.findElement(titulo).getText();
	}
	
	public String ActualizarHotel_FlujoBasico() throws Exception{
		webDriver.findElement(linkEditar).click();
		webDriver.findElement(textNombre).clear();
		webDriver.findElement(textNombre).sendKeys("A Mi hotel2");
		webDriver.findElement(textPrecio).clear();
		webDriver.findElement(textPrecio).sendKeys("50.0");
		webDriver.findElement(textUbicacion).clear();
		webDriver.findElement(textUbicacion).sendKeys("Av. San Marcos 150");
		webDriver.findElement(selectTipoHotel).getClass();
		webDriver.findElement(selectDistrito).getClass();
		webDriver.findElement(botonGuardarHotel).click();
		Thread.sleep(2000);
		return webDriver.findElement(mensajeResultado).getText();
	}
	
	public String ActualizarHotel_FlujoAlternativo() throws Exception{
		webDriver.findElement(linkEditar).click();
		webDriver.findElement(textNombre).clear();
		webDriver.findElement(textNombre).sendKeys("");
		webDriver.findElement(textPrecio).clear();
		webDriver.findElement(textPrecio).sendKeys("");
		webDriver.findElement(textUbicacion).clear();
		webDriver.findElement(textUbicacion).sendKeys("");
		webDriver.findElement(selectTipoHotel).getClass();
		webDriver.findElement(selectDistrito).getClass();
		webDriver.findElement(botonGuardarHotel).click();
		Thread.sleep(2000);
		return webDriver.findElement(titulo2).getText();
	}
	
	public String ListarHotel_FlujoBasico() throws Exception{
		Thread.sleep(2000);
		return webDriver.findElement(titulo3).getText();
	}
	
	public String EliminarHotel_FlujoBasico() throws Exception{
		webDriver.findElement(linkEliminar).click();
		Thread.sleep(2000);
		return webDriver.findElement(mensajeResultado).getText();
	}
}
