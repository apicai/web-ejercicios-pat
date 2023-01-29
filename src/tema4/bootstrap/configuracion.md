# Bootstrap
## Configuración

Para importar la CSS de Bootstrap de forma directa en una página web usa el siguiente `head`:

```html
<!doctype html>
<html lang="">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css" rel="stylesheet">
    <title><!-- Completa el título --></title>
  </head>
  <body><!-- Completa el contenido --></body>
</html>
```

Bootstrap viene con un conjuto de estilos predefinido que puede personalizarse utilizando [Sass](https://getbootstrap.com/docs/5.3/customize/overview/) o sobrescribiendo [variables CSS](https://getbootstrap.com/docs/5.2/customize/css-variables/).