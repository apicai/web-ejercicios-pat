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
    restTemplate.exchange(
      "http://localhost:8080/api/contadores", HttpMethod.POST,
      new HttpEntity<>(new ModeloContador("visitas", 0L)), ModeloContador.class
    );
    // When ...
    ResponseEntity<ModeloContador> response = restTemplate.exchange(
      "http://localhost:8080/api/contadores/visitas",
      HttpMethod.GET, HttpEntity.EMPTY, ModeloContador.class);
    // Then ...
    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    Assertions.assertEquals("visitas", response.getBody().nombre());
    Assertions.assertEquals(0L, response.getBody().valor());    
  }
}
```

> ⁉️ **Ejercicio:** _Añade la clase anterior a los tests del proyecto MVC, e implementa un test que verifique la respuesta cuando se intenta recuperar un contador no existente. Vuelve a ejecutar los tests con informe de cobertura para ver si ha aumentado._
