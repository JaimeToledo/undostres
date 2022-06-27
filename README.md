# Ambientación
## Requisitos:

### Generales
	
* Tener Instalado IDE(Intellij, eclipse, etc..)
* Importar el proyecto en el IDE
* Tener un dispositivo ANDROID conectado al equipo en modo depuración USB
	
### Appium
* Instalar Android studio(para que se instale el sdk)
	
* Crear Variables de entorno:
	* **JAVA_HOME: C:\Program Files\Java\jdk-->17.0.1**
	* **ANDROID_HOME: C:\Users\usuario\AppData\Local\Android\Sdk**

* Instalar Node para que se instale npm: 
  **[Descarga aquí](https://nodejs.org/es/download/)**
	
* Instalar appium desde cmd con npm:
	* **npm install -->g appium**
		
* Instalar appium doctor(no es necesario, sirve para comprobar que todo esta configurado correctamente)
	* **npm install appium-->doctor -->g**
	* prueba con appium doctor de que el entorno esta configurado exitosamente: 
	  **appium-->doctor -->-->android**
	
## Estructura Proyecto

### Se utilizó el patrón de diseño POM(Page Object Model):
 
 * **Consta de 3 paquetes:**
	1. **General:**
		En este paquete se encuentran clases "generales" como clase Base, captura de pantalla, clase para enviar correo, clase para leer el archivo configurador etc..
		la mas importante es la clase base, que es la que contiene todos los métodos que se utilizan para el proyecto general, como generar driver, encontrar elementos,
		scroll, etc...
		
		
	2. **Test:**
		Se tiene una clase por cada test que se requiere hacer, es decir, una de login,  1 de packing etc.. pero hay una que es genera llamada  "suite"
		Esta clase lo unico que hace es que con ayuda de TestNG antes de realizar cualquier test crea un reporte(extent report) para ir agregando despues en cada test
		los pasos, resultados y scrrenshots.
		
	3. **Views:**
		En este paquete se crea una clase por cada view, pagina o interfaz, el objetivo de esta clase es generar una descripción de todos los elementos que se encuentran visibles (botones, cajas de texto, textos, etc..) y se crea un método de cada escenario que puede surgir para esa pantalla.
		
## Herramientas Utilizadas
 * En el proyecto es de tipo Maven(Maven Proyect) por lo que se genera por default un archivo pom.xml en dicho archivo, se tiene que agregar las dependencias necesarias
   Para poder ejecutar los test exitosamente que son las dependencias de:
	1. **TestNG** (Estructurar y organizar los test)
	2. **Extent Reports** (Para generar el reporte con extención .html)
	3. **Appium** (Herramienta para automatizar Móviles)
	

### Ejecución
* abrir un cmd y ejecutar el comando: appium
* Al exportar el proyecto en el IDE, se podrá visualizar un archivo llamado testng.xml el cual se abrirá dando doble clic.
* Una vez que se visualice ese archivo, dentro de el hacemos clic derecho y se selecciona la opción Run AS-> TestNG Suite y se comenzara a ejecutar el script.

### Visualizar reporte de resultados
* Buscar en una carpeta llamada Reporte en el menu raiz del proyecto.
* Seleccionar el archivo Resultados.html y se abrira el reporte en un navegador de forma local.

