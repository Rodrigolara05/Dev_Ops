Feature: Mantenimiento de Usuarios
  Como administrador necesito realizar la gestión de Usuarios
  
   @tag1
  Scenario: Registrar Usuario
  Given despues de entrar a la pagina web
When hago click en la opción de “Registrarse” en la parte superior de la pagina
And en la pantalla escribo en campo Nombre el valor de "Pepe"
And en la pantalla escribo en campo Apellido el valor de "Llona"
And en la pantalla escribo en campo Fecha el valor de "03-03-1999"
And en la pantalla escribo en campo Rol el valor de "usuario"
And en la pantalla escribo en campo Email el valor de "integration@gmail.com"
And en la pantalla escribo en campo Password el valor de "integration"
And presiono en el boton de "Registrar"
Then el sistema debe redireccionar a la vista “Inicio de sesión” y mostrar un mensaje que diga “USUARIO GUARDADO”

  @tag2
  Scenario: Inicio de Sesion Usuario
  Given despues de entrar a la pagina web
When hago click en la opción de “Iniciar Sesion” en la parte superior de la pagina.
And en la pantalla escribo en campo Email el valor de "prod@gmail.com"
And en la pantalla escribo en campo Password el valor de "prod"
And presiono en el boton de "Iniciar Sesion"
Then el sistema debe redireccionar al dashboard del cliente que es la visualización de Hoteles y Restaurantes.