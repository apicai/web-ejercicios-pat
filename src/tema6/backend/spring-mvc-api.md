# Backend

## Spring

### MVC

#### API

Al anotar una clase con `@RestController`, automáticamente se configura para procesar las peticiones y respuestas en formato JSON (los objetos del modelo deberán contener los campos que representan esos JSON).

Vamos a crear un API REST que registra contadores para analítica de uso:

| Método | URL | Descripción |
|--------|-----|-------------|
| `POST` | `/contadores` | Crea un contador con el nombre y valor inicial proporcionado en el cuerpo |
| `GET`  | `/contadores/${nombre}` | Devuelve el valor actual del contador indicado |
| `PUT`  | `/contadores/${nombre}/incrementa` | Incrementa el valor del contador indicado en 1 |

1. Crea la siguiente clase dentro del directorio con la lógica de la aplicación MVC:

   ```java
   public record ModeloContador(String nombre, Long valor) { }
   ```

1. Crea la siguiente clase dentro del directorio con la lógica de la aplicación MVC:

   ```java
   @RestController
   public class ControladorRest {
     private final Map<String, ModeloContador> contadores = new HashMap<>();

     @PostMapping("/contadores")
     @ResponseStatus(HttpStatus.CREATED)
     public ModeloContador crea(@RequestBody ModeloContador contadorNuevo) {
        contadores.put(contadorNuevo.nombre(), contadorNuevo);
        return contadorNuevo;
     }

     @GetMapping("/contadores/{nombre}")
     public ModeloContador contador(@PathVariable String nombre) {
       return contadores.get(nombre);
     }

     @PutMapping("/contadores/{nombre}/incrementa")
     public ModeloContador incrementa(@PathVariable String nombre) {
       ModeloContador contadorActual = contadores.get(nombre);
       ModeloContador contadorIncrementado = new ModeloContador(nombre, contadorActual.valor() + 1);
       contadores.put(nombre, contadorIncrementado);
       return contadorIncrementado;
     }
   }
   ```

> ⁉️ **Ejercicio 1:** _Compila y ejecuta el proyecto desde el IDE. Utilizando [Postman](https://www.postman.com/), [Httpie](https://httpie.io/) u otra aplicación para hacer peticiones HTTP, prueba el API llamando a `http://localhost:8080/contadores/*` con el método, path y cuerpo correctos._

> ⁉️ **Ejercicio 2:** _Crea un nuevo endpoint para que se pueda eliminar un contador utilizando la anotacion `@DeleteMapping`._

> ⁉️ **Ejercicio 3:** _¿Qué problema de concurrencia tiene el código anterior? ¿Cómo lo arreglarías?_