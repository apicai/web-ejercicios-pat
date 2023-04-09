# Backend

## Spring

### MVC

La implementación del patrón [MVC de Spring](https://docs.spring.io/spring-framework/docs/6.0.6/reference/html/web.html#mvc) permite crear tanto [aplicaciones SSR como APIs REST](tipos.html). Está basado en el uso de anotaciones para configurar el comportamiento del servidor:

- Inicializan el [sistema de DI](jakarta-di.html), configurando, instanciando e inyectando las dependencias presentes en el proyecto (`@SpringBootApplication`).

- Marcan las clases conteniendo la lógica de los [controladores](mvc.html#controlador) (`@Controller`, `@RestController`).

- Seleccionan las funciones que implementan la lógica de cada [endpoint/recurso](jakarta-estandares.html#mapping) (`@GetMapping`, `@PostMapping`, etc.).

- Indican qué objetos del [modelo](mvc.html#modelo) almacenarán los parámetros/contenidos de las peticiones y respuestas (`@RequestParam`, `@ModelAttribute`, `@PathVariable`, `@RequestBody`).

> ⁉️ **Ejercicio:** _[Genera el esqueleto](https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.0.5&packaging=jar&jvmVersion=17&groupId=edu.comillas.icai.gitt.pat.spring&artifactId=mvc&name=mvc&description=MVC&packageName=edu.comillas.icai.gitt.pat.spring.mvc&dependencies=web,thymeleaf) de una aplicación MVC y ábrela en [IntelliJ IDEA](https://www.jetbrains.com/es-es/idea/). Localiza: las dependencias, la lógica de la aplicación, las plantillas para las vistas, los recursos estáticos, y la configuración._
