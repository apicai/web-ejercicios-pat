# Persistencia
## Spring Data
### Transacciones

Son un **conjunto de operaciones** en las que se asegura que, en caso de que falle una de ellas, los cambios realizados por las anteriores se deshagan, evitando dejar la BD inconsistente o con valores discrepantes en sus nodos (en bases de datos distribuidas).

Por ejemplo, para el caso del API de contadores, sería necesario incluir en la misma transacción la operación sobre el contador y su registro, ya que si esta última falla habría que deshacer el cambio en el contador para que no quedara sin su correspondiente registro de autoría.

> ⁉️ **Ejercicio 1:** _Añade una excepción al código que guarda la operación en `ServicioContadores`, y comprueba el comportamiento en la [consola de BD](http://localhost:8080/h2-console)._

> ⁉️ **Ejercicio 2:** _Añade la anotación `@Transactional` a las operaciones que lo necesiten en `ServicioContadores`. Vuelve a realizar los pasos del ejercicio 1, y comprueba la diferencia de comportamiento._