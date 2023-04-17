# Persistencia
## Spring Data
### Tests
#### Integración

Para probar sólo las entidades y sus repositorios, se utiliza la anotación `@DataJpaTest` que automáticamente configura una BD en memoria cuyos datos se resetean en cada test.

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