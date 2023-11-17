# Bootstrap
## Maquetación

### Apilamiento

<div class="codepen" data-height="350" data-theme-id="light" data-default-tab="html,result" data-editable="true" style="opacity:0" data-prefill='{"stylesheets":["https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"]}'>
  <pre data-lang="html">&lt;body>
&lt;main class="container text-center">
  &lt;article class="row">
    &lt;section class="col-sm alert alert-primary">
      Estas columnas se apilan solo cuando el ancho es pequeño: &lt;strong>menor que 576px&lt;/strong>.
    &lt;/section>
    &lt;section class="col-sm alert alert-primary">
      Usan la clase &lt;code>col-sm&lt;/code>.
    &lt;/section>
    &lt;section class="col-sm alert alert-primary">
      El ancho se reparte equitativamente cuando no están apiladas.
    &lt;/section>
  &lt;/article>
  &lt;article class="row">
    &lt;section class="col-md alert alert-warning">
      Estas columnas se apilan solo cuando el ancho es mediano: &lt;strong>menor que 768px&lt;/strong>.
    &lt;/section>
    &lt;section class="col-md alert alert-warning">
      Usan la clase &lt;code>col-md&lt;/code>.
    &lt;/section>
    &lt;section class="col-md alert alert-warning">
      El ancho se reparte equitativamente cuando no están apiladas.
    &lt;/section>
  &lt;/article>
  &lt;article class="row">
    &lt;section class="col-lg alert alert-success">
      Estas columnas se apilan solo cuando el ancho es grande: &lt;strong>menor que 992px&lt;/strong>.
    &lt;/section>
    &lt;section class="col-lg alert alert-success">
      Usan la clase &lt;code>col-lg&lt;/code>.
    &lt;/section>
    &lt;section class="col-lg alert alert-success">
      El ancho se reparte equitativamente cuando no están apiladas.
    &lt;/section>
  &lt;/article>
&lt;/main>
&lt;/body></pre>
  <pre data-lang="css">section { font-size: 75%; border-radius: 0 !important; margin-bottom: 0 !important; }</pre></div>

> **❓ Ejercicio:** _Pulsa en "Edit on Codepen" y modifica el ancho de la ventana para comprobar el comportamiento. Modifica el HTML para que una de ellos se mantenga apilado en pantallas `xl` o `xxl`._

### Alineación

Para que las columnas tengan su ancho igual a lo que ocupa su contenido se usa `col-{pantalla}-auto`. Para que estén centradas horizontalmente se añade la clase `justify-content-center` en la fila `row`.

> **❓ Ejercicio:** _Modifica las columnas amarillas anteriores para que su ancho se ajuste a su contenido y estén centradas._