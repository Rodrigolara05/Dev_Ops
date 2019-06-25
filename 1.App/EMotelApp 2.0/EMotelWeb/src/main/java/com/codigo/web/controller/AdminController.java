package com.codigo.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codigo.core.entity.Administrador;
import com.codigo.core.service.AdministradorServices;




@Controller
public class AdminController {

@Autowired
	AdministradorServices adminserv = new AdministradorServices();
	
	@RequestMapping(value="/admin/dashboard", method=RequestMethod.GET)
	public String dashboard() {
		
		return "admin/dashboard.html";
	}
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model) {
		Administrador objAdministrador=new Administrador();
		model.addAttribute("administrador",objAdministrador);
		return "iniciar_sesion.html";
	}
	
}
