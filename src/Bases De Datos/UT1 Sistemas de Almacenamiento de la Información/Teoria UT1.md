# Teoria UT1: Sistemas de Almacenamiento de la Información
### Introducción:
**Datos**: Unidades de información que pueden registrarse. Unidad basica en la que se almacena, transmite y procesa la información.

**Información**: El sentido que le dan los humanos a los datos.

Un **sistema de información** es un conjunto de elementos que almacena y gestiona la información relevante de una empresa, y se compone de: 
* **Recursos fisicos**: Carpetas, documentos, equipos, discos...
* **Recursos humanos**: Personal que maneja la información.
* **Reglas**: Normas que debe cumplir la información para que sea manejada.

### Jerarquia de 3 niveles:
* **Primario**: Memoria más rapida y a la cual la CPU puede acceder directamente (RAM, Cache).
* **Secundaria**: Dispositivos más lentos pero de mayor capacidad (Discos duros, SSD).
* **Intermedia**: Áreas de la memoria usada para transferir datos entre la memoria primaria y secundaria.

**Base de datos**: conjunto de datos almacenados entre los que existen relaciones lógicas y ha sido diseñada para satisfacer los requerimientos de información

### Problemas en sistemas de ficheros: 
* Separación/aislamiento de los datos
* Duplicación de datos
* Dependencia
* Formato (no hay un formato común para todos los ficheros)
* Concurrencia (no pueden acceder varios a la vez)
* Autorizaciones
* Catálogo (¿dónde están los distintos datos?)

### Arquitectura de tres niveles:
* **Nivel externo**: Vista del usuario, cada usuario tiene su propia vista de la base de datos
* **Nivel conceptual**: Vista de la comunidad de usuarios, oculta los detalles fisicos y se centra en entidades, atributos y relaciones.
* **Nivel interno:** Vista fisica, describe cómo se almacenan realmente los datos y sus metodos de acceso.

Esta arquitectura consigue la independencia de datos, es decir, los cambios en un nivel no afectan a los otros niveles. Hay dos tipos:
* **Independencia lógica**: Cambios en el nivel conceptual no afectan al nivel externo.
* **Independencia fisica**: Cambios en el nivel interno no afectan al nivel conceptual.
