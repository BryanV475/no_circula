# Hoy No Circula

Esta es una aplicación web para el registro de vehículos y la validación de si un vehículo puede circular en ciertas fechas y horas según el programa "Hoy No Circula". La aplicación consta de un frontend en React y un backend en Spring Boot, con una base de datos PostgreSQL alojada en Neon.

## Características

1. **Registro de vehículos**: Ingreso de información del vehículo (PLACA, color, modelo, chasis, etc.) y almacenamiento en la base de datos.
2. **Validación de circulación**: Consulta para verificar si un vehículo registrado puede circular en una fecha y hora específicas.
3. **Frontend**: Desarrollado en React con Bootstrap para el diseño.
4. **Backend**: Desarrollado en Spring Boot con comunicación mediante REST usando HTTP.
5. **Base de datos**: PostgreSQL alojada en Neon.

## Tecnologías Utilizadas

- **Frontend**: React, React Router, Bootstrap, react-datepicker
- **Backend**: Spring Boot, Spring Data JPA
- **Base de datos**: PostgreSQL en Neon
- **Otros**: Axios

## Requisitos Previos

- Node.js (v14 o superior)
- npm o yarn
- Java Development Kit (JDK 11 o superior)
- Apache Maven
- PostgreSQL

## Configuración del Proyecto

### Backend

1. Clona el repositorio:
    ```bash
    git clone https://github.com/BryanV475/no_circula.git
    cd no_circula/backend/circula
    ```

2. Configura la base de datos PostgreSQL en `application.properties`:
    ```properties
    spring.datasource.url=jdbc:postgresql://ep-noisy-snowflake-a5wrmlpm.us-east-2.aws.neon.tech/neondb?user=neondb_owner&password=5Ujgkfmyb9Fn&sslmode=require
    spring.datasource.username=neondb_owner
    spring.datasource.password=5Ujgkfmyb9Fn
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
    ```

3. Construye y ejecuta la aplicación Spring Boot:
    ```bash
    ./mvnw clean install
    ./mvnw spring-boot:run
    ```

### Frontend

1. Clona el repositorio (si no lo has hecho ya):
    ```bash
    git clone https://github.com/BryanV475/no_circula.git
    cd no_circula/frontend/circula
    ```

2. Instala las dependencias:
    ```bash
    npm install
    ```

3. Inicia la aplicación React:
    ```bash
    npm start
    ```

## Uso de la Aplicación

1. Abre tu navegador y ve a `http://localhost:3000`.
2. Navega a la página de registro para agregar un nuevo vehículo.
3. Navega a la página de validación para verificar si un vehículo puede circular en una fecha y hora específicas.

## API Endpoints

- **Registrar Auto**: `POST /api/autos`
    - Request Body: JSON con los detalles del vehículo.
    - Response: JSON con la información del vehículo registrado.
- **Validar Circulación**: `POST /api/autos/validate?placa={placa}&fechaHora={fechaHora}`
    - Request Params: `placa` (string), `fechaHora` (ISO 8601 string).
    - Response: JSON con la información del vehículo y el mensaje de validación.
