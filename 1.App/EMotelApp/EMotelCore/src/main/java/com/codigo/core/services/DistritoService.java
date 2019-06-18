package com.codigo.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codigo.core.repository.IDistritoRepository;

import com.codigo.core.entity.Distrito;

@Service
public class DistritoService implements IDistritoService {
	@Autowired
	IDistritoRepository repository;
	
	@Override
	public boolean agregar(Distrito distrito) {
		boolean flag = false;
		
		try {
			Distrito objDistrito= repository.save(distrito);
			
			if(objDistrito != null) {
				flag = true;
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return flag;
	}

	@Override
	public List<Distrito> listar() {
		return repository.findAll();
	}

}
