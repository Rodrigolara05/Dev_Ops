package com.codigo.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codigo.core.repository.IProvinciaRepository;

import com.codigo.core.entity.Provincia;

@Service
public class ProvinciaService implements IProvinciaService {
	@Autowired
	IProvinciaRepository repository;
	@Override
	public boolean agregar(Provincia provincia) {
		boolean flag = false;
		
		try {
			Provincia objProvincia= repository.save(provincia);
			
			if(objProvincia != null) {
				flag = true;
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return flag;
	}

	@Override
	public List<Provincia> listar() {
		return repository.findAll();
	}

}
