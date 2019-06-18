package com.codigo.core.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codigo.core.entity.Provincia;

@Service
public interface IProvinciaService {

	public boolean agregar(Provincia provincia);
	public List<Provincia> listar();
}
