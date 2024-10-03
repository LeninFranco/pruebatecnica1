# Prueba Técnica 1 - Desarrollador Backend Junior

## Descripción

Este proyecto es una prueba técnica para un desarrollador backend junior, implementado en Java utilizando el framework Spring Boot. El objetivo principal es crear un servicio que consuma una API externa (JSONPlaceholder) para obtener una lista de usuarios y exponerla a través de un nuevo endpoint en la aplicación Spring. Además, se ha implementado un sistema de Caché utilizando Caffeine.

## Requisitos

- Java 17 o superior
- Maven 3.6.0 o superior

## Configuración del Proyecto

1. Clona el repositorio:
    ```bash
    git clone 
    cd pruebatecnica1

2. Instalar las dependencias de Maven
    ```bash
    mvn install
    mvn spring-boot:run


## Acceder al endpoint
Una vez que la aplicación se esté ejecutando, puedes acceder al endpoint para obtener la lista de usuarios:

GET http://localhost:8080/api/users

## Implementación de Caché

Este proyecto utiliza Caffeine como mecanismo de caché. Los resultados del endpoint se almacenan en caché durante 5 minutos para mejorar el rendimiento y evitar múltiples solicitudes a la API externa.

## Desarrollador

Lenin Eduardo Franco Aguilar