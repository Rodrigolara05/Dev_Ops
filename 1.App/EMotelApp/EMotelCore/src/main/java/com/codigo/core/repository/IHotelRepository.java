package com.codigo.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codigo.core.entity.Hotel;

@Repository
public interface IHotelRepository extends JpaRepository<Hotel, Integer>{
	List<Hotel> HotelPorDistrito(int id);
}
