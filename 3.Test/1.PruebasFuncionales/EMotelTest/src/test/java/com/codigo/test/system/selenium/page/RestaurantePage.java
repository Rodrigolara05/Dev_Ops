package com.codigo.test.system.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RestaurantePage {
	private WebDriver webDriver = null;
	private By textNombre = By.id("RestauranteNombre");
	private By textPrecio = By.id("RestaurantePrecio");
	private By textDescripcion = By.id("RestauranteDescripcion");
	private By textUbicacion = By.id("RestauranteUbicacion");
	private By selectDistrito = By.id("RestauranteDistrito");
	private By mensajeResultado = By.xpath("/html/body/div/div/div[2]/div/p");
	private By titulo = By.id("TituloRestauranteRegistrar");
	private By titulo2 = By.id("TituloRestauranteEditar");
	private By titulo3 = By.id("TituloRestauranteListar");
	private By botonGuardarRestaurante = By.id("GuardarRestaurante");
	private By linkEditar = By.xpath("/html/body/div/div/div[2]/table/tbody/tr/td[6]/a[1]");
	private By linkEliminar = By.xpath("/html/body/div/div/div[2]/table/tbody/tr/td[6]/a[2]");
	
	public RestaurantePage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public String RegistrarRestaurante_FlujoBasico() throws Exception{
		webDriver.findElement(textNombre).clear();
		webDriver.findElement(textNombre).sendKeys("Mi restaurante");
		webDriver.findElement(textPrecio).clear();
		webDriver.findElement(textPrecio).sendKeys("120.0");
		webDriver.findElement(textDescripcion).clear();
		webDriver.findElement(textDescripcion).sendKeys("Nuevo restaurante");
		webDriver.findElement(textUbicacion).clear();
		webDriver.findElement(textUbicacion).sendKeys("Av. San Marcos 149");
		webDriver.findElement(selectDistrito).getClass();
		webDriver.findElement(botonGuardarRestaurante).click();
		Thread.sleep(2000);
		return webDriver.findElement(mensajeResultado).getText();
	}
	
	public String RegistrarRestaurante_FlujoAlternativo() throws Exception{
		webDriver.findElement(textNombre).clear();
		webDriver.findElement(textNombre).sendKeys("");
		webDriver.findElement(textPrecio).clear();
		webDriver.findElement(textPrecio).sendKeys("");
		webDriver.findElement(textDescripcion).clear();
		webDriver.findElement(textDescripcion).sendKeys("");
		webDriver.findElement(textUbicacion).clear();
		webDriver.findElement(textUbicacion).sendKeys("");
		webDriver.findElement(selectDistrito).getClass();
		webDriver.findElement(botonGuardarRestaurante).click();
		Thread.sleep(2000);
		return webDriver.findElement(titulo).getText();
	}
	
	public String ListarRestaurante_FlujoBasico() throws Exception{
		Thread.sleep(2000);
		return webDriver.findElement(titulo3).getText();
	}
	
	public String ActualizarRestaurante_FlujoBasico() throws Exception{
		Thread.sleep(5000);
		webDriver.findElement(linkEditar).click();
		webDriver.findElement(textNombre).clear();
		webDriver.findElement(textNombre).sendKeys("Mi restaurante 2");
		webDriver.findElement(textPrecio).clear();
		webDriver.findElement(textPrecio).sendKeys("120.0");
		webDriver.findElement(textDescripcion).clear();
		webDriver.findElement(textDescripcion).sendKeys("Nuevo restaurante 2");
		webDriver.findElement(textUbicacion).clear();
		webDriver.findElement(textUbicacion).sendKeys("Av. Alameda sur");
		webDriver.findElement(selectDistrito).getClass();
		webDriver.findElement(botonGuardarRestaurante).click();
		Thread.sleep(2000);
		return webDriver.findElement(mensajeResultado).getText();
	}
	
	public String ActualizarRestaurante_FlujoAlternativo() throws Exception{
		webDriver.findElement(linkEditar).click();
		webDriver.findElement(textNombre).clear();
		webDriver.findElement(textNombre).sendKeys("");
		webDriver.findElement(textPrecio).clear();
		webDriver.findElement(textPrecio).sendKeys("");
		webDriver.findElement(textDescripcion).clear();
		webDriver.findElement(textDescripcion).sendKeys("");
		webDriver.findElement(textUbicacion).clear();
		webDriver.findElement(textUbicacion).sendKeys("");
		webDriver.findElement(selectDistrito).getClass();
		webDriver.findElement(botonGuardarRestaurante).click();
		Thread.sleep(2000);
		return webDriver.findElement(titulo2).getText();
	}
	
	public String EliminarRestaurante_FlujoBasico() throws Exception{
		webDriver.findElement(linkEliminar).click();
		Thread.sleep(2000);
		return webDriver.findElement(mensajeResultado).getText();
	}
}
