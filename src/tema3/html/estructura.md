# HTML
## Estructura

Un documento HTML está formado por 4 etiquetas base que delimitan las siguientes partes de su estructura: tipo de documento[^1], elemento raíz[^2], metadatos y contenido visible.

```html
<!DOCTYPE html>
<html lang="es">
  <head>
    <title>Título obligatorio</title>
    <style><!-- Tema 4: CSS --></style>
    <script><!-- Tema 5: JavaScript --></script>
  </head>
  <body>
    <!-- Este tema -->
  </body>
</html>
```

> ⁉️ **Pregunta:** _Copia y pega el HTML anterior en este [validador](https://validator.w3.org/nu/#textarea) ¿Por qué falla? ¿cómo lo arreglarias?_

[^1]: Permite saber al navegador qué versión de HTML usa el documento para validar su estructura automáticamente y/o si debe activar modo de retrocompatibilidad con código antiguo.

[^2]: El atributo con el idioma es importante para los lectores de pantalla (accesibilidad).