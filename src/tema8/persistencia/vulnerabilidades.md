# Persistencia
## Vulnerabilidades

Una de las vulnerabilidades típicas en BD relacionales es [SQL Injection](https://es.wikipedia.org/wiki/Inyecci%C3%B3n_SQL). Ocurre cuando un usuario malicioso introduce, en algún lugar del interfaz de la aplicación, un SQL que acaba llegando al código que llama a la BD. 

Las librerías que implementan JPA no están expuestas, ya que son ellas las que generan automáticamente el SQL final. Pero hay situaciones[^1] en las es necesario codificar directamente las SQL que necesita nuestro programa. A continuación, exploramos esta vulnerabilidad utilizando `JdbcTemplate`[^2] de forma incorrecta y de forma correcta.

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

[^1]: Por ejemplo, cuando la BD ya existe de antes y tiene un modelo de datos difícil de representar con entidades. O cuando hay que usar SQLs específicas para optimizar el rendimiento.

[^2]: El cliente de JDBC facilitado por Spring Data, que nos permite enviar sentencias SQL directamente a la BD.