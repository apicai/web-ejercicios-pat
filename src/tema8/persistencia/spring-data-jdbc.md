# Persistencia
## Spring Data
### JDBC

Hay situaciones en las que es mejor no usar JPA[^1] y, en su lugar, codificar directamente las SQL que necesita el programa. Para enviarlas a la BD, Spring Data nos facilita el cliente JDBC `JdbcTemplate`.

Una de las vulnerabilidades típicas en este contexto es el SQL Injection[^2]. A continuación, exploramos esta vulnerabilidad utilizando `JdbcTemplate` de forma incorrecta y de forma correcta.

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

[^1]: Cuando la BD ya ha sido creada, y tiene un modelo de datos difícil de representar con entidades, cuando hay que usar SQLs específicas para optimizar, etc.

[^2]: Ocurre cuando un usuario malicioso introduce en algún lugar del interfaz de la aplicación, un SQL que acaba llegando al código que llama a la BD.