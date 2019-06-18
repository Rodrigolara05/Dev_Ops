package com.codigo.core.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codigo.core.entity.Reserva;

@Service
public interface IReservaService {

	public boolean agregar(Reserva reserva);
	public List<Reserva> listar();
	public boolean eliminar(int id);
	public Reserva cargarReserva(int id);
	public List<Reserva> buscarPorParametro(int hotel,int restaurante);
}
