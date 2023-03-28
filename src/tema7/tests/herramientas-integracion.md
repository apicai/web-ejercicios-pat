# Tests

## Herramientas

### Para integración

Los tests de integración se realizan sobre varios componentes y, por tanto, son más lentos y está menos acotado el problema detectado por ellos. Pero a veces, es difícil aislar el código a testear unitariamente[^1] o, simplemente, interesa probar el comportamiento conjunto.

En el caso de Spring Boot, la dependencia [`spring-boot-starter-test`](https://docs.spring.io/spring-boot/docs/1.5.7.RELEASE/reference/html/boot-features-testing.html) nos incluye varias librerías que nos facilitan la creación de tests unitarios y de integración. Por ejemplo, `@WebMvcTest` y `MockMvc` nos permiten probar los componentes que implementan un endpoint REST sin necesidad de levantar el servidor:

```java
@WebMvcTest(ControladorRest.class)
class ControladorRestIntegrationTest {
  @Autowired
  private MockMvc mockMvc;

  @Test
  void creaContadorOkTest() throws Exception {
    String contador = "{\"nombre\":\"visitas\",\"valor\":0}";
    this.mockMvc
        .perform(MockMvcRequestBuilders.post("/api/contadores")
           .contentType(MediaType.APPLICATION_JSON)
           .content(contador))
        .andExpect(MockMvcResultMatchers.status().isCreated())
        .andExpect(MockMvcResultMatchers.content().string(contador));
  }
}
```

> ⁉️ **Ejercicio:** _Añade la clase anterior a los tests del proyecto MVC, y añade un test que verifique la respuesta cuando la petición de crear contador es incorrecta. Ejecuta los tests con informe de cobertura: botón derecho sobre la clase `ControladorRestIntegrationTest` `➜` Run with Coverage._

[^1]: Para ello, se suelen utilizar "mocks" que reemplazan a los componentes de los que depende el código a probar con versiones simples que devuelven resultados controlados por el propio test. Una librería que ayuda a crear dichos "mocks" es [Mockito](https://site.mockito.org/).