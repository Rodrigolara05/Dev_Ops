package com.codigo.core.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codigo.core.entity.Distrito;

@Service
public interface IDistritoService {

	public boolean agregar(Distrito distrito);
	public List<Distrito> listar();
}
