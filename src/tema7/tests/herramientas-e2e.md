# Tests

## Herramientas

### Para E2E

Estos tests suelen ser más lentos y de mantenimiento costoso ya que prueban funcionalidades que abarcan sistemas enteros y, por tanto, tienen mayor probabilidad de cambios en su comportamiento.

**Para interfaces de usuario web**, existen herramientas como [Cypress](https://www.cypress.io/) que automatizan interacciones sobre la página web a testear. El siguiente código prueba el envío y respuesta de un formulario:

```js
describe('Formulario de contacto', () => {
  it('al enviar datos correctos muestra feedback positivo', () => {
    cy.visit('http://localhost:8080/contacto');
    cy.get('#email').type('usuario@email.com');
    cy.get('#message').type('Probando Cypress.io');
    cy.get('input[value="Enviar"]').click();
    cy.contains('p', 'Gracias usuario@email.com, tu mensaje ha sido recibido.');
  });
});
```

> ⁉️ **Ejercicio 1:** _[Descarga Cypress](https://download.cypress.io/app) y añade el proyecto MVC para hacer "E2E Testing". Elige un navegador para ejecutarlo y crea una nueva "spec". Ábrela con un editor y copia el contenido JavaScript anterior. Arranca el proyecto MVC en el IDE. Y ejecuta la "spec" anterior. Añade un test adicional que valide el comportamiento cuando se introduce un email incorrecto._

**Para interfaces/APIs REST**, existen herramientas gráficas como Postman para probar manual y [automáticamente](https://medium.com/better-practices/from-manual-to-automated-testing-the-roadblocks-and-the-journey-6333dfacc5ae). Spring también facilita hacer tests E2E levantando automáticamente el servidor:

```java
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class ControladorRestE2ETest {
  @Autowired
  private final TestRestTemplate restTemplate;

  @Test
  public void contadorExistenteTest() throws Exception {
    restTemplate.exchange(
      "http://localhost:8080/api/contadores", HttpMethod.POST,
      new HttpEntity<>(new ModeloContador("visitas", 0L)), ModeloContador.class
    );

    Assertions.assertEquals(
      HttpStatus.OK,
      restTemplate.exchange(
        "http://localhost:8080/api/contadores/visitas", HttpMethod.GET,
        HttpEntity.EMPTY, Void.class).getStatusCode());
  }
}
```

> ⁉️ **Ejercicio 2:** _Añade la clase anterior a los tests del proyecto MVC, y añade un test que verifique la respuesta cuando se intenta recuperar un contador no existente. Vuelve a ejecutar los tests con informe de cobertura para ver si ha aumentado._
