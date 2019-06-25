package com.codigo.core.entity;

import java.util.List;


public class Rol {
	private int id;
	private String nombre;
	private List<Administrador> administrador;

	public Rol() {
		super();
	}
	
	public Rol(int id) {
		super();
		this.id = id;
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

	public List<Administrador> getAdministrador() {
		return administrador;
	}

	public void setAdministrador(List<Administrador> administrador) {
		this.administrador = administrador;
	}
	
	
}
