# Backend

## Spring

### MVC

#### SSR

Para generar la presentación en el servidor, normalmente se utiliza un lenguaje para procesar textos. Spring permite configurar uno de entre [varias librerías](https://docs.spring.io/spring-framework/docs/6.0.6/reference/html/web.html#mvc-view). En nuestro caso usaremos [Thymeleaf](https://www.thymeleaf.org/index.html).

Vamos a crear un endpoint/recurso SSR `/saludo?nombre=tu-nombre` que devuelva un HTML mostrando un párrafo con el texto "¡Hola, tu-nombre!". Sobre el proyecto MVC generado anteriormente:

1. Crea el fichero `saludo.html` en el directorio de plantillas:

    ```html
    <!DOCTYPE html>
    <html lang="es" xmlns:th="http://www.thymeleaf.org">
    <head><meta charset="UTF-8"><title>Saludo</title></head>
    <body><p th:text="'¡Hola, ' + ${nombre} + '!'"></p></body>
    </html>
    ```

1. Crea la siguiente clase dentro del directorio con la lógica de la aplicación MVC:

    ```java
    @Controller
    public class ControladorSSR {
      @GetMapping("/saludo")
      public String saludo(
        @RequestParam(name="nombre", required=false, defaultValue="Mundo") 
        String nombre, 
        Model model
      ) {
        model.addAttribute("nombre", nombre);
        return "saludo";
      }
    }
    ```

> ⁉️ **Ejercicio 1:** _Compila y ejecuta el proyecto desde el IDE. Abre en un navegador la URL [`http://localhost:8080/saludo?nombre=tu-nombre`](http://localhost:8080/saludo?nombre=tu-nombre). Pon un punto de ruptura dentro de la función `saludo` y ejecuta en modo depuración. Comprueba qué pasa cuando no se envía ningún nombre. Modifica el código para que el nombre sea obligatorio._

> ⁉️ **Ejercicio 2:** _Identifica qué partes del código se corresponden con las partes del [flujo MVC](mvc.html)._


