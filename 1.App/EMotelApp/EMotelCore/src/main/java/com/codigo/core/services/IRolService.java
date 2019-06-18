package com.codigo.core.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codigo.core.entity.Rol;

@Service
public interface IRolService {

	public boolean agregar(Rol nacionalidad);
	public List<Rol> listar();
}
