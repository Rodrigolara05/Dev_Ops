package com.codigo.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codigo.core.entity.Reserva;

@Repository
public interface IReservaRepository extends JpaRepository<Reserva, Integer>{
	public List<Reserva> buscarPorParametro(int hotel,int restaurante);
}
