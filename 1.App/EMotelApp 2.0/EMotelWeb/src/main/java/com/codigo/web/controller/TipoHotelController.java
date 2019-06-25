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

import com.codigo.core.entity.TipoHotel;
import com.codigo.core.service.TipoHotelServices;
@Controller
public class TipoHotelController {
	@Autowired
	TipoHotelServices tipohotelserv = new TipoHotelServices();
	
	@RequestMapping(value="/admin/tipohotel/listar", method= RequestMethod.GET)
	public String listar(Model model) throws Exception {
		model.addAttribute("listado", tipohotelserv.listar());
		return "admin/tipohotel_listar.html";
	}
	
	@RequestMapping(value="/admin/tipohotel/registrar", method = RequestMethod.GET)
	public String registrar(Model model) {
		TipoHotel objTipoHotel = new TipoHotel();
		model.addAttribute("tipohotel", objTipoHotel);
		return "admin/tipohotel_registrar.html";
	}
	
	@RequestMapping(value="/admin/tipohotel/guardar", method=RequestMethod.POST)
	public String guardar(@ModelAttribute @Valid TipoHotel objTipoHotel, 
			BindingResult bindResult,
			Model model, RedirectAttributes objRedir) throws Exception 
	{
			boolean flag = tipohotelserv.insertar(objTipoHotel);
			if(flag) {
				objRedir.addFlashAttribute("mensaje", "Tipo Hotel guardado");
			}else {
				objRedir.addFlashAttribute("error", "Ocurrió un error");			
			}
			return "redirect:/admin/tipohotel/listar";
		
	}
	@RequestMapping(value="/admin/tipohotel/eliminar/{id}", method = RequestMethod.GET)
	public String eliminar(@PathVariable int id, RedirectAttributes objRedir) throws Exception {
		boolean flag = tipohotelserv.eliminar(id);
		
		if(flag) {
			objRedir.addFlashAttribute("mensaje", "Tipo Hotel eliminado");
		}else {
			objRedir.addFlashAttribute("error", "Ocurrió un error");			
		}
		
		return "redirect:/admin/tipohotel/listar";
	}
	
	@RequestMapping(value="/admin/tipohotel/editar/{id}", method = RequestMethod.GET)
	public String editar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws Exception {
		TipoHotel objHotel = tipohotelserv.obtener(id);
		
		if(objHotel == null) {
			objRedir.addFlashAttribute("error", "Tipo Hotel no existe");
			return "redirect:/admin/tipohotel/listar";
		}else {
			model.addAttribute("tipohotel", objHotel);
			return "admin/tipohotel_editar.html";
		}
		
	}
}
