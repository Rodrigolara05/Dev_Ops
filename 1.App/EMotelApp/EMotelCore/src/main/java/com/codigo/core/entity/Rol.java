package com.codigo.core.entity;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.persistence.Entity;

@Entity
@Table(name="rol")
public class Rol {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nombre;
	
	@OneToMany(mappedBy="rol")
	private List<Administrador> administrador;

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
