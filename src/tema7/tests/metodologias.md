# Tests

## Metodologías

Existen varias estrategias para implementar los tests durante el desarrollo del software, dos de ellas son:

- **Test-Driven Development (TDD):** utiliza un ciclo de 3 pasos consistente en ❶ implementar el test unitario, ❷ implementar el código que hace que no falle el test, ❸ hacer modificaciones progresivas para mejorar su calidad y mantenimiento.

- **Behavior-Driven Development (BDD):** define los escenarios para probar el comportamiento esperado por los usuarios utilizando un lenguaje natural entendible por todos[^1].

Por otro lado, se suelen dividir los casos a probar en función de los parámetros de entrada que puede recibir el software a testear, validando el comportamiento para:

- Valores válidos e inválidos.
- Valores límite: máximos, mínimos, etc.
- Combinaciones de parámetros con valores inusuales.
- Valores que pueden afectar al rendimiento o la seguridad.

[^1]: Suele estructurarse en pasos "given-when-then", por ejemplo: "dado" que estamos en la página de login, "cuando" el usuario introduce incorrectamente sus credenciales, "entonces" se muestra el mensaje de error 'Usuario o contraseña incorrectos'.