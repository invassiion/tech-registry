# tech-registry
Tech Registry — это RESTful приложение для управления реестром техники с возможностью поиска, фильтрации, сортировки и добавления новых записей. В проекте используются технологии Spring Boot, JPA, Hibernate, PostgreSQL и OpenAPI для генерации документации.

## Содержание  
- [Технологии](#технологии)
- [Установка и настройка](#установка-и-настройка)
- [Запуск приложения](#запуск-приложения)
- [Документация API](#документация-api)

Технологии:   
 - **Язык программирования:** Java 8  
 - **Frameworks:** Spring Boot 2.5.0 , Spring Web, Spring JPA, Spring Hibernate;
 - **База данных:** PostgreSQL
 - **Библиотека для генерации документации:** springdoc-openapi v1.5.9
 - **Управление зависимостями:** Maven

## Установка и настройка 
 - Скачайте и установите Docker
 - Установите Docker Compose, если он не включен в установку Docker.

Склонируйте репозиторий проекта:
git clone https://github.com/invassiion/tech-registry.git
cd tech-registry

Создайте файл application.properties на основе примера application.properties.example:
cp src/main/resources/application.properties.example src/main/resources/application.properties

Отредактируйте application.properties и замените значения на свои настройки

Убедитесь, что в docker-compose.yml настроены все параметры корректно.

Запустите Docker Compose для развертывания базы данных и приложения:
docker-compose up --build

## Запуск приложения локально (без Docker)  

  -Установите зависимости проекта с помощью Maven:
    mvn clean install
 - Запустите приложение:
    mvn spring-boot:run
## Документация API 
Документация API доступна по следующему URL:
http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/vacuum-model-controller/createVacuumModel