# Backend

## Despliegue

### Monitorización

#### Spring Actuator

[Spring Actuator](https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html) es una dependencia que añade funcionalidades para poder monitorizar el estado del microservicio:

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

Para habilitarla es necesaria esta configuración:

```properties
management.endpoints.web.exposure.include=*
management.endpoint.health.show-components=always
management.endpoint.health.show-details=always
management.endpoint.health.probes.enabled=true
```

> **❓ Ejercicio:** _Añade la dependencia anterior a tu proyecto MVC. Re-arranca el servidor, prueba los siguientes endpoints, e intenta explicar para qué podrían valer:_
> - [`/actuator/health`](http://localhost:8080/actuator/health)
> - [`/actuator/metrics`](http://localhost:8080/actuator/metrics)
> - [`/actuator/metrics/process.cpu.usage`](http://localhost:8080/actuator/metrics/process.cpu.usage)
