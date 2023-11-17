# Backend

## Spring

### Seguridad

#### Autorización

Spring Security permite crear usuarios con diferentes roles, de modo que se pueda configurar su acceso a los recursos de forma diferente. Para ello se utilizan las siguientes anotaciones:

- `@PreAuthorize("hasRole('ROL')")`: para permitir el acceso solo a usuarios con rol 'ROL' a los endpoints/recursos con esta anotación.

- `@EnableMethodSecurity`: en la clase de configuración de Spring Security, para habilitar la anterior anotación.

> **❓ Ejercicio:** _Añade la anotación `@EnableMethodSecurity` a la clase `ConfiguracionSeguridad` y un nuevo usuario con rol `ADMIN`. Anota uno de los recursos del proyecto MVC con `@PreAuthorize("hasRole('ADMIN')")`. Intenta acceder con el usuario anterior y con el nuevo. Explica el diferente código de error HTTP devuelto cuando hay un error de autenticación de cuando hay un error de autorización._