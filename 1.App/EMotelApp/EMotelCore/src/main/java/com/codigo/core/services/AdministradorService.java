package com.codigo.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codigo.core.repository.IAdministradorRepository;

import com.codigo.core.entity.Administrador;


@Service
public class AdministradorService implements IAdministradorService {
	@Autowired
	IAdministradorRepository repository;
	
	@Override
	public boolean agregar(Administrador usuario) {
		boolean flag = false;
		
		try {
			Administrador objUsuario= repository.save(usuario);
			
			if(objUsuario != null) {
				flag = true;
			}else {
				flag = false;
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return flag;
	}

	@Override
	public List<Administrador> listar() {
		return repository.findAll();
	}
	@Override
	public Administrador buscarPorCorreo(String correo,String contraseña) {
		
		return repository.buscarPorCorreo(correo,contraseña);
	}
}
