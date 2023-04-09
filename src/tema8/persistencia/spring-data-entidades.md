# Persistencia
## Spring Data
### Entidades

Representan las propiedades de una **tabla del modelo**, indicando sus tipos, nombres y restricciones. Al mismo tiempo, estos objetos contendrán los datos de sus filas cuando hagamos consultas sobre la tabla.

```java
@Entity public class Contador {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) public Long id;

  @Column(nullable = false, unique = true) public String nombre;

  @Column(nullable = false) public Long valor;
}
```

> ⁉️ **Ejercicio 1:** _Añade la clase anterior al proyecto JPA, en un paquete llamado "entidad". Arranca la aplicación, entra en la [consola de la BD](http://localhost:8080/h2-console), y explica la correspondencia entre lo que hay en BD y lo definido en la entidad._

> ⁉️ **Ejercicio 2:** _Añade las entidades de "Usuario" y "Operacion" al proyecto JPA para que se correspondan con su esquema de BD [ya diseñado](relacionales.md). Comprueba el resultado en la consola de la BD, ejecutando `SCRIPT NODATA`, y señala las diferencias con respecto al [codificado manualmente](sql.md)._

> ⁉️ **Ejercicio 3:** _Si nuestra aplicación necesitase datos iniciales en la BD, podemos añadirlos en el fichero `src/main/resources/data.sql`. Crea ese fichero con el siguiente contenido, y comprueba en la consola de la BD que se han añadido al re-arrancar la aplicación:_
> ```sql
> INSERT INTO usuario (email, credenciales) VALUES ('admin@e.m', 'Basic YWRtaW5AZS5tOmFkbWlu');
> INSERT INTO usuario (email, credenciales) VALUES ('boss@e.m', 'Basic Ym9zc0BlLm06Ym9z');
> ```

