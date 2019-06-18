package com.codigo.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codigo.core.entity.Restaurante;

@Repository
public interface IRestauranteRepository extends JpaRepository<Restaurante, Integer>{
	List<Restaurante> RestaurantePorDistrito(int id);
}
