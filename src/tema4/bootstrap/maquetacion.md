# Bootstrap
## Maquetación

El sistema de maquetación de Bootstrap[^1] utiliza internamente [Flexbox](/tema4/css/disposicion.html#flexbox) y [media queries](/tema4/css/responsive.html#media-queries) para definir una serie de clases CSS que permiten:
1. Dividir el diseño hasta en 12 columnas (clases: `col-{número de columnas a ocupar de las 12}`).
2. Cambiar su disposición (apilamiento) hasta para 6 anchos de pantalla (clases: `col-{anchos: sm, md, lg, xl o xxl}`).

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

> ⁉️ **Ejercicio:** _Modifica el HTML para que las 3 columnas ocupen el mismo ancho. ¿Qué pasa si las clases de las columnas no suman 12?_

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

> ⁉️ **Ejercicio:** _Pulsa en "Edit on Codepen" y modifica el ancho de la ventana para comprobar el comportamiento. Modifica el HTML para que una de ellos se mantenga apilado en pantallas `xl` o `xxl`._

### Alineación

Para que las columnas tengan su ancho igual a lo que ocupa su contenido se usa `col-{pantalla}-auto`. Para que estén centradas horizontalmente se añade la clase `justify-content-center` en la fila `row`.

> ⁉️ **Ejercicio:** _Modifica las columnas amarillas anteriores para que su ancho se ajuste a su contenido y estén centradas._



[^1]: Se le llama [Bootstrap Grid](https://getbootstrap.com/docs/5.2/layout/grid/) pero no tiene nada que ver con el [Grid de CSS](/tema4/css/disposicion.html#grid).