package com.codigo.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codigo.core.repository.IRolRepository;

import com.codigo.core.entity.Rol;

@Service
public class RolService implements IRolService {
	@Autowired
	IRolRepository repository;
	
	@Override
	public boolean agregar(Rol nacionalidad) {
		boolean flag = false;
		
		try {
			Rol objNacionalidad= repository.save(nacionalidad);
			
			if(objNacionalidad != null) {
				flag = true;
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return flag;
	}

	@Override
	public List<Rol> listar() {
		return repository.findAll();
	}

}
