# Tests

## Herramientas

### Para E2E

#### UI

Para probar interfaces web, existen herramientas como [Cypress](https://www.cypress.io/) que automatizan interacciones sobre la página a testear. El siguiente código prueba el envío y respuesta de un formulario:

```js
describe('Formulario de contacto', () => {
  it('al enviar datos correctos muestra feedback positivo', () => {
    // Given ...
    cy.visit('http://localhost:8080/contacto');
    // When ...
    cy.get('#email').type('usuario@email.com');
    cy.get('#message').type('Probando Cypress.io');
    cy.get('input[value="Enviar"]').click();
    // Then ...
    cy.contains('p', 'Gracias usuario@email.com, tu mensaje ha sido recibido.');
  });
});
```

> **❓ Ejercicio 1:** _[Descarga Cypress](https://download.cypress.io/app) y añade el proyecto MVC para hacer "E2E Testing". Elige un navegador para ejecutarlo y crea una nueva "spec". Ábrela con un editor y copia el contenido JavaScript anterior. Arranca el proyecto MVC en IntelliJ. Y ejecuta la "spec" anterior. Implementa un test adicional que valide el comportamiento cuando se introduce un email incorrecto._

> **❓ Ejercicio 2:** _[Descarga este frontend](./files/frontend.zip) que utiliza el API de contadores. Para desplegarlo junto al API, copia su contenido en el directorio de recursos estáticos del proyecto MVC. Arranca el proyecto MVC en IntelliJ, [abre](http://localhost:8080/index.html) dicha web en el navegador e interacciona con ella. Implementa una "spec" de Cypress para probar alguna de sus funcionalidades._