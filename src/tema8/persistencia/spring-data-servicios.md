# Persistencia
## Spring Data
### Servicios

Las operaciones de BD que afecten a varias entidades, normalmente se implementan en un **componente intermedio** llamado servicio. Para el caso del API de contadores, si quisiéramos registrar las operaciones realizadas, necesitaríamos: ❶ saber quién hace la operación (entidad `Usuario`), ❷ realizar la operación (entidad `Contador`), ❸ registrar la operación (entidad `Operación`). A continuación, refactorizamos su código para dividirlo en: 

```
ControladorContadores ➜ ServicioContadores ➜ RepoUsuario/RepoContador/RepoOperacion
```

1. Crea los `RepoUsuario` y `RepoOperacion` igual que el de [contadores](spring-data-repositorios.md#crud).

1. Crea la siguiente clase en el paquete "servicio":
   ```java
   @Service public class ServicioContadores {
     @Autowired RepoUsuario repoUsuario;
     @Autowired RepoContador repoContador;
     @Autowired RepoOperacion repoOperacion;

     public Usuario  autentica(String credenciales) { throw new ResponseStatusException(HttpStatus.UNAUTHORIZED); }
     public Contador crea(Contador contadorNuevo, Usuario usuario) { return null; }
     public Contador lee(String nombre, Usuario usuario) { throw new ResponseStatusException(HttpStatus.NOT_FOUND); }
     public Contador incrementa(Contador contador, Long incremento, Usuario usuario) { return null; }
     public void     borra(Contador contador, Usuario usuario) { }
   }
   ```

> **❓ Ejercicio 1:** _Implementa `autentica` para que devuelva el usuario cuyas credenciales coinciden con las pasadas. En caso de que no haya ninguna coincidencia, lanza la excepción indicada._

> **❓ Ejercicio 2:** _Implementa `crea` para que además de guardar el contador nuevo, registre la operación en BD indicando el contador, el usuario, el tipo de operación y su fecha._

> **❓ Ejercicio 3:** _Implementa `lee` para que además de obtener el contador por nombre, registre la operación en BD igual que antes. En caso de que no exista el contador, lanza la excepción indicada._

> **❓ Ejercicio 4:** _Implementa `incrementa` para que además de actualizar el contador, registre la operación en BD igual que antes._

> **❓ Ejercicio 5:** _Implementa `borra` para que además de eliminar el contador, registre la operación en BD igual que antes._

> **❓ Ejercicio 6:** _Modifica `ControladorContadores` para que utilice `ServicioContadores`. Para cada recurso del API REST: añade el parámetro `@RequestHeader("Authorization") String credenciales` para autenticar al usuario de la petición, y utiliza los métodos del servicio para implementar su funcionalidad. Prueba el API con autenticación básica: usuario `admin@e.m` y clave `admin`._

> **❓ Ejercicio 7:** _Obtén la excepción que se produce al crear dos contadores con mismo nombre. Crea un `@ExceptionHandler` en `ControladorContadores` para que cuando se produzca retorne un `@ResponseStatus(HttpStatus.CONFLICT)`._