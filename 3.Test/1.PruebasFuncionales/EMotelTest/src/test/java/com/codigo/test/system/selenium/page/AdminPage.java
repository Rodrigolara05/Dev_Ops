package com.codigo.test.system.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage {
	private WebDriver webDriver = null;
	private By linkRegistrarHotel = By.xpath("/html/body/div/div/div[1]/div/ul[1]/li[2]/a");
	private By linkSalir = By.xpath("/html/body/nav/div/div[1]/a");
	private By linkLitarHotel = By.xpath("/html/body/div/div/div[1]/div/ul[1]/li[3]/a");
	private By linkRegistrarRestaurante = By.xpath("/html/body/div/div/div[1]/div/ul[3]/li[2]/a");
	private By linkLitarRestaurante = By.xpath("/html/body/div/div/div[1]/div/ul[3]/li[3]/a");
	private By linkLitarReserva = By.xpath("/html/body/div/div/div[1]/div/ul[4]/li[2]/a");
	private By linkLitarCerrarSession = By.xpath("/html/body/nav/div/div[2]/ul/li[2]/a");
	
	public AdminPage(WebDriver webDriver) throws Exception{
		this.webDriver = webDriver;
	}
	
	public void IrRegistrarHotel() throws Exception{
		webDriver.findElement(linkRegistrarHotel).click();
		Thread.sleep(2000);
	}
	
	public void IrListarHotel() throws Exception{
		webDriver.findElement(linkLitarHotel).click();
		Thread.sleep(2000);
	}
	
	public void IrRegistrarRestaurante() throws Exception{
		webDriver.findElement(linkRegistrarRestaurante).click();
		Thread.sleep(2000);
	}
	
	public void IrListarRestaurante() throws Exception{
		webDriver.findElement(linkLitarRestaurante).click();
		Thread.sleep(2000);
	}
	
	public void IrListarReserva() throws Exception{
		webDriver.findElement(linkLitarReserva).click();
		Thread.sleep(2000);
	}
	
	public void CerrarSesion() throws Exception{
		webDriver.findElement(linkLitarCerrarSession).click();
		Thread.sleep(2000);
	}
	
	public void HomePage() throws Exception{
		webDriver.findElement(linkSalir).click();
		Thread.sleep(2000);
	}
}
