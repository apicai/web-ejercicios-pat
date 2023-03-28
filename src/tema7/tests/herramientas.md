# Tests

## Herramientas

Existen servicios, aplicaciones y librerías específicas que facilitan:

- **La creación de cada tipo de test.** Por ejemplo, [JUnit](https://junit.org/junit5/) facilita crear tests unitarios en aplicaciones Java, [Selenium](https://www.selenium.dev/) para tests E2E de aplicaciones web, [JMeter](https://jmeter.apache.org/) para tests de rendimiento, etc.

- **La utilización de un tipo concreto de metodología de pruebas.** Para BDD, por ejemplo, [Cucumber](https://cucumber.io/) facilita la implementación y la ejecución del lenguaje natural que define los escenarios a probar.

- **La automatización de la ejecución de los tests.** [Jenkins](https://www.jenkins.io/) o el servicio de Github-Actions, por ejemplo, permiten crear un flujo de [integración](../../intro/git/ci.html) y [despliegue](../../intro/git/cd.html) continuos[^1].

- **La generación de informes con métricas de la calidad.** Por ejemplo, [SonarQube](https://docs.sonarqube.org/latest/) analiza el código para: buscar vulnerabilidades, calcular su complejidad y la cobertura de los tests[^2].

[^1]: La [CI/CD](../../intro/git/cicd.html) requiere de una batería de tests que permita determinar si los cambios introducidos continuamente por el equipo de desarrollo no rompen el software actualmente desplegado, y en ese caso, proceder a su instalación automática.

[^2]: La cobertura es el porcentaje de líneas de código que son ejecutadas/probadas por los tests.