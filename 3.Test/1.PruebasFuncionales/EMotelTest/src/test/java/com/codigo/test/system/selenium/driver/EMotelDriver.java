package com.codigo.test.system.selenium.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public final class EMotelDriver {
	
	public final static WebDriver inicializarDriver(String navegador) {
		WebDriver webDriver = null;
		try {
			switch (navegador) {
			case "firefox":
				System.setProperty("webdriver.gecko.driver", "E:\\Drivers\\geckodriver.exe");
				webDriver = new FirefoxDriver();
				break;
			case "chrome":
				System.setProperty("webdriver.chrome.driver", "E:\\Drivers\\chromedriver.exe");
				webDriver = new ChromeDriver();
				break;
			}
			webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return webDriver;
	}

	public final static void cerrarPagina(WebDriver webDriver) {
		if (webDriver != null) {
			webDriver.quit();
		}
	}
}
