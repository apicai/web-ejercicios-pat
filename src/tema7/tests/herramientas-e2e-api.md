# Tests

## Herramientas

### Para E2E

#### API

Para interfaces REST, existen herramientas gráficas como Postman que permiten probar manual y [automáticamente](https://medium.com/better-practices/from-manual-to-automated-testing-the-roadblocks-and-the-journey-6333dfacc5ae). Spring Boot también facilita hacer tests E2E levantando automáticamente el servidor:

```java
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class ControladorRestE2ETest {
  @Autowired private final TestRestTemplate restTemplate;

  @Test public void contadorExistenteTest() {
    // Given ...
    String contador = "{\"nombre\":\"visitas\",\"valor\":0}";
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    restTemplate.exchange(
      "http://localhost:8080/api/contadores", HttpMethod.POST,
      new HttpEntity<>(contador, headers), String.class);
    // When ...
    ResponseEntity<String> response = restTemplate.exchange(
      "http://localhost:8080/api/contadores/visitas",
      HttpMethod.GET, HttpEntity.EMPTY, String.class);
    // Then ...
    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    Assertions.assertEquals(contador, response.getBody());
  }
}
```

> **❓ Ejercicio:** _Añade la clase anterior a los tests del proyecto MVC, e implementa un test que verifique la respuesta cuando se intenta recuperar un contador no existente. Vuelve a ejecutar los tests con informe de cobertura para ver si ha aumentado._
