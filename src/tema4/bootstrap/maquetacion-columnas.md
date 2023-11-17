# Bootstrap
## Maquetación

### Columnas

<div class="codepen" data-height="350" data-theme-id="light" data-default-tab="html,result" data-editable="true" style="opacity:0" data-prefill='{"stylesheets":["https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"]}'>
  <pre data-lang="html">&lt;body>
&lt;main class="container text-center">
  &lt;article class="row">
    &lt;section class="col-3 alert alert-primary">
      Esta columna ocupa 3 huecos de los 12 disponibles. Su clase es &lt;code>col-3&lt;/code>.
    &lt;/section>
    &lt;section class="col-4 alert alert-warning">
      Esta columna ocupa 4 huecos de los 12 disponibles. Su clase es &lt;code>col-4&lt;/code>. En total, todas las columnas han de sumar 12 (= 3 + 4 + 5, en este caso).
    &lt;/section>
    &lt;section class="col-5 alert alert-success">
      Esta columna ocupa 5 huecos de los 12 disponibles. Su clase es &lt;code>col-5&lt;/code>. Además, cada una de estas secciones utiliza los estilos de &lt;a href="https://getbootstrap.com/docs/5.3/components/alerts/">alertas de Bootstrap&lt;/a>.
    &lt;/section>
  &lt;/article>
&lt;/main>
&lt;/body></pre>
  <pre data-lang="css">section { font-size: 75%; border-radius: 0 !important; margin-bottom: 0 !important; }</pre></div>

> **❓ Ejercicio:** _Modifica el HTML para que las 3 columnas ocupen el mismo ancho. ¿Qué pasa si las clases de las columnas no suman 12?_