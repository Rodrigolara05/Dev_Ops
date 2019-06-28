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
import com.codigo.core.services.DistritoService;
import com.codigo.core.services.HotelService;
import com.codigo.core.services.ProvinciaService;
import com.codigo.core.services.TipoHotelService;

@Controller
public class HotelController {

	@Autowired
	HotelService hotelserv;
	@Autowired
	TipoHotelService tipohotelserv;
	@Autowired
	DistritoService distritoserv;
	@Autowired
	ProvinciaService provinciaserv;
	
	@RequestMapping(value="/EMotelWeb/admin/hotel/listar", method= RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("listado", hotelserv.listar());
		return "admin/hotel_listar.html";
	}
	
	@RequestMapping(value="/EMotelWeb/admin/hotel/registrar", method = RequestMethod.GET)
	public String registrar(Model model) {
		Hotel objHotel = new Hotel();
		model.addAttribute("hotel", objHotel);

		model.addAttribute("listado1", tipohotelserv.listar());
		model.addAttribute("listado2", distritoserv.listar());
		
		return "admin/hotel_registrar.html";
	}
	
	@RequestMapping(value="/EMotelWeb/admin/hotel/guardar", method=RequestMethod.POST)
	public String guardar(@ModelAttribute @Valid Hotel objHotel, 
			BindingResult bindResult,
			Model model, RedirectAttributes objRedir) 
	{
		
		boolean flag = hotelserv.agregar(objHotel);
		if(flag) {
				objRedir.addFlashAttribute("mensaje", "Hotel guardado");
		}else {
			objRedir.addFlashAttribute("error", "Ocurrió un error");			
		}
		return "redirect:/EMotelWeb/admin/hotel/listar";
	}
	@RequestMapping(value="/EMotelWeb/admin/hotel/eliminar/{id}", method = RequestMethod.GET)
	public String eliminar(@PathVariable int id, RedirectAttributes objRedir) {
		boolean flag = hotelserv.eliminar(id);
		
		if(flag) {
			objRedir.addFlashAttribute("mensaje", "Hotel eliminado");
		}else {
			objRedir.addFlashAttribute("error", "Ocurrió un error");			
		}
		
		return "redirect:/EMotelWeb/admin/hotel/listar";
	}
	
	@RequestMapping(value="/EMotelWeb/admin/hotel/editar/{id}", method = RequestMethod.GET)
	public String editar(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Hotel objHotel = hotelserv.cargarHotel(id);
		
		if(objHotel == null) {
			objRedir.addFlashAttribute("error", "Hotel no existe");
			return "redirect:/EMotelWeb/admin/hotel/listar";
		}else {
			model.addAttribute("hotel", objHotel);
			model.addAttribute("listado1", tipohotelserv.listar());
			model.addAttribute("listado2", distritoserv.listar());
			return "admin/hotel_editar.html";
		}
		
	}
	
	@RequestMapping(value="/EMotelWeb/hotel/listar/{id}", method= RequestMethod.GET)
	public String listar2(@PathVariable int id, Model model) {
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
