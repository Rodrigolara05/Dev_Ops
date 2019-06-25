package com.codigo.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codigo.core.entity.Restaurante;
import com.codigo.core.service.DistritoServices;
import com.codigo.core.service.ProvinciaServices;
import com.codigo.core.service.RestauranteServices;

@Controller
public class RestauranteController {
	@Autowired
	RestauranteServices restauranteserv = new RestauranteServices();
	@Autowired
	DistritoServices distritoserv = new DistritoServices();
	@Autowired
	ProvinciaServices provinciaserv = new ProvinciaServices();
	
	@RequestMapping(value="/admin/restaurante/listar", method= RequestMethod.GET)
	public String listar(Model model) throws Exception {
		model.addAttribute("listado", restauranteserv.listar());
		return "admin/restaurante_listar.html";
	}
	
	@RequestMapping(value="/admin/restaurante/registrar", method = RequestMethod.GET)
	public String registrar(Model model) throws Exception {
		Restaurante objRestaurante = new Restaurante();
		model.addAttribute("restaurante", objRestaurante);

		model.addAttribute("listado", distritoserv.listar());
		
		return "admin/restaurante_registrar.html";
	}
	
	@RequestMapping(value="/admin/restaurante/guardar", method=RequestMethod.POST)
	public String guardar(@ModelAttribute @Valid Restaurante objRestaurante, 
			BindingResult bindResult,
			Model model, RedirectAttributes objRedir) throws Exception 
	{
			boolean flag = restauranteserv.insertar(objRestaurante);
			if(flag) {
				objRedir.addFlashAttribute("mensaje", "Restaurante guardado");
			}else {
				objRedir.addFlashAttribute("error", "Ocurrió un error");			
			}
			return "redirect:/admin/restaurante/listar";
		
	}
	@RequestMapping(value="/admin/restaurante/eliminar/{id}", method = RequestMethod.GET)
	public String eliminar(@PathVariable int id, RedirectAttributes objRedir) throws Exception {
		boolean flag = restauranteserv.eliminar(id);
		
		if(flag) {
			objRedir.addFlashAttribute("mensaje", "Restaurante eliminado");
		}else {
			objRedir.addFlashAttribute("error", "Ocurrió un error");			
		}
		
		return "redirect:/admin/restaurante/listar";
	}
	
	@RequestMapping(value="/admin/restaurante/editar/{id}", method = RequestMethod.GET)
	public String editar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws Exception {
		Restaurante objRestaurante = restauranteserv.obtener(id);
		
		if(objRestaurante == null) {
			objRedir.addFlashAttribute("error", "Restaurante no existe");
			return "redirect:/admin/restaurante/listar";
		}else {
			model.addAttribute("restaurante", objRestaurante);
			model.addAttribute("listado", distritoserv.listar());
			return "admin/restaurante_editar.html";
		}
		
	}
	@RequestMapping(value="/restaurante/listar/{id}", method= RequestMethod.GET)
	public String listar2(@PathVariable int id, Model model) throws Exception {
		if (id==0) {
			model.addAttribute("listado", restauranteserv.listar());
		}else {
			model.addAttribute("listado", restauranteserv.RestaurantePorDistrito(id));
		}
		model.addAttribute("provincias", provinciaserv.listar());
		model.addAttribute("distritos", distritoserv.listar());
		
		return "restaurante_lista.html";
	}
}
