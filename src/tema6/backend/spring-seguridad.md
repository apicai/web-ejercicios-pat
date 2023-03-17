# Backend

## Spring

### Seguridad

El módulo de [Spring Security](https://docs.spring.io/spring-security/reference/index.html) añade autenticación (identificación del usuario), autorización (control de acceso) y protección frente a vulnerabilidades web como [CSRF](../../tema5/js/vulnerabilidades-csrf.html)[^1].

> ⁉️ **Ejercicio:** _Para habilitar Spring Security añade la siguiente dependencia al proyecto MVC:_
> ```xml
> <dependency>
>   <groupId>org.springframework.boot</groupId>
>   <artifactId>spring-boot-starter-security</artifactId>
> </dependency>
> ```

[^1]: Por ejemplo, añade un campo oculto a los formularios con un token que será requerido cuando se procese en el servidor. Ese campo distinguirá aquellas peticiones legítimas de las realizadas [maliciosamente](../../tema5/js/vulnerabilidades-csrf.html#token).
