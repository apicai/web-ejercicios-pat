describe('Formulario de contacto', () => {

  beforeEach(() => {
    cy.session("usuario", () => {
      cy.visit('http://localhost:8080');
      cy.get('#username').type('usuario');
      cy.get('#password').type('clave-prd');
      cy.get('.btn').click();
    });
    cy.visit('http://localhost:8080/contacto');
  });

  it('al enviar datos correctos muestra feedback positivo', () => {
    cy.get('#email').type('usuario@email.com');
    cy.get('#message').type('Probando Cypress.io');
    cy.get('input[value="Enviar"]').click();
    cy.contains('p', 'Gracias usuario@email.com, tu mensaje ha sido recibido.');
  });

  it('al enviar un email incorrecto da feedback sobre el mismo', () => {
    cy.get('#email').type('usuario');
    cy.get('#message').type('Probando Cypress.io');
    cy.get('input[value="Enviar"]').click();
    cy.contains('li', 'El formato del email es incorrecto');
  });

});