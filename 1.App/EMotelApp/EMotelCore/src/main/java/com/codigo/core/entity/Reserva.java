package com.codigo.core.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import java.util.Date;

import javax.persistence.Entity;

@Entity
@Table(name="reserva")
@NamedQueries({
	@NamedQuery(name="Reserva.buscarPorParametro", 
					query="select a from Reserva a where a.hotel.id = ?1 and a.restaurante.id = ?2"),	
})
public class Reserva {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@NotNull
	private Restaurante restaurante;
	
	@ManyToOne
	@NotNull
	private Hotel hotel;
	
	@ManyToOne
	@NotNull
	private Administrador administrador;
	
	@Min(value=1)

	private int diasreserva;

	private double costototal;
	
	private Date fechareserva;
	
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
