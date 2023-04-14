# Persistencia
## Spring Data
### Tests

Para hacer **tests de integración de JPA** se utiliza la anotación `@DataJpaTest` que automáticamente configura una BD en memoria cuyos datos se resetean en cada test.

```java
@DataJpaTest class RepoOperacionTest {
  @Autowired RepoOperacion repoOperacion;

  @Test void jpaTest() {
    // Given ...
    Usuario usuario = new Usuario();
    usuario.id = 1L;
    Contador contador = new Contador();
    contador.id = 200L;
    Operacion operacion = new Operacion();
    operacion.tipo = "creación";
    operacion.fecha = Timestamp.from(Instant.now());
    operacion.contador = contador;
    operacion.usuario = usuario;
    // When ...
    DataIntegrityViolationException error = null;
    try { 
      repoOperacion.save(operacion); 
    } catch (DataIntegrityViolationException e) { error = e; }
    // Then ...
    assertNotNull(error);
  }
}
```

> ⁉️ **Pregunta:** _Teniendo en cuenta el modelo de datos de contadores, ¿qué característica está probando el test anterior?_

Para hacer **tests E2E**, levantando el servidor y configurando también una BD en memoria, se utilizan la siguientes anotaciones:

```java
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureTestDatabase
class ControladorContadoresTest {
  private final TestRestTemplate restTemplate = new TestRestTemplate("admin@e.m", "admin");

  @Test public void contadorNoExistenteTest() {
    // When ...
    ResponseEntity<Void> response = restTemplate.exchange(
      "http://localhost:8080/api/contadores/no-existo",
      HttpMethod.GET, HttpEntity.EMPTY, Void.class);
    // Then ...
    Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
  }
}
```