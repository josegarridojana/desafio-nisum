# Spring Boot Desafio Nisum CRUD: Building Rest API con Spring Data JPA

Detalle:

> [Desafio Nisum: Build a CRUD Rest APIs](http://localhost:8088/desafio-nisum/)
> [Desafio Nisum: Build a CRUD Rest APIs Actuator](http://localhost:8088/desafio-nisum/actuator/health)
> [Desafio Nisum: Build a CRUD Rest APIs Swagger]( http://localhost:8088/desafio-nisum/swagger-ui.htm)



 
En esta prueba, crearemos un ejemplo de API CRUD de Spring Boot Rest con Maven que usa Spring Data JPA para interactuar con la base de datos H2 en memoria. 

Pasos:

- Configurar Spring Data, JPA, Hibernate para trabajar con la base de datos
- Definir modelos de datos, interfaces de repositorio y services
- Definir Patron de diseño MVC en API RestFull
- Crear Spring Rest Controller para procesar solicitudes HTTP
- Se Usa Spring Data JPA para interactuar con H2 Database
- Uso de lombook
- Validacion de email
- Validacion de password es Mínimo ocho caracteres, al menos una letra y un número

CURL
> 
curl --location 'http://localhost:8088/desafio-nisum/usuarios' \
--header 'Content-Type: application/json' \
--data-raw ' {
        "name": "Juan Rodriguez",
        "email": "juan@rodriguez211.org",
        "password": "hunter288",
        "phones": [
            {
                "number": "12345637",
                "cityCode": "1",			
                "contryCode": "57"
            }
        ]
    }'
	
Front-end eso funciona bien con esto Back-end
> 

Más práctica:
>

Manejo de excepciones:
>

Otras bases de datos:
>

Seguridad:
>

Fullstack:
> 

Ejecute tanto el back-end como el front-end en un solo lugar:
> 

Se deja collection de postman:
> 

## Run Spring Boot application
```
mvn spring-boot:run
```

## Run Spring Boot application IDE Eclipse
```
mvn spring-boot:run
```

# Desafío Java Nisum

Desarrolle una aplicación que exponga una API RESTful de creación de usuarios

Todos los endpoints deben aceptar y retornar solamente JSON, inclusive al para los mensajes de error.

Todos los mensajes deben seguir el formato:

```json
  {"mensaje": "mensaje de error"}
```

## Registro
* Ese endpoint deberá recibir un usuario con los campos "nombre", "correo", "contraseña", más un listado de objetos "teléfono", respetando el siguiente formato:
```json
    {
        "name": "Juan Rodriguez",
        "email": "juan@rodriguez.org",
        "password": "hunter2",
        "phones": [
            {
                "number": "1234567",
                "citycode": "1",			
                "contrycode": "57"
            }
        ]
    }
```
* Responder el código de status HTTP adecuado
* En caso de éxito, retorne el usuario y los siguientes campos:
   * `id`: id del usuario (puede ser lo que se genera por el banco de datos, pero sería más deseable un UUID)
   * `created`: fecha de creación del usuario
   * `modified`: fecha de la última actualización de usuario
   * `last_login`: del último ingreso (en caso de nuevo usuario, va a coincidir con la fecha de creación)
   * `token`: token de acceso de la API (puede ser UUID o JWT)
   * `isactive: Indica si el usuario sigue habilitado dentro del sistema.
   
* Si caso el correo conste en la base de datos, deberá retornar un error "El correo ya registrado".
* El correo debe seguir una expresión regular para validar que formato sea el correcto. (aaaaaaa@dominio.cl)
* La clave debe seguir una expresión regular para validar que formato sea el correcto. (El valor de la expresión regular debe ser configurable)



## Requisitos
* Plazo: 3 días, si tienes algún inconveniente con el tiempo comunicate con nosotros
* Banco de datos en memoria, como HSQLDB o H2..
* Proceso de build via Gradle o Maven..
* Persistencia con JPA. Ejemplo: EclipseLink, Hibernate u OpenJPA.
* Framework SpringBoot..
* Java 8+
* Entrega en un repositorio público (github o bitbucket) con el código fuente y script de creación de BD.
* Readme explicando cómo probarlo.
* Diagrama de la solución.
* JWT como token
* Pruebas unitarias
* Swagger
* Se recomienda y se valorizará mucho la utilización de Patrones de Diseño y buenas practicas
