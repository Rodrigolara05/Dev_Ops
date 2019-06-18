package com.codigo.test.system.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoguinPage {
	private WebDriver webDriver = null;
	private By textCorreo = By.id("first-name");
	private By textoPassword = By.id("contra");
	private By botonLoguin = By.id("boton");
	
	public LoguinPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public void Loguin(String correo, String password) throws Exception{
		webDriver.findElement(textCorreo).clear();
		webDriver.findElement(textCorreo).sendKeys(correo);
		webDriver.findElement(textoPassword).clear();
		webDriver.findElement(textoPassword).sendKeys(password);
		webDriver.findElement(botonLoguin).click();
		Thread.sleep(2000);
	}
}
