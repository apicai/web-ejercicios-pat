# Persistencia
## Vulnerabilidades

Una de las vulnerabilidades típicas en BD relacionales es [SQL Injection](https://es.wikipedia.org/wiki/Inyecci%C3%B3n_SQL). Ocurre cuando un usuario malicioso introduce, en algún lugar del interfaz de la aplicación, un trozo de SQL que el programa acaba utilizando para llamar a la BD. 

Las librerías que implementan JPA no están expuestas, ya que son ellas las que generan el SQL final, y escapan automáticamente los parámetros que se les pasa. Pero hay situaciones[^1] en las que es necesario codificar específicamente las SQL que se envían a la BD desde el programa. A continuación, exploramos esta vulnerabilidad utilizando directamente el cliente JDBC[^2] de forma correcta e incorrecta.

```java
@DataJpaTest class JdbcTemplateTest {
  @Autowired JdbcTemplate jdbc;
  String credencialesIntroducidasPorUsuarioMalicioso = "'credenciales incorrectas' OR ID = 1";

  @Test void codigoVulnerableSqlInjectionTest() {
    // Given ...
    String sql = "SELECT * FROM USUARIO WHERE CREDENCIALES = " + credencialesIntroducidasPorUsuarioMalicioso;
    // When ...
    Map<String, Object> usuarioAutenticado = jdbc.queryForMap(sql);
    // Then ...
    assertNotNull(usuarioAutenticado);
    assertEquals(1L, usuarioAutenticado.get("ID"));
  }

  @Test void codigoProtegidoSqlInjectionTest() {
    // Given ...
    String sqlParametrizada = "SELECT * FROM USUARIO WHERE CREDENCIALES = ?";
    EmptyResultDataAccessException errorUsuarioNoEncontrado = null;
    Map<String, Object> usuarioAutenticado = null;
    // When ...
    try {
      usuarioAutenticado = jdbc.queryForMap(sqlParametrizada, credencialesIntroducidasPorUsuarioMalicioso);
    } catch (EmptyResultDataAccessException e) { errorUsuarioNoEncontrado = e; }
    // Then ...
    assertNull(usuarioAutenticado);
    assertNotNull(errorUsuarioNoEncontrado);
  }
}
```

> ⁉️ **Pregunta:** _¿Cómo se te ocurriría explotar la vulnerabilidad SQL Injection? ¿A qué otra vulnerabilidad te recuerda?_

[^1]: Por ejemplo, cuando la BD ya existe de antes, y tiene un modelo de datos difícil de representar con entidades. O cuando hay que usar SQLs específicas para optimizar el rendimiento.

[^2]: `JdbcTemplate` es el cliente que facilita Spring Data.