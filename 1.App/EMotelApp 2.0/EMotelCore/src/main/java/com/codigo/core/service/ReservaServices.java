package com.codigo.core.service;

import java.util.List;

import com.codigo.core.entity.Reserva;
import com.codigo.core.repository.ReservaRepository;

public class ReservaServices {

	private final ReservaRepository reservaDao = new ReservaRepository();
	
	public boolean insertar(Reserva reserva) throws Exception{
		return this.reservaDao.insertar(reserva);
	}
	
	public void actualizar(Reserva reserva) throws Exception{
		this.reservaDao.actualizar(reserva);
	}
	
	public boolean eliminar(int reserva) throws Exception{
		return this.reservaDao.eliminar(reserva);
	}
	
	public Reserva obtener(int idProducto)throws Exception{
		return this.reservaDao.obtener(new Reserva(idProducto));
	}
	
	public List<Reserva> listar() throws Exception{
		return this.reservaDao.listar();
	}

	public List<Reserva> buscarPorParametro(int id, int id2) {
		return this.reservaDao.buscarPorParametro(id, id2);
	}
	
}
