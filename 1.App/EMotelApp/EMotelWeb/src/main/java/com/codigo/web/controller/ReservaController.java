package com.codigo.web.controller;


import java.util.List;

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

import com.codigo.core.entity.Reserva;
import com.codigo.core.services.AdministradorService;
import com.codigo.core.services.HotelService;
import com.codigo.core.services.ReservaService;
import com.codigo.core.services.RestauranteService;

@Controller
public class ReservaController {

	@Autowired
	ReservaService reservaserv;
	@Autowired
	RestauranteService restauranteserv;
	@Autowired
	HotelService hotelserv;
	@Autowired
	AdministradorService admiserv;
	
	@RequestMapping(value="/EMotelWeb/admin/reserva/listar", method= RequestMethod.GET)
	public String listar(Model model) {
		Reserva objReserva = new Reserva();
		model.addAttribute("reserva", objReserva);
		model.addAttribute("listado1", hotelserv.listar());
		model.addAttribute("listado2", restauranteserv.listar());
		model.addAttribute("listado", reservaserv.listar());
		return "admin/reserva_listar.html";
	}
	
	@RequestMapping(value="/EMotelWeb/admin/reserva/hotel_restaurante/", method = RequestMethod.POST)
	public String listar_por_parametros(@ModelAttribute Reserva reserva ,Model model) {
		model.addAttribute("listado1", hotelserv.listar());
		model.addAttribute("listado2", restauranteserv.listar());
		List<Reserva> listado = reservaserv.buscarPorParametro(reserva.getHotel().getId(),
				reserva.getRestaurante().getId()); 
		Reserva objReserva = new Reserva();
		model.addAttribute("reserva", objReserva);
		model.addAttribute("listado",listado);
		return "admin/reserva_listar.html";
	}
	
	
	
	@RequestMapping(value="/EMotelWeb/reserva/listar", method= RequestMethod.GET)
	public String listar2(Model model) {
		model.addAttribute("listado", reservaserv.listar());
		return "reserva_lista.html";
	}
	@RequestMapping(value="/EMotelWeb/reserva/registrar", method= RequestMethod.GET)
	public String registrar(Model model) {
		Reserva obj= new Reserva();
		model.addAttribute("reserva", obj);
		model.addAttribute("listado1",restauranteserv.listar() );
		model.addAttribute("listado2", hotelserv.listar());
		model.addAttribute("listado3", admiserv.listar());
		return "reserva_registrar.html";
	}
	@RequestMapping(value="/EMotelWeb/reserva/guardar", method=RequestMethod.POST)
	public String guardar(@ModelAttribute @Valid Reserva obj, 
			BindingResult bindResult,
			Model model, RedirectAttributes objRedir) 
	{
			obj.setCostototal(obj.getDiasreserva()*(obj.getRestaurante().getPrecio()+obj.getHotel().getPrecio()));
			//obj.setFechareserva(Date.valueOf("15/12/2019"));

			boolean flag = reservaserv.agregar(obj);
			
			if(flag) {
				objRedir.addFlashAttribute("mensaje", "reserva guardada");
			}else {
				objRedir.addFlashAttribute("error", "Ocurrió un error");			
			}
			return "redirect:/EMotelWeb/reserva/listar";
	}

	@RequestMapping(value="/EMotelWeb/reserva/eliminar/{id}", method = RequestMethod.GET)
	public String eliminar(@PathVariable int id, RedirectAttributes objRedir) {
		boolean flag = reservaserv.eliminar(id);
		
		if(flag) {
			objRedir.addFlashAttribute("mensaje", "reserva eliminada");
		}else {
			objRedir.addFlashAttribute("error", "Ocurrió un error");			
		}
		
		return "redirect:/EMotelWeb/reserva/listar";
	}
	
	@RequestMapping(value="/EMotelWeb/reserva/editar/{id}", method = RequestMethod.GET)
	public String editar(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Reserva obj = reservaserv.cargarReserva(id);
		
		if(obj == null) {
			objRedir.addFlashAttribute("error", "reserva no existe");
			return "redirect:/EMotelWeb/reserva/listar";
		}else {
			model.addAttribute("reserva", obj);
			model.addAttribute("listado1",restauranteserv.listar() );
			model.addAttribute("listado2", hotelserv.listar());
			model.addAttribute("listado3", admiserv.listar());
			return "reserva_editar.html";
		}
		
	}
}
