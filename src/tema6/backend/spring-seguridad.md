# Backend

## Spring

### Seguridad

El módulo de [Spring Security](https://docs.spring.io/spring-security/reference/index.html) añade autenticación (identificación del usuario), autorización (control de acceso) y protección frente a vulnerabilidades web como [CSRF](../../tema5/js/vulnerabilidades-csrf.html).

> ⁉️ **Ejercicio:** _Para habilitar Spring Security añade la siguiente dependencia al proyecto MVC:_
> ```xml
> <dependency>
>   <groupId>org.springframework.boot</groupId>
>   <artifactId>spring-boot-starter-security</artifactId>
> </dependency>
> ```