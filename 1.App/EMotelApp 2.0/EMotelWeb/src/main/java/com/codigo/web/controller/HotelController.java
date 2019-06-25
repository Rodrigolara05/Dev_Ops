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

import com.codigo.core.entity.Hotel;
import com.codigo.core.service.DistritoServices;
import com.codigo.core.service.HotelServices;
import com.codigo.core.service.ProvinciaServices;
import com.codigo.core.service.TipoHotelServices;

@Controller
public class HotelController {
	@Autowired
	HotelServices hotelserv = new HotelServices();
	@Autowired
	TipoHotelServices tipohotelserv = new TipoHotelServices();
	@Autowired
	DistritoServices distritoserv = new DistritoServices();
	@Autowired
	ProvinciaServices provinciaserv = new ProvinciaServices();
	
	@RequestMapping(value="/admin/hotel/listar", method= RequestMethod.GET)
	public String listar(Model model) throws Exception {
		model.addAttribute("listado", hotelserv.listar());
		return "admin/hotel_listar.html";
	}
	
	@RequestMapping(value="/admin/hotel/registrar", method = RequestMethod.GET)
	public String registrar(Model model) throws Exception {
		Hotel objHotel = new Hotel();
		model.addAttribute("hotel", objHotel);

		model.addAttribute("listado1", tipohotelserv.listar());
		model.addAttribute("listado2", distritoserv.listar());
		
		return "admin/hotel_registrar.html";
	}
	
	@RequestMapping(value="/admin/hotel/guardar", method=RequestMethod.POST)
	public String guardar(@ModelAttribute @Valid Hotel objHotel, 
			BindingResult bindResult,
			Model model, RedirectAttributes objRedir) throws Exception 
	{
		
		boolean flag = hotelserv.insertar(objHotel);
		if(flag) {
				objRedir.addFlashAttribute("mensaje", "Hotel guardado");
		}else {
			objRedir.addFlashAttribute("error", "Ocurrió un error");			
		}
		return "redirect:/admin/hotel/listar";
	}
	@RequestMapping(value="/admin/hotel/eliminar/{id}", method = RequestMethod.GET)
	public String eliminar(@PathVariable int id, RedirectAttributes objRedir) throws Exception {
		boolean flag = hotelserv.eliminar(id);
		
		if(flag) {
			objRedir.addFlashAttribute("mensaje", "Hotel eliminado");
		}else {
			objRedir.addFlashAttribute("error", "Ocurrió un error");			
		}
		
		return "redirect:/admin/hotel/listar";
	}
	
	@RequestMapping(value="/admin/hotel/editar/{id}", method = RequestMethod.GET)
	public String editar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws Exception {
		Hotel objHotel = hotelserv.obtener(id);
		
		if(objHotel == null) {
			objRedir.addFlashAttribute("error", "Hotel no existe");
			return "redirect:/admin/hotel/listar";
		}else {
			model.addAttribute("hotel", objHotel);
			model.addAttribute("listado1", tipohotelserv.listar());
			model.addAttribute("listado2", distritoserv.listar());
			return "admin/hotel_editar.html";
		}
		
	}
	
	@RequestMapping(value="/hotel/listar/{id}", method= RequestMethod.GET)
	public String listar2(@PathVariable int id, Model model) throws Exception {
		if (id==0) {
			model.addAttribute("listado", hotelserv.listar());
		}else {
			model.addAttribute("listado", hotelserv.HotelPorDistrito(id));
		}
		
		model.addAttribute("provincias", provinciaserv.listar());
		model.addAttribute("distritos", distritoserv.listar());

		
		return "hotel_lista.html";
	}
}
