package com.codigo.core.entity;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.persistence.Entity;

@Entity
@Table(name="distrito")
public class Distrito {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nombre;
	
	@ManyToOne
	private Provincia provincia;
	
	@OneToMany(mappedBy="distritos")
	private List<Hotel> hoteles;
	
	@OneToMany(mappedBy="distrito")
	private List<Restaurante> restaurantes;
	
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
