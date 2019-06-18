Feature: Mantenimiento de Hotel
  Como administrador necesito realizar la gestión de Hoteles

  @tag1
  Scenario: Registrar Hotel
	Given despues de iniciar sesion en la aplicacion EMotel
	When hago click en la opción de Registrar Hotel en la parte izquierda de la página del dashboard del administrador
	And en la pantalla escribo en campo Nombre el valor de EMotel "Sheraton22"
	And en la pantalla escribo en campo Precio el valor de EMotel "45.00"
	And en la pantalla escribo en campo Direccion el valor de EMotel "Av. Juan de Arona 175"
	And busco en el campo Distrito el valor de EMotel "San Isidro"
	And busco en el campo Tipo De Hotel el valor de EMotel "Economico"
	And presiono en el boton de Registrar
	Then el sistema me muestra el mensaje de EMotel : "Hotel guardado"

  @tag2
  Scenario: Actualizar Hotel
  	Given despues de iniciar sesion en la aplicacion
  	When hago click en la opción de Listar Hoteles en la parte izquierda de la página del dashboard del administrador
	And luego hago click en el enlace de editar de un registro
	And busco en el campo Distrito el valor de "Miraflores"
	And presiono en el boton de Registrar
	Then el sistema me muestra el mensaje de EMotel : "Hotel guardado"

  @tag3
  Scenario: Eliminar Hotel
  	Given despues de iniciar sesion en la aplicacion
  	When hago click en la opción de Listar Hoteles en la parte izquierda de la página del dashboard del administrador
	And luego hago click en el enlace de eliminar de un registro
	Then el sistema me muestra el mensaje de EMotel : "Hotel eliminado"
	