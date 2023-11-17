# Backend

## Spring

### Errores

#### API

Las respuestas JSON de error se pueden definir localmente dentro de cada `RestController` o bien desde un manejador global de excepciones no capturadas (anotado con `@ControllerAdvice`). Vamos a personalizar las respuestas de error del API de contadores para los siguientes casos de error:

- Se proporcionan datos incorrectos para crear un contador.
- Se intenta crear un contador que ya existe.
- Se intenta usar a un contador que no existe.

Para ello, sobre el proyecto MVC realiza los siguientes cambios:

1. Añade esta excepción para el primer caso de error:

   ```java
   public class ExcepcionContadorIncorrecto extends RuntimeException {
     private List<FieldError> errores;
     public ExcepcionContadorIncorrecto(BindingResult result) {
       this.errores = result.getFieldErrors();
     }
     public List<FieldError> getErrores() {
       return errores;
     }
   }
   ```

1. Añade este record al modelo para personalizar la respuesta JSON de error:
   
   ```java
   public record ModeloCampoIncorrecto(String error, String campo, Object valor) { }
   ```

1. Añade esta función dentro de `ControladorRest` para controlar localmente los errores de tipo `ExcepcionContadorIncorrecto`:

   ```java
   @ExceptionHandler(ExcepcionContadorIncorrecto.class)
   @ResponseStatus(HttpStatus.BAD_REQUEST)
   public List<ModeloCampoIncorrecto> contadorIncorrecto(ExcepcionContadorIncorrecto ex) {
     return ex.getErrores().stream().map(error -> new ModeloCampoIncorrecto(
         error.getDefaultMessage(), error.getField(), error.getRejectedValue()
       )).toList();
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

> **❓ Ejercicio 1:** _Modifica el código de la función `crea` de `ControladorRest` para que, en caso de que la validación falle, lance la excepción `ExcepcionContadorIncorrecto(bindingResult)`._

> **❓ Ejercicio 2:** _Modifica el código de la función `crea` de `ControladorRest` para que, en caso de que el contador ya exista, lance la excepción `ResponseStatusException(HttpStatus.CONFLICT)`._

> **❓ Ejercicio 3:** _Modifica el código de las funciones `contador` e `incrementa` de `ControladorRest` para que, en caso de que no exista el contador, lancen la excepción `ResponseStatusException(HttpStatus.NOT_FOUND)`._


