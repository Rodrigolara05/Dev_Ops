package com.codigo.test.unit.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.codigo.core.entity.Administrador;
import com.codigo.core.entity.Hotel;
import com.codigo.core.services.AdministradorService;

@Category(com.codigo.test.unit.suite.PruebasUnitariasTest.class)
@RunWith(MockitoJUnitRunner.Silent.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UsuarioTest {


	@Mock
	Administrador admin = new Administrador();
		
	@Mock
	AdministradorService adminServ;
	
	@BeforeClass
	public static void superInit() {
		System.out.println("Soy las pruebas de Usuarios");
	}
	
	@Test
	public void Test_registrar() {
		try {
			System.out.println("Soy la prueba de Registrar");
			when(admin.getId()).thenReturn(1);
			when(admin.getNombre()).thenReturn("Rodrigo Henry");
			when(admin.getApellido()).thenReturn("Poma Ortiz");
			when(admin.getCorreo()).thenReturn("SmartSolutions@gmail.com");
			when(admin.getPassword()).thenReturn("contraseña");
			
            when(adminServ.agregar(Matchers.any())).thenReturn(true);
            
			adminServ.agregar(admin);
			
			Assert.assertTrue(admin.getId() > 0);
			
		} catch (Exception e) {
			// TODO: handle exception
			Assert.fail();
		}
	}
	
	
	 @Test
	 public void Test_Login() {
	     try {
	            System.out.println("Soy la prueba de Login");
	            Administrador adminBuscado;
	            when(admin.getId()).thenReturn(1);
				when(admin.getNombre()).thenReturn("Rodrigo Henry");
				when(admin.getApellido()).thenReturn("Poma Ortiz");
				when(admin.getCorreo()).thenReturn("SmartSolutions@gmail.com");
				when(admin.getPassword()).thenReturn("contraseña");
	            
				when(adminServ.buscarPorCorreo(Matchers.any(),Matchers.any())).thenReturn(admin);
	            
				when(adminServ.agregar(Matchers.any())).thenReturn(true);
	            adminServ.agregar(admin);
	            
	            adminBuscado = adminServ.buscarPorCorreo(admin.getCorreo(), admin.getPassword());
	            Assert.assertEquals(admin.getCorreo(),adminBuscado.getCorreo());
	            Assert.assertEquals(admin.getPassword(),adminBuscado.getPassword());
	             
	        } catch (Exception e) {
	            e.printStackTrace();
	            Assert.fail();
	        }
	 }
	
}
