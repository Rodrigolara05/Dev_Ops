package com.codigo.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codigo.core.entity.Administrador;
import com.codigo.core.entity.Rol;
import com.codigo.core.service.AdministradorServices;
@Controller
public class HomeController {
	@Autowired
	AdministradorServices adminserv = new AdministradorServices();
	
	@RequestMapping(value="/", method = RequestMethod.GET )
	public String index() {
		
		return "index.html";
	}
	
	@RequestMapping(value="/usuario/registrar", method = RequestMethod.GET)
	public String registrar(Model model) {
		Administrador objAdministrador = new Administrador();
		model.addAttribute("administrador", objAdministrador);

		return "usuario_registrar.html";
	}
	
	@RequestMapping(value="/usuario/guardar", method=RequestMethod.POST)
	public String guardar(@ModelAttribute @Valid Administrador objAdministrador, 
			BindingResult bindResult,
			Model model, RedirectAttributes objRedir) throws Exception 
	{
		Rol rol =new Rol();
		rol.setId(2);
		rol.setNombre("Cliente");
		objAdministrador.setRol(rol);
			boolean flag = adminserv.insertar(objAdministrador);
			if(flag) {
				objRedir.addFlashAttribute("mensaje", "Usuario guardado");
			}else {
				objRedir.addFlashAttribute("error", "Ocurrió un error");			
			}
			return "redirect:/login";
		
	}
	
	@RequestMapping(value="/usuario/iniciar_sesion", method = RequestMethod.POST)
	public String iniciar_sesion(@ModelAttribute @Valid Administrador objAdministrador, 
			BindingResult bindResult,
			Model model, RedirectAttributes objRedir) throws Exception {
		Administrador aux= adminserv.buscarPorCorreo(objAdministrador.getCorreo(), objAdministrador.getPassword());
		
		if(aux == null) {
			objRedir.addFlashAttribute("error", "Correo o contraseña invalidos");			
			return "redirect:/login";
		}
		else {
			Rol rol = aux.getRol();
			if(rol.getId()==1)
				return "admin/dashboard.html";
			else {
				return "redirect:/hotel/listar/0";
			}
		}
	}
}
