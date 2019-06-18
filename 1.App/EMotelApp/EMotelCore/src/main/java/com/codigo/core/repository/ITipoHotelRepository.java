package com.codigo.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codigo.core.entity.TipoHotel;

@Repository
public interface ITipoHotelRepository extends JpaRepository<TipoHotel, Integer>{

}
