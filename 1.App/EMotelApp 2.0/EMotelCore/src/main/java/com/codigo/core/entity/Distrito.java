package com.codigo.core.entity;

import java.util.List;


public class Distrito {

	private int id;
	private String nombre;
	private Provincia provincia;
	private List<Hotel> hoteles;
	private List<Restaurante> restaurantes;
	
	public Distrito() {
		super();
	}
	
	public Distrito(int id) {
		super();
		this.id = id;
	}
	
	
	public Provincia getProvincia() {
		return provincia;
	}
	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
	public int getId() {
		return id;
	}
	public List<Hotel> getHoteles() {
		return hoteles;
	}
	public void setHoteles(List<Hotel> hoteles) {
		this.hoteles = hoteles;
	}
	public List<Restaurante> getRestaurantes() {
		return restaurantes;
	}
	public void setRestaurantes(List<Restaurante> restaurantes) {
		this.restaurantes = restaurantes;
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
}
