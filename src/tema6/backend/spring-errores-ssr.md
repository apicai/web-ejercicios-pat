# Backend

## Spring

### Errores

#### SSR

Para definir páginas personalizadas de error:

1. Añade la siguiente propiedad a la configuración de la aplicación Spring Boot, para deshabilitar las páginas de error por defecto:

   ```properties
   server.error.whitelabel.enabled=false
   ```

2. Crea la página `error.html` en el directorio de plantillas. Está se mostrará cuando se produzca un error no controlado.

3. Crea la página `error/404.html` en el directorio de plantillas. Esta se mostrará cuando se intente acceder a un recurso no existente.

> ⁉️ **Ejercicio 1:** _Ejecuta el proyecto desde el IDE. Abre en un navegador la URL [`http://localhost:8080/no-existo`](http://localhost:8080/no-existo). Comprueba la diferencia antes y después de aplicar los cambios anteriores._

> ⁉️ **Ejercicio 2:** _Provoca una excepción en el código del endpoint/recurso [`http://localhost:8080/saludo`](http://localhost:8080/saludo) y comprueba el resultado antes y después de aplicar los cambios anteriores._
