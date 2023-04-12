# Backend

## Spring

### Configuración

La lógica de una aplicación suele necesitar datos de configuración (URLs, credenciales, modos de funcionamiento, etc.). Estos datos pueden cambiar a menudo, por ejemplo, dependiendo del entorno en el que se ejecuta: desarrollo, pruebas, producción, etc. Para no tener que recompilar la aplicación cada vez que cambian, es conveniente externalizarlos en el fichero de propiedades de la aplicación Spring.

Spring permite utilizar diferentes perfiles de configuración:

- Los ficheros `application-{perfil}.properties` contendrán las propiedades de configuración específicas para cada perfil.

- El fichero `application.properties` contendrá las propiedades de configuración comunes a todos los perfiles.

- La variable de entorno `SPRING_PROFILES_ACTIVE=perfil` permite indicar los perfiles cuyas propiedades se cargarán al arrancar la aplicación.

Para leer las propiedades anteriores en el código se utiliza la anotación `@Value`. Por ejemplo, el siguiente código inyectaría `valor` en `propiedadABC` si la propiedad `a.b.c=valor` se hubiera cargado de los ficheros de propiedades al arrancar:

```java
@Value("${a.b.c}") private String propiedadABC;
```

> ⁉️ **Ejercicio 1:** _Externaliza alguna configuración del código del proyecto MVC._

> ⁉️ **Ejercicio 2:** _Crea un fichero de propiedades para un nuevo perfil y añade las propiedades externalizadas anteriormente con otros valores. Arranca la aplicación para que utilice el nuevo perfil._