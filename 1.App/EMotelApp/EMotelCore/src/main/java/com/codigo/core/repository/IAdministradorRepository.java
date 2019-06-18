package com.codigo.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codigo.core.entity.Administrador;

@Repository
public interface IAdministradorRepository extends JpaRepository<Administrador, Integer>{

	public Administrador buscarPorCorreo(String correo,String contraseña);
}
