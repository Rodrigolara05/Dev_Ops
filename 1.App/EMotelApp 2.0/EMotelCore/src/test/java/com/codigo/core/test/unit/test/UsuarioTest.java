package com.codigo.core.test.unit.test;

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
import org.mockito.runners.MockitoJUnitRunner;

import com.codigo.core.entity.Administrador;
import com.codigo.core.service.AdministradorServices;
import com.codigo.core.test.unit.suit.PruebasUnitariasTest;

@Category(PruebasUnitariasTest.class)
@RunWith(MockitoJUnitRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UsuarioTest {


	@Mock
	Administrador admin = new Administrador();
		
	@Mock
	AdministradorServices adminServ;
	
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
			
            when(adminServ.insertar(Matchers.any())).thenReturn(true);
            
			adminServ.insertar(admin);
			
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
	            
				when(adminServ.insertar(Matchers.any())).thenReturn(true);
	            adminServ.insertar(admin);
	            
	            adminBuscado = adminServ.buscarPorCorreo(admin.getCorreo(), admin.getPassword());
	            Assert.assertEquals(admin.getCorreo(),adminBuscado.getCorreo());
	            Assert.assertEquals(admin.getPassword(),adminBuscado.getPassword());
	             
	        } catch (Exception e) {
	            e.printStackTrace();
	            Assert.fail();
	        }
	 }
	
}
