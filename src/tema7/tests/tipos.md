# Tests

## Tipos

Estas son algunas de las formas de clasificarlos:

- **Tests funcionales** (verifican que el software cumple los requisitos), y **no funcionales** (verifican su calidad en términos de velocidad, capacidad, seguridad, etc.).

- **Tests unitarios** (prueban un componente del código aisladamente), **de integración** (comprueban una parte de la funcionalidad implementada por varios componentes), **extremo a extremo** (prueban una funcionalidad completa implementada por varios sistemas)[^1].

- **Tests de caja blanca** (se realizan sobre partes internas del código, como en el caso de los tests unitarios o de integración), y **de caja negra** (se realizan sobre los interfaces de uso del software, como su UI o API, que son los utilizados en los tests <abbr title="End to End">E2E</abbr>).

- **Sanity/smoke tests** (prueban la funcionalidad básica/fundamental de la aplicación para garantizar que es estable), y **de regresión** (prueban que los cambios realizados al software no rompen funcionalidades previas).

[^1]: En general, los proyectos suelen tener esta relación de número de tests: **unitarios** (más rápidos y fáciles de hacer/mantener) **`>`** **integración** **`>`** **E2E** (más lentos y difíciles de hacer/mantener).