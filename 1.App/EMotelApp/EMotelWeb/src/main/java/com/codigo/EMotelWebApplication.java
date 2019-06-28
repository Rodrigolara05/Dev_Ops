package com.codigo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import com.codigo.core.services.AdministradorService;
@SpringBootApplication
@ComponentScan(basePackageClasses = {AdministradorService.class})
public class EMotelWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(EMotelWebApplication.class, args);
	}

}
