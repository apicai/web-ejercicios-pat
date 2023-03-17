# Backend

## Spring

### Validaciones

#### SSR

Vamos a crear un formulario y validar los campos introducidos por el usuario en el servidor, ya que es [obligatorio](../../tema5/js/vulnerabilidades-validaciones.html). En el proyecto MVC, haz los siguientes cambios:

1. Crea el fichero `contacto.html` en el directorio de plantillas:

   ```html
   <!DOCTYPE html>
   <html lang="es" xmlns:th="http://www.thymeleaf.org">
   <head><meta charset="UTF-8"><title>Contacto</title></head>
   <body>
    <form action="#" th:action="@{/contacto}" method="post">
     <p>
      <label for="email">Email: </label>
      <input type="text" name="email" id="email" th:value="!${exito}? ${contacto.email}">
     </p>
     <p>
      <label for="message">Mensaje: </label>
      <input type="text" name="mensaje" id="message" th:value="!${exito}? ${contacto.mensaje}">
     </p>
     <p><input type="submit" value="Enviar"></p>
    </form>
    <ul th:if="!${exito}">
     <li th:each="err : ${#fields.errors('contacto.*')}" th:text="${err}"></li>
    </ul>
    <p th:if="${exito}" th:text="${exito}"></p>
   </body>
   </html>
   ```

1. Crea la siguiente clase dentro del directorio con la lógica de la aplicación MVC:

   ```java
   public record ModeloFormularioContacto(
     @NotBlank(message = "El mensaje no puede estar vacío")
     String mensaje,
     @Email(message = "El formato del email es incorrecto")
     @NotBlank(message = "El email es obligatorio")
     String email
   ) {}
   ```

1. Añade estos endpoints/recursos a la clase `ControladorSSR`:

   ```java
   @GetMapping("/contacto")
   public String contacto(Model model) {
     model.addAttribute("contacto", new ModeloFormularioContacto("",""));
     return "contacto";
   }

   @PostMapping("/contacto")
   public String contacto(
     @Valid @ModelAttribute("contacto") 
     ModeloFormularioContacto contacto, 
     BindingResult result,
     Model model
   ) {
     if (!result.hasErrors()) {
       model.addAttribute("exito", 
         "Gracias " + contacto.email() + ", tu mensaje ha sido recibido.");
     }
     return "contacto";
   }
   ```

> ⁉️ **Ejercicio 1:** _Compila y ejecuta el proyecto desde el IDE. Abre en un navegador la URL [`http://localhost:8080/contacto`](http://localhost:8080/contacto). Prueba todas las posibles situaciones de error._

> ⁉️ **Ejercicio 2:** _Comprueba la diferencia entre `@NotNull` y `@NotBlank`. Añade una validación extra para que el tamaño del mensaje no supere los 20 caracteres usando `@Size`._