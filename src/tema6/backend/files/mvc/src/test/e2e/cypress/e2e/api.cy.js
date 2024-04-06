describe('Web estadísticas', () => {

  beforeEach(() => {
    cy.session("usuario", () => {
      cy.visit('http://localhost:8080/login');
      cy.get('#username').type('usuario');
      cy.get('#password').type('clave-prd');
      cy.get('.btn').click();
    });
    cy.visit('http://localhost:8080/index.html');
  });

  it('Navegación por secciones', () => {
    cy.contains('Nosotros').click();
    cy.url().should('include', '#nosotros');
    cy.contains('Productos').click();
    cy.url().should('include', '#productos');
    cy.contains('Contacto').click();
    cy.url().should('include', '#contacto');
    cy.contains('Estadísticas').click();
    cy.url().should('include', '#estadisticas');
  });

  it('Obtener estadísticas', () => {
    cy.contains('Estadísticas').click();
    cy.get('#input-contador').type('nosotros');
    cy.contains('Valor').click();
    cy.contains('El valor de "nosotros" es: ');
    cy.get('#input-contador').clear().type('estadisticas');
    cy.contains('Valor').click();
    cy.contains('El valor de "estadisticas" es: ');
  });

  it('Borrar estadísticas', () => {
    cy.contains('Estadísticas').click();
    cy.get('#input-contador').type('nosotros');
    cy.contains('Borrar').click();
    cy.contains('Contador "nosotros" borrado.');
    cy.get('#input-contador').clear().type('estadisticas');
    cy.contains('Borrar').click();
    cy.contains('Contador "estadisticas" borrado.');
  });  

});