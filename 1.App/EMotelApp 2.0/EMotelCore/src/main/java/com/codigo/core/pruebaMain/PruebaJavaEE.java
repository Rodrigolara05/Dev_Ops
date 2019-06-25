package com.codigo.core.pruebaMain;



import java.util.List;

import com.codigo.core.entity.Administrador;
import com.codigo.core.entity.Rol;
import com.codigo.core.repository.AdministradorRepository;
import com.codigo.core.service.RolServices;

public class PruebaJavaEE {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			AdministradorRepository adminserv = new AdministradorRepository();
			Administrador obj = new Administrador();
			RolServices rolservi= new RolServices();
			Rol rol= new Rol();
			java.util.Date o = new java.util.Date();
			/*
			rol=rolservi.obtener(2);
			obj.setNombre("Ortiz2");
			obj.setApellido("Lara2");
			obj.setCorreo("olara@gmail.com");
			obj.setFecha(o);
			obj.setPassword("12345");
			obj.setRol(rol);

			//boolean d = adminserv.insertar(obj);	
			List<Administrador> lista = adminserv.listar();
			for (int i = 0; i < lista.size(); i++) {
				System.out.print(lista.get(i).getNombre()+"\t");
				System.out.print(lista.get(i).getApellido()+"\t");
				System.out.print(lista.get(i).getFecha()+"\t");
				System.out.print(lista.get(i).getRol().getId());
				
				System.out.println("\n");
			}*/
			obj = adminserv.buscarPorCorreo("admin@gmail.com", "password");
			System.out.print(obj.getNombre()+"\t");
			System.out.print(obj.getApellido()+"\t");
			System.out.print(obj.getCorreo()+"\t");
			System.out.print(obj.getPassword()+"\t");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error: " + e.getMessage());
		}
	}

}
