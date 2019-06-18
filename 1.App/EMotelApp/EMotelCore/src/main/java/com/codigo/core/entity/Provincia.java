package com.codigo.core.entity;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.persistence.Entity;

@Entity
@Table(name="provincia")
public class Provincia {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nombre;
	
	@OneToMany(mappedBy="provincia")
	private List<Distrito> distritos;
	
	
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
