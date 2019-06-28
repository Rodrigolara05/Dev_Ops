package com.codigo;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import com.codigo.core.services.AdministradorService;

@ComponentScan("com.codigo.core.services")
@ComponentScan(basePackageClasses = {AdministradorService.class})
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(EMotelWebApplication.class);
	}

}
