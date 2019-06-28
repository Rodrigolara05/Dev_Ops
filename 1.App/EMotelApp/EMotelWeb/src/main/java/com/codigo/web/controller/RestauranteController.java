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
import com.codigo.core.services.DistritoService;
import com.codigo.core.services.ProvinciaService;
import com.codigo.core.services.RestauranteService;

@Controller
public class RestauranteController {
	@Autowired
	RestauranteService restauranteserv;
	@Autowired
	DistritoService distritoserv;
	@Autowired
	ProvinciaService provinciaserv;
	
	@RequestMapping(value="/EMotelWeb/admin/restaurante/listar", method= RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("listado", restauranteserv.listar());
		return "admin/restaurante_listar.html";
	}
	
	@RequestMapping(value="/EMotelWeb/admin/restaurante/registrar", method = RequestMethod.GET)
	public String registrar(Model model) {
		Restaurante objRestaurante = new Restaurante();
		model.addAttribute("restaurante", objRestaurante);

		model.addAttribute("listado", distritoserv.listar());
		
		return "admin/restaurante_registrar.html";
	}
	
	@RequestMapping(value="/EMotelWeb/admin/restaurante/guardar", method=RequestMethod.POST)
	public String guardar(@ModelAttribute @Valid Restaurante objRestaurante, 
			BindingResult bindResult,
			Model model, RedirectAttributes objRedir) 
	{
			boolean flag = restauranteserv.agregar(objRestaurante);
			if(flag) {
				objRedir.addFlashAttribute("mensaje", "Restaurante guardado");
			}else {
				objRedir.addFlashAttribute("error", "Ocurrió un error");			
			}
			return "redirect:/EMotelWeb/admin/restaurante/listar";
		
	}
	@RequestMapping(value="/EMotelWeb/admin/restaurante/eliminar/{id}", method = RequestMethod.GET)
	public String eliminar(@PathVariable int id, RedirectAttributes objRedir) {
		boolean flag = restauranteserv.eliminar(id);
		
		if(flag) {
			objRedir.addFlashAttribute("mensaje", "Restaurante eliminado");
		}else {
			objRedir.addFlashAttribute("error", "Ocurrió un error");			
		}
		
		return "redirect:/EMotelWeb/admin/restaurante/listar";
	}
	
	@RequestMapping(value="/EMotelWeb/admin/restaurante/editar/{id}", method = RequestMethod.GET)
	public String editar(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Restaurante objRestaurante = restauranteserv.cargarRestaurante(id);
		
		if(objRestaurante == null) {
			objRedir.addFlashAttribute("error", "Restaurante no existe");
			return "redirect:/EMotelWeb/admin/restaurante/listar";
		}else {
			model.addAttribute("restaurante", objRestaurante);
			model.addAttribute("listado", distritoserv.listar());
			return "admin/restaurante_editar.html";
		}
		
	}
	@RequestMapping(value="/EMotelWeb/restaurante/listar/{id}", method= RequestMethod.GET)
	public String listar2(@PathVariable int id, Model model) {
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
