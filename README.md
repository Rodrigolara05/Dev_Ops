# EMotel 

## Comenzando 🚀

El proyecto EMotel es un sistema Web que nos permite el mantenimiento de Restaurantes, Hoteles y de Reservas. 
El código fuente del sistema ha sido desarrollado con el lenguaje de programación Java y sera usado para poder explicar como implementar un flujo de DevOps .

Mira **Despliegue** para conocer como desplegar el proyecto.

## Construido con 🛠️

Las herramientas que se han usado para construir el proyecto fueron:

* [WILDFLY](http://wildfly.org/downloads/) - Servidor de Aplicaciones donde se desplegar el aplicativo Visor
* [MySQL](https://dev.mysql.com/downloads/mysql/5.5.html) - Sistema de gestión de bases de datos relacional 
* [JDK](http://www.oracle.com/technetwork/java/javase/downloads/) - Entorno de Ejecución
* [Maven](https://maven.apache.org/) - Manejador de dependencias
* [Flyway](https://flywaydb.org/) - Versionador de Scripts de Base de Datos
* [JUnit](https://junit.org/junit4/) - Framework para Pruebas Unitarias e Integrales
* [Mockito](https://site.mockito.org/) - Framework para Mockear datos para pruebas
* [Cucumber](https://cucumber.io/) - Framework para redactar escenarios
* [TestNg](https://testng.org/) - Framework para Pruebas Unitarias, Integrales y Sistemas, en nuestro caso lo usaremos junto con Selenium
* [Seleniun Web Driver](https://www.seleniumhq.org/) - Framework para automarizar las Pruebas Funcionales

## Versionado 📌

Usamos [Git](https://git-scm.com/) para el versionado. Su uso es solo para fines académicos. 

## Autores ✒️

- Luis Alberto Ortiz Centeno
- Alvaro Jesus Poma Sanchez
- Rodrigo Max Lara Camarena

* **Rodrigo Max Lara Camarena** -  [Rodrigo Lara](www.linkedin.com/in/rodrigolara05)

### Pre-requisitos 📋

Para poder trabajar con el siguiente proyecto debe de tener conocimientos de desarrollo web con Java, de Pruebas de Software y de configuración de Servidores. 
Debido a que el sistema se preparo para poder explicar un flujo de DevOps

### Instalación 🔧

Para restaurar la base de datos primero debes ubicarte en la ruta \2.Db\VisorDb:

```
* Crear la Base de Datos VisorDb desde el script "Crear_BaseDatos.sql"
* Ejecutar los comandos para limpiar la base de datos: mvn flyway:clean -DVisorDb.urlBaseDatos=localhost:3306 -DVisorDb.baseDatos=visorbd -DVisorDb.usuarioBaseDatos=visoruser -DVisorDb.claveBaseDatos=visorpass
* Ejecutar los comandos para crear la base de datos: mvn flyway:migrate -DVisorDb.urlBaseDatos=localhost:3306 -DVisorDb.baseDatos=visorbd -DVisorDb.usuarioBaseDatos=visoruser -DVisorDb.claveBaseDatos=visorpass
```

Debes de ubicarte en la ruta \1.App\VisorApp\VisorCore y ejecutar los siguientes comandos:

```
mvn clean install
```

### Despliegue 📦

Para desplegar el WAR debemos de ejecutar los siguientes comandos:

wildfly\bin\boss-cli.bat -c --command=\"undeploy VisorWeb.war\""
wildfly\bin\boss-cli.bat -c --command=\"deploy ${ruta_previa}\\1.App\\VisorApp\\VisorWeb\\target\\VisorWeb.war\""

### Ejecutando las pruebas unitarias e integrales ⚙️

Debes de ubicarte en la ruta \1.App\VisorApp\VisorCore y ejecutar los siguientes comandos:

```
* Pruebas unitarias: mvn test -Dtest=*UnitSuite 
* Pruebas integrales: mvn cobertura:cobertura -Dtest=*IntegrationSuite
```
### Ejecutando las pruebas funcionales 🔩

Debes de ubicarte en la ruta \3.Test\1.PruebasFuncionales\VisorTest y ejecutar los siguientes comandos:

```
mvn test -Dchrome.rutaArchivo='C:\Users\Hamp\RegistrarCategoriaData.xlsx'' -Dfirefox.rutaArchivo='C:\Users\Hamp\RegistrarCategoriaData.xlsx'
```

### Y las pruebas de estilo de codificación ⌨️

Debes de ubicarte en la ruta \1.App\VisorApp\VisorCore y ejecutar los siguientes comandos:

```
* Pruebas de estandares codificación: mvn sonar:sonar 
```