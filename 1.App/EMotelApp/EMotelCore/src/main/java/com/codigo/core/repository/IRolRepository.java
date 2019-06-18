package com.codigo.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codigo.core.entity.Rol;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer>{

}
