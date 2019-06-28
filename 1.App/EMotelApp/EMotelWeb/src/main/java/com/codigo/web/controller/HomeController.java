package com.codigo.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codigo.core.entity.Administrador;
import com.codigo.core.entity.Rol;
import com.codigo.core.services.AdministradorService;

@Controller
@ComponentScan(basePackages = {"com.codigo.core.services"})
@ComponentScan(basePackageClasses = {AdministradorService.class})
public class HomeController {
	@Autowired
	AdministradorService adminserv;
	
	@RequestMapping(value="/EMotelWeb", method = RequestMethod.GET )
	public String index() {
		
		return "index.html";
	}
	
	@RequestMapping(value="/EMotelWeb/usuario/registrar", method = RequestMethod.GET)
	public String registrar(Model model) {
		Administrador objAdministrador = new Administrador();
		model.addAttribute("administrador", objAdministrador);

		return "usuario_registrar.html";
	}
	
	@RequestMapping(value="/EMotelWeb/usuario/guardar", method=RequestMethod.POST)
	public String guardar(@ModelAttribute @Valid Administrador objAdministrador, 
			BindingResult bindResult,
			Model model, RedirectAttributes objRedir) 
	{
		Rol rol =new Rol();
		rol.setId(2);
		rol.setNombre("Cliente");
		objAdministrador.setRol(rol);
			boolean flag = adminserv.agregar(objAdministrador);
			if(flag) {
				objRedir.addFlashAttribute("mensaje", "Usuario guardado");
			}else {
				objRedir.addFlashAttribute("error", "Ocurrió un error");			
			}
			return "redirect:/EMotelWeb/login";
		
	}
	
	@RequestMapping(value="/EMotelWeb/usuario/iniciar_sesion", method = RequestMethod.POST)
	public String iniciar_sesion(@ModelAttribute @Valid Administrador objAdministrador, 
			BindingResult bindResult,
			Model model, RedirectAttributes objRedir) {
		Administrador aux= adminserv.buscarPorCorreo(objAdministrador.getCorreo(), objAdministrador.getPassword());
		
		if(aux == null) {
			objRedir.addFlashAttribute("error", "Correo o contraseña invalidos");			
			return "redirect:/EMotelWeb/login";
		}
		else {
			Rol rol = aux.getRol();
			if(rol.getId()==1)
				return "admin/dashboard.html";
			else {
				return "redirect:/EMotelWeb/hotel/listar/0";
			}
		}
	}
}
