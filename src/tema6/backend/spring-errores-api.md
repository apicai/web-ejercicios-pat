# Backend

## Spring

### Errores

#### API

Para controlar las respuestas JSON de error, se pueden definir localmente dentro de cada `RestController` o bien desde un manejador global de excepciones no capturadas (anotado con `@ControllerAdvice`).

Vamos a personalizar las respuestas de error del API de contadores para los siguientes casos de error:

1. Se intenta acceder a un contador que no existe.
1. Se intenta crear un contador que ya existe.
1. Se proporcionan datos incorrectos para crear un contador.

Para ello, sobre el proyecto MVC realiza los siguientes cambios:

1. Añade esta excepción para el primer caso de error:

   ```java
   public class ExcepcionContadorNoExistente extends RuntimeException {
     public ExcepcionContadorNoExistente(String msg) {
       super(msg);
     }
   }
   ```

1. Añade esta clase al modelo para personalizar la respuesta JSON de error:
   
   ```java
   public record ModeloError(String error) { }
   ```

1. Añade esta función dentro de `ControladorRest` para controlar localmente los errores de tipo `ExcepcionContadorNoExistente`:

   ```java
   @ExceptionHandler(ExcepcionContadorNoExistente.class)
   @ResponseStatus(HttpStatus.NOT_FOUND)
   public ModeloError contadorNoExistente(ExcepcionContadorNoExistente ex) {
     return new ModeloError(ex.getMessage());
   }
   ```

1. Añade esta clase para controlar globalmente todos los errores de tipo `ResponseStatusException`:

   ```java
   @ControllerAdvice
   public class ManejadorErroresGlobales {
     @ResponseBody
     @ExceptionHandler(ResponseStatusException.class)
     public ResponseEntity errorLanzado(ResponseStatusException ex) {
       return new ResponseEntity<>(ex.getStatusCode());
     }
   }
   ```

> ⁉️ **Ejercicio 1:** _Modifica el código de las funciones `contador` e `incrementa` de `ControladorRest` para que, en caso de que no exista el contador, lancen la excepción `ExcepcionContadorNoExistente`._

> ⁉️ **Ejercicio 2:** _Modifica el código de las funciones `crea` de `ControladorRest` para que, en caso de que el contador exista, lance la excepción `ResponseStatusException(HttpStatus.CONFLICT)`._

> ⁉️ **Ejercicio 3:** _Modifica el código de las funciones `crea` de `ControladorRest` para que, en caso de que la validación falle, lance la excepción `ResponseStatusException(HttpStatus.BAD_REQUEST)`._
