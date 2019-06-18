package com.codigo.core.entity;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.persistence.Entity;

@Entity
@Table(name="hotel")
@NamedQueries({
	@NamedQuery(name="Hotel.HotelPorDistrito", query="select a from Hotel a where a.distritos.id=?1")
})
public class Hotel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotBlank()
	private String nombre;
	
	@Min(value=(long) 1.0)
	private double precio;
	@NotBlank()
	private String ubicacion;
	
	@ManyToOne
	@NotNull()
	private TipoHotel tipohotel;
	
	@ManyToOne
	@NotNull()
	private Distrito distritos;
	
	
	@OneToMany(mappedBy="hotel")
	private List<Reserva> reservas;

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
