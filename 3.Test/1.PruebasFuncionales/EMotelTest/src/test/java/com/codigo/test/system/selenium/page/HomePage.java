package com.codigo.test.system.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.codigo.test.system.selenium.driver.EMotelDriver;

public class HomePage {
	private By linkLoguin = By.id("IniciarSesion");
	private By linkInicio = By.id("Home");
	private By linkRegistrarse = By.id("Registrarse");
	private WebDriver webDriver = null;
	private String url = "";
	
	public HomePage(String url) {
		this.webDriver = EMotelDriver.inicializarDriver("chrome");
		this.url = url;
	}
	
	public void hacerClicLoguin() throws Exception{
		webDriver.get(url);
		webDriver.findElement(linkLoguin).click();
		Thread.sleep(2000);
	}
	
	public void hacerClicInicio() throws Exception{
		webDriver.get(url);
		webDriver.findElement(linkInicio).click();
		Thread.sleep(2000);
	}
	
	public void hacerClicRegistrarse() throws Exception{
		webDriver.get(url);
		webDriver.findElement(linkRegistrarse).click();
		Thread.sleep(2000);
	}
	
	public WebDriver getWebDriver() {
		return webDriver;
	}
}
