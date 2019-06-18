package com.codigo.core.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codigo.core.entity.Administrador;

@Service
public interface IAdministradorService {

	public boolean agregar(Administrador usuario);
	public List<Administrador> listar();
	public Administrador buscarPorCorreo(String correo,String contraseña);
}
