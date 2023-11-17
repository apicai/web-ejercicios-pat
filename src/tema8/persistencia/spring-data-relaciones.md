# Persistencia
## Spring Data
### Relaciones

La capacidad de **asociar datos entre tablas** es una de las características de las BD relacionales. Por ejemplo, nuestro [modelo](relacionales.md) define una relación N a 1 de las operaciones con sus usuarios y contadores. Sin embargo, dichas relaciones todavía no se han especificado en nuestras [entidades JPA](spring-data-entidades.md). Para verlo, vamos a implementar un nuevo endpoint que devuelva todas las operaciones que se han realizado sobre un contador.

> **❓ Ejercicio 1:** _Implementa en el API un recurso `GET /api/contadores/{nombre}/operaciones` que devuelva la lista de `Operacion` cuyo `contadorId` sea igual al del contador indicado en la petición. Prueba el nuevo endpoint, e indica el inconveniente de la respuesta JSON generada._

Para definir las relaciones entre los campos de las entidades se utilizan anotaciones: `@ManyToOne`, `@OneToOne`, `@ManyToMany`, etc. Por ejemplo, para las relaciones de nuestro modelo:

```java
@Entity public class Operacion {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) public Long id;
  @ManyToOne(optional = false) public Usuario usuario;
  @ManyToOne(optional = false) public Contador contador;
  @Column(nullable = false) public String tipo;
  @Column(nullable = false) public Timestamp fecha;
}
```

> **❓ Ejercicio 2:** _Cambia la entidad `Operacion` del proyecto JPA para que tenga las relaciones anteriores, y arregla el resto del código del API para que siga funcionando. Vuelve a probar el endpoint de operaciones del ejercicio 1, y observa los cambios en la respuesta JSON._

La BD, además de relacionar filas en diferentes tablas, evita[^1] que dichas referencias se rompan al actualizar o borrar. A continuación, vemos cómo las anotaciones JPA han incluido automáticamente dichas referencias y restricciones en la BD.

> **❓ Ejercicio 3:** _Intenta borrar un contador con el API REST. Explica porqué ahora falla mirando los logs del servidor. Añade esta anotación `@OnDelete(action = OnDeleteAction.CASCADE)` al campo `contador` de la entidad `Operacion`. Vuelve a intentar borrar el contador anterior, y explica el resultado mirando los contenidos de la tabla `Operacion` en la [consola de BD](http://localhost:8080/h2-console)._

[^1]: A esta característica se le llama [integridad referencial](https://es.wikipedia.org/wiki/Integridad_referencial).




