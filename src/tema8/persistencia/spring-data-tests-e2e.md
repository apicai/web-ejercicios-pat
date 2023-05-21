# Persistencia
## Spring Data
### Tests
#### E2E

Para probar todas las capas de la aplicación levantando el servidor y configurando también una BD en memoria, se utilizan la siguientes anotaciones:

```java
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
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