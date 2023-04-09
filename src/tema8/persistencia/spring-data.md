# Persistencia
## Spring Data

[Spring Data](https://spring.io/projects/spring-data#overview) proporciona un modelo de programación unificado para el acceso a bases de datos, ya sean relacionales o NoSQL. También, añade funcionalidades que simplifican el uso de JPA. Para definir un modelo de datos se utilizan objetos de tipo **entidad** (datos) y de tipo **repositorio** (operaciones).

Para entender estos conceptos, vamos a implementar el [modelo de datos](relacionales.md) del [API de contadores](../../tema6/backend/spring-mvc-api.html) usando [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.0.5/reference/htmlsingle/#data.sql.jpa-and-spring-data).

<object type="image/svg+xml" data="./files/img/spring-data-jpa-jdbc.excalidraw.svg" width="100%"></object>