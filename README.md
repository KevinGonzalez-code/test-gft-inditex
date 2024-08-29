# Inditex Price Service

## Descripción

Este proyecto es una aplicación Spring Boot que provee un servicio REST para consultar el precio final de un producto de la marca ZARA en función de la fecha de aplicación, el identificador del producto y el identificador de la cadena.

El servicio consulta una base de datos en memoria (H2) que contiene una tabla con la información de precios (`PRICES`), y devuelve el precio correcto basado en la fecha de aplicación y la prioridad de la tarifa.

## Requisitos

-   JDK 17 o superior
-   Maven 3.8.0 o superior
-   Docker (opcional, para la ejecución en un contenedor)
-   Git

## Instalación

1. Clona el repositorio en tu máquina local:

    ```bash
    git clone https://github.com/KevinGonzalez-code/test-gft-inditex.git
    cd test-gft-inditex
    ```

2. Compila y empaqueta el proyecto utilizando Maven:

    ```bash
    mvn clean install
    ```

3. Ejecuta la aplicación:

    ```bash
    mvn spring-boot:run
    ```

    La aplicación se iniciará en `http://localhost:8080`.

## Uso

Puedes consultar el precio de un producto utilizando el siguiente endpoint:

```
GET /api/v1/price?brandId={brandId}&productId={productId}&applicationDate={applicationDate}
```

Por ejemplo:

```
http://localhost:8080/api/v1/price?brandId=1&productId=35455&applicationDate=2020-06-16T21:00:00
```

Esto devolverá un JSON con el precio final aplicable a esa fecha, producto y cadena.

## Tests

El proyecto incluye tanto tests unitarios como de integración. Para ejecutar los tests, usa el siguiente comando:

```bash
mvn test
```

Esto ejecutará todos los tests definidos en el proyecto, incluyendo los cinco casos de prueba solicitados en el enunciado.

## Ejecución en Docker

Si prefieres ejecutar la aplicación en un contenedor Docker:

1. Construye la imagen Docker:

    ```bash
    docker build -t inditex-price-service .
    ```

2. Ejecuta el contenedor:

    ```bash
    docker run -p 8080:8080 inditex-price-service
    ```

La aplicación estará disponible en `http://localhost:8080`.

## Especificaciones del Código

-   **Arquitectura Hexagonal**: El proyecto sigue una arquitectura hexagonal, separando claramente la lógica de negocio, las interfaces, y las implementaciones de persistencia.
-   **Base de datos H2**: Se utiliza una base de datos en memoria H2 para simplificar el despliegue y las pruebas.

-   **Swagger UI**: Se ha configurado Swagger UI para facilitar la exploración de la API REST. Puedes acceder a la documentación interactiva en `http://localhost:8080/swagger-ui.html`.

-   **Manejo de Excepciones**: Se implementa un controlador de excepciones global para gestionar los errores de manera uniforme y proporcionar respuestas claras en caso de errores como "precio no encontrado" o "parámetros incorrectos".
