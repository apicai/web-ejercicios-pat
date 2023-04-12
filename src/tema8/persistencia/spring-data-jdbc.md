# Persistencia
## Spring Data
### JDBC

```java
@DataJpaTest class JdbcTemplateTest {
  @Autowired JdbcTemplate jdbc;
  String credencialesIntroducidasPorUsuarioMalicioso = "'credenciales incorrectas' OR ID = 1";

  @Test void codigoVulnerableSqlInjectionTest() {
    String sql = "SELECT * FROM USUARIO WHERE CREDENCIALES = " + credencialesIntroducidasPorUsuarioMalicioso;

    Map<String, Object> usuarioAutenticado = jdbc.queryForMap(sql);

    assertNotNull(usuarioAutenticado);
    assertEquals(1L, usuarioAutenticado.get("ID"));
  }

  @Test void codigoProtegidoSqlInjectionTest() {
    String sqlParametrizada = "SELECT * FROM USUARIO WHERE CREDENCIALES = ?";
    EmptyResultDataAccessException errorUsuarioNoEncontrado = null;
    Map<String, Object> usuarioAutenticado = null;

    try {
      usuarioAutenticado = jdbc.queryForMap(sqlParametrizada, credencialesIntroducidasPorUsuarioMalicioso);
    } catch (EmptyResultDataAccessException e) { errorUsuarioNoEncontrado = e; }

    assertNull(usuarioAutenticado);
    assertNotNull(errorUsuarioNoEncontrado);
  }
}
```