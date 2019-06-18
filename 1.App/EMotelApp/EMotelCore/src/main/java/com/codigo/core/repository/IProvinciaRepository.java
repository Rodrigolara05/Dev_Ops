package com.codigo.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codigo.core.entity.Provincia;

@Repository
public interface IProvinciaRepository extends JpaRepository<Provincia, Integer>{

}
