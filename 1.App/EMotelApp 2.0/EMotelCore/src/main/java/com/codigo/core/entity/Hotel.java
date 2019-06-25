package com.codigo.core.entity;

import java.util.List;


public class Hotel {

	private int id;
	private String nombre;
	private double precio;
	private String ubicacion;
	private TipoHotel tipohotel;
	private Distrito distritos;
	private List<Reserva> reservas;

	public Hotel() {
		super();
	}
	
	public Hotel(int id) {
		super();
		this.id = id;
	}
	
	public TipoHotel getTipohotel() {
		return tipohotel;
	}

	public void setTipohotel(TipoHotel tipohotel) {
		this.tipohotel = tipohotel;
	}

	public Distrito getDistritos() {
		return distritos;
	}

	public void setDistritos(Distrito distritos) {
		this.distritos = distritos;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	
}
