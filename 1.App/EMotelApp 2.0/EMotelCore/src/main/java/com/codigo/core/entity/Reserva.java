package com.codigo.core.entity;

import java.util.Date;

public class Reserva {
	private int id;
	private Restaurante restaurante;
	private Hotel hotel;
	private Administrador administrador;
	private int diasreserva;

	private double costototal;
	
	private Date fechareserva;
	
	public Reserva() {
		super();
	}
	
	public Reserva(int id) {
		super();
		this.id = id;
	}
	
	public int getDiasreserva() {
		return diasreserva;
	}

	public void setDiasreserva(int diasreserva) {
		this.diasreserva = diasreserva;
	}

	public double getCostototal() {
		return costototal;
	}

	public void setCostototal(double costototal) {
		this.costototal = costototal;
	}

	public Date getFechareserva() {
		return fechareserva;
	}

	public void setFechareserva(Date fechareserva) {
		this.fechareserva = fechareserva;
	}
	
	public Restaurante getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}


	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
