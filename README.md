# Biblioteca API

API REST para la gestión de una biblioteca, desarrollada con Java y Spring Boot.

El proyecto permite gestionar libros y autores mediante una API REST, incorporando persistencia con MySQL, DTOs, validaciones, mapeo de entidades y seguridad mediante Spring Security y JWT.

## Tecnologías

* Java 21
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate
* MySQL
* Spring Security
* JWT
* Maven
* Lombok
* MapStruct
* JUnit 5
* Mockito
* Git / GitHub

## Funcionalidades

### Gestión de libros

* Crear libros
* Consultar libros
* Consultar un libro por ID
* Actualizar libros
* Eliminar libros
* Asociar libros con autores
* Validación de datos mediante DTOs

### Gestión de autores

* Crear autores
* Consultar autores
* Consultar autores junto con sus libros
* Actualizar autores
* Eliminar autores

### Seguridad

La API implementa autenticación y autorización utilizando Spring Security y JWT.

* Registro de usuarios
* Inicio de sesión
* Contraseñas protegidas mediante BCrypt
* Generación de tokens JWT
* Autenticación mediante Bearer Token
* Autorización basada en roles
* Roles `USER` y `ADMIN`
* Protección de endpoints según el rol del usuario

Los endpoints protegidos requieren un token JWT válido.

## Arquitectura

El proyecto utiliza una arquitectura por capas para separar responsabilidades:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
MySQL
```

Además, se utilizan DTOs y MapStruct para separar los objetos utilizados por la API de las entidades de persistencia.

### Principales capas

**Controller**

Recibe las solicitudes HTTP y expone los endpoints de la API.

**Service**

Contiene la lógica de negocio de la aplicación.

**Repository**

Gestiona el acceso a la base de datos mediante Spring Data JPA.

**DTO**

Define los datos que recibe y devuelve la API, evitando exponer directamente las entidades.

**Mapper**

MapStruct se utiliza para convertir entre entidades y DTOs.

**Security**

Spring Security gestiona la autenticación y autorización, mientras que JWT permite mantener una autenticación basada en tokens.

## Modelo de datos

Actualmente la aplicación trabaja principalmente con las entidades:

* `User`
* `Autor`
* `Libro`

La relación principal del dominio es:

```text
Autor 1 ──────── N Libro
```

Un autor puede tener varios libros y cada libro pertenece a un autor.

## API

### Autenticación

```text
POST /api/auth/register
POST /api/auth/login
```

### Libros

```text
GET    /api/libros
GET    /api/libros/{id}
POST   /api/libros
PUT    /api/libros/{id}
DELETE /api/libros/{id}
```

### Autores

```text
GET    /api/autores
GET    /api/autores/{id}
POST   /api/autores
PUT    /api/autores/{id}
DELETE /api/autores/{id}
```

Los endpoints protegidos requieren autenticación mediante JWT y algunos endpoints requieren un rol específico.

## Testing

El proyecto utiliza JUnit 5 y Mockito para realizar pruebas unitarias.

Actualmente se cuenta con pruebas del servicio de libros, utilizando mocks para aislar la lógica de negocio de la base de datos y otras dependencias.

Los tests pueden ejecutarse mediante Maven:

```bash
./mvnw test
```

En Windows también puede utilizarse:

```bash
mvnw.cmd test
```

## Configuración

La aplicación utiliza variables de entorno para mantener fuera del código fuente información sensible como las credenciales de la base de datos y el secreto utilizado para JWT.

### Variables de entorno

Antes de ejecutar la aplicación, configura las siguientes variables:

```text
DB_PASSWORD= ${DB_PASSWORD}
JWT_SECRET= ${JWT_SECRET}
```

Los valores reales no deben subirse al repositorio.

### Generar el secreto JWT

El proyecto incluye la clase `JwtSecretGenerator`, ubicada en:

```text
src/main/java/biblioteca/biblioteca/JwtSecretGenerator.java
```

Esta clase genera un secreto aleatorio compatible con el algoritmo HMAC-SHA256 y lo codifica en Base64.

Para generar un nuevo secreto:

1. Ejecuta la clase `JwtSecretGenerator` desde IntelliJ IDEA.
2. Copia el valor generado en la consola.
3. Configúralo como valor de `JWT_SECRET`.

Ejemplo:

```text
JWT_SECRET= ${clave generada}
```

Cada instalación del proyecto debe utilizar su propio secreto JWT.

### Base de datos

La aplicación utiliza MySQL.

Configuración utilizada:

```text
Host: localhost
Port: 3306
Database: biblioteca_bd
Username: root
```

La contraseña se configura mediante la variable de entorno:

```text
DB_PASSWORD
```

La aplicación está configurada para crear la base de datos si no existe y actualizar el esquema mediante Hibernate.

### Ejecutar la aplicación

Una vez configuradas las variables de entorno, ejecuta:

**Windows:**

```bash
mvnw.cmd spring-boot:run
```

**Linux/macOS:**

```bash
./mvnw spring-boot:run
```

La API estará disponible en:

```text
http://localhost:8080
```

## Ejecución local

### Requisitos

* Java 21
* MySQL
* Maven (opcional, el proyecto incluye Maven Wrapper)

### Pasos

1. Clonar el repositorio.

2. Configurar las variables de entorno necesarias.

3. Crear o utilizar la base de datos MySQL configurada para el proyecto.

4. Ejecutar la aplicación:

```bash
mvnw.cmd spring-boot:run
```

La API quedará disponible localmente en:

```text
http://localhost:8080
```

## Próximas mejoras

El proyecto continúa en desarrollo. Algunas mejoras previstas son:

* Ampliar la cobertura de pruebas unitarias
* Pruebas de controladores
* Pruebas de seguridad y JWT
* Swagger / OpenAPI
* Paginación
* Búsqueda y filtrado
* Docker
* Docker Compose
* Mejoras en el manejo de excepciones
* Mejoras de validación
* Integración y pruebas de la API

## Objetivo del proyecto

Este proyecto forma parte de mi proceso de aprendizaje y práctica en desarrollo Backend con Java y Spring Boot.

El objetivo es aplicar conceptos de desarrollo de APIs REST, persistencia de datos, arquitectura por capas, seguridad, autenticación, autorización, testing y buenas prácticas de desarrollo.
