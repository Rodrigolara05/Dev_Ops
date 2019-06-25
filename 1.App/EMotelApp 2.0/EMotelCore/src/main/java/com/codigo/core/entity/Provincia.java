package com.codigo.core.entity;

import java.util.List;



public class Provincia {
	private int id;
	private String nombre;
	private List<Distrito> distritos;
	
	public Provincia() {
		super();
	}
	
	public Provincia(int id) {
		super();
		this.id = id;
	}
	
	public List<Distrito> getDistritos() {
		return distritos;
	}
	public void setDistritos(List<Distrito> distritos) {
		this.distritos = distritos;
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
	
	
}
