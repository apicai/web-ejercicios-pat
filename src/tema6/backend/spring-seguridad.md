# Backend

## Spring

### Seguridad

El módulo de [Spring Security](https://docs.spring.io/spring-security/reference/index.html) añade mecanismos de [autenticación](https://docs.spring.io/spring-security/reference/servlet/authentication/index.html) (identificación del usuario), [autorización](https://docs.spring.io/spring-security/reference/servlet/authorization/index.html) (control de acceso) y protección frente a vulnerabilidades web como [CSRF](../../tema5/js/vulnerabilidades-csrf.html)[^1]. Algunos de ellos permiten construir las aplicaciones separando totalmente su lógica principal de su lógica de acceso (que suele delegarse en servicios externos usando SSO[^2] o OAuth[^3] o OIDC[^4]).

> ⁉️ **Ejercicio:** _Para habilitar Spring Security añade la siguiente dependencia al proyecto MVC:_
> ```xml
> <dependency>
>   <groupId>org.springframework.boot</groupId>
>   <artifactId>spring-boot-starter-security</artifactId>
> </dependency>
> ```

[^1]: Por ejemplo, añade un campo oculto a los formularios con un token que será requerido cuando se procese en el servidor. Ese campo distinguirá aquellas peticiones legítimas de las realizadas [maliciosamente](../../tema5/js/vulnerabilidades-csrf.html#token).

[^2]: [Single Sign-On](https://es.wikipedia.org/wiki/Single_Sign-On) permite que los usuarios solo se tengan que autenticar una vez para utilizar un conjunto de servicios. Utiliza mensajes con formato XML para intercambiar los tokens de autenticación (SAML), siguiendo este flujo: <details><summary><i class="fa fa-picture-o" aria-hidden="true"></i></summary><br><object type="image/svg+xml" data="./files/img/sso.excalidraw.svg" width="100%"></object><br></details>

[^3]: [Open Authorization](https://es.wikipedia.org/wiki/OAuth) permite a los usuarios autorizar a terceras aplicaciones que accedan a sus datos sin proporcionales directamente sus credenciales. Utiliza mensajes con formato JSON para intercambiar los tokens de autenticación (JWT). Usa un mecanismo diferente dependiendo de si el usuario final es una aplicación (client credentials) o una persona (authorization code, cuyo flujo es este: <details><summary><i class="fa fa-picture-o" aria-hidden="true"></i></summary><br><object type="image/svg+xml" data="./files/img/oauth.excalidraw.svg" width="100%"></object><br></details>).

[^4]: [OpenID Connect](https://openid.net/connect/faq/) es un protocolo que permite identificar usuarios (propósito similar a SSO) utilizando como mecanismo OAuth. Para ello, estandariza las peticiones y el contenido de los JWT para que contengan la información del usuario identificado.