package com.codigo.test.system.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserPage {
	private WebDriver webDriver = null;
	private By linkRegistrarReserva = By.xpath("/html/body/div/div/div[2]/ul[3]/li[3]/a");
	private By linkListarReserva = By.xpath("/html/body/div/div/div[2]/ul[3]/li[2]/a");
	private By linkEliminarReserva = By.xpath("/html/body/div/div/div[1]/table/tbody/tr[1]/td[9]/a[2]");
	private By linkEditarReserva = By.xpath("/html/body/div/div/div[1]/table/tbody/tr[1]/td[9]/a[1]");
	
	public UserPage(WebDriver webDriver) throws Exception{
		this.webDriver = webDriver;
	}
	
	public void IrRegistrarReserva() throws Exception{
		webDriver.findElement(linkRegistrarReserva).click();
		Thread.sleep(2000);
	}
	
	public void IrEditarReserva() throws Exception{
		webDriver.findElement(linkEditarReserva).click();
		Thread.sleep(2000);
	}
	
	public void IrListarReserva() throws Exception{
		webDriver.findElement(linkListarReserva).click();
		Thread.sleep(2000);
	}
	
	public void IrEliminrarReserva() throws Exception{
		webDriver.findElement(linkEliminarReserva).click();
		Thread.sleep(2000);
	}
}
