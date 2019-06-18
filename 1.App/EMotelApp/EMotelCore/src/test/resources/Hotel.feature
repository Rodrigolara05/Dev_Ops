Feature: Mantenimiento de Hotel
  Como administrador necesito realizar la gestión de Hoteles

  @tag1
  Scenario: Registrar Hotel
	Given despues de iniciar sesion en la aplicacion
	When hago click en la opción de Registrar Hotel en la parte izquierda de la página del dashboard del administrador
	And en la pantalla escribo en campo Nombre el valor de "Sheraton22"
	And en la pantalla escribo en campo Precio el valor de "45.00"
	And en la pantalla escribo en campo Direccion el valor de "Av. Juan de Arona 175"
	And busco en el campo Tipo de Hotel el valor de "Economico"
	And busco   en el campo Distrito el valor de "SAN ISIDRO"
	And presiono en el boton de Registrar
	Then el sistema me muestra el mensaje de : "Hotel guardado"

  @tag2
  Scenario: Actualizar Hotel
  	Given despues de iniciar sesion en la aplicacion
  	When hago click en la opción de Listar Hoteles en la parte izquierda de la página del dashboard del administrador
	And luego hago click en el enlace de editar de un registro
	And busco en el campo Distrito el valor de "Miraflores"
	And presiono el boton de Actualizar
	Then el sistema me muestra el mensaje de : "Hotel guardado"

  @tag3
  Scenario: Eliminar Hotel
  	Given despues de iniciar sesion en la aplicacion
  	When hago click en la opción de Listar Hoteles en la parte izquierda de la página del dashboard del administrador
	And luego hago click en el enlace de eliminar de un registro
	Then el sistema me muestra el mensaje de : "Hotel eliminado"
	