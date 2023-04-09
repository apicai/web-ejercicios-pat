# Persistencia
## Spring Data
### Repositorios

Representan **las operaciones** de persistencia que se pueden realizar sobre las entidades. El interfaz `CrudRepository` de Spring Data JPA ya viene con las operaciones básicas para crear, leer, actualizar y borrar (<abbr title="Create Read Update Delete">CRUD</abbr>) su entidad asociada. Para ver cómo se usa, vamos a mejorar el API de contadores para que los guarde en BD:

1. Crea el repositorio CRUD de la entidad `Contador` en un paquete llamado "repositorio": <a name="crud"></a>
   ```java
   public interface RepoContador extends CrudRepository<Contador, Long> {}
   ```
2. Crea el controlador del API REST de contadores en un paquete llamado "controlador":
   ```java
   @RestController public class ControladorContadores {
     @Autowired RepoContador repoContador;

     @PostMapping("/api/contadores") @ResponseStatus(HttpStatus.CREATED)
     public Contador crea(@RequestBody Contador contadorNuevo) { return null; }

     @GetMapping("/api/contadores/{nombre}")
     public Contador lee(@PathVariable String nombre) { return null; }

     @PutMapping("/api/contadores/{nombre}/incremento/{incremento}")
     public Contador incrementa(@PathVariable String nombre, @PathVariable Long incremento) { return null; }

     @DeleteMapping("/api/contadores/{nombre}")
     public void borra(@PathVariable String nombre) { }
   }
   ```

> ⁉️ **Ejercicio 1:** _Implementa el método `crea` utilizando la operación de guardar entidad de `repoContador`[^1]. Arranca la aplicación JPA y llama al endpoint del API para crear un contador. Reinicia la aplicación y vuelve a crear el mismo contador. Explica el comportamiento ayudándote de las trazas del servidor._

> ⁉️ **Ejercicio 2:** _Para implementar el método `lee` necesitamos consultar por nombre, y `RepoContador` no tiene esa consulta particular. Para añadir una, basta con crear un [método con nombre específico](https://docs.spring.io/spring-data/data-jpa/docs/current/reference/html/#jpa.query-methods.query-creation) en el repositorio: `Contador findByNombre(String nombre)`. Añádelo a `RepoContador` y úsalo para implementar `lee`. ¿Cuál sería su `select` equivalente?_

> ⁉️ **Ejercicio 3:** _Implementa el método `incrementa`, primero leyendo (ejercicio 2), y luego guardando (ejercicio 1) la entidad **incrementada**._

> ⁉️ **Ejercicio 4:** _JPA permite utilizar [queries "SQL"](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.at-query) para consultas más complejas que no puedan hacerse con los mecanismos anteriores. Para implementar `borra`[^2], añade el siguiente método al repositorio, y completa su "SQL" para que borre por nombre del contador: `@Query("SQL") @Transanctional @Modifying int borraPorNombre(String nombre)`._

[^1]: Su valor ha sido inyectado automáticamente por el contenedor de Spring con la implementación automática del repositorio del punto 1.

[^2]: Para borrar por nombre, también podríamos usar la misma mécanica del ejercicio 2, pero con "delete": `@Transactional void deleteByNombre(String nombre)`.