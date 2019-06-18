package com.codigo.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codigo.core.entity.Distrito;


@Repository
public interface IDistritoRepository extends JpaRepository<Distrito, Integer>{
	
}
