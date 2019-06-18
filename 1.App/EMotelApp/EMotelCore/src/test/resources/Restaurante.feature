Feature: Mantenimiento de Restaurante
  Como administrador necesito realizar la gestión de Restaurantes
  
    @tag1
  Scenario: Registrar Restaurante
	Given despues  de iniciar sesion en la aplicacion
	When hago  click en la opción de Registrar Restaurante en la parte izquierda de la página del dashboard del administrador
	And en  la pantalla escribo en campo Nombre el valor de "Leña y Carbon22"
	And en  la pantalla escribo en campo Precio el valor de "50.00"
	And en  la pantalla escribo en campo Descripción el valor de "Los mejores pollos a la brasa"
	And en  la pantalla escribo en campo Ubicacion el valor de "Av. Canaval Moreyra 180"
	And busco  en el campo Distrito el valor de "Miraflores"
	And presiono  en el boton de Registrar
	Then el  sistema me muestra el mensaje de: "Restaurante guardado"

  @tag2
  Scenario: Actualizar Restaurante
  	Given despues  de iniciar sesion en la aplicacion
  	When hago  click en la opción de Listar Restaurantes en la parte izquierda de la página del dashboard del administrador
	And luego  hago click en el enlace de editar de un registro
	And busco  en el campo Distrito el valor de "Chorrillos"
	And presiono  el boton de Actualizar
	Then el  sistema me muestra el mensaje de: "Restaurante guardado"
	
  @tag3
  Scenario: Eliminar Restaurante
  	Given despues  de iniciar sesion en la aplicacion
  	When hago  click en la opción de Listar Restaurantes en la parte izquierda de la página del dashboard del administrador
	And luego  hago click en el enlace de eliminar de un registro
	Then el  sistema me muestra el mensaje de: "Restaurante eliminado"
	