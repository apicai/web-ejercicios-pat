# CSS
## Diseño responsivo

### Media queries

Además de hacer diseños que se adaptan al espacio disponible, hay situaciones en las que es mejor tener un diseño con diferente disposición de los contenidos. Por ejemplo: para pantallas muy grandes o muy pequeñas, cuando el dispositivo está en una orientación diferente, si la pantalla es táctil, etc. 

Para ello se utilizan "media queries" que aplican ciertas reglas CSS solo si se cumple la condición indicada: `@media (condición) { reglas CSS ... }`. Hay varias [condiciones](https://developer.mozilla.org/en-US/docs/Web/CSS/Media_Queries/Using_media_queries), las más utilizadas son `min-width` y `max-width` que consultan el ancho actual de la ventana gráfica de la página.

<div class="codepen" data-prefill data-height="350" data-theme-id="light" data-default-tab="css,result" data-editable="true" style="opacity:0">
  <pre data-lang="html">&lt;body>
  &lt;header class="cabecera">Cabecera&lt;/header>
  &lt;article class="contenido">Contenido&lt;/article>
  &lt;aside class="secciones">Secciones del sitio web&lt;/aside>
  &lt;aside class="indice">Índice del contenido&lt;/aside>
  &lt;footer class="pie">Pié de página&lt;/footer>
&lt;/body></pre>
  <pre data-lang="css">body {
  display: grid;
  grid-template-columns: 2fr 3fr 1fr;
  grid-template-areas:
    "header   header header"
    "sections main   index"
    "footer   footer footer";
  gap: 7px;
  padding: 12px;
  text-align: center;
  font: 12px sans-serif;
}
@media (max-width: 25em) {
  body {
    grid-template-columns: 1fr;
    grid-template-areas:
      "header"
      "sections"
      "index"
      "main"
      "footer";
  }
}
body * {
  padding: 10px;
}
.cabecera {
  background: tomato;
  grid-area: header;
}
.pie {
  background: lightgreen;
  grid-area: footer;
}
.contenido {
  text-align: left;
  background: deepskyblue;
  grid-area: main;
}
.secciones {
  background: gold;
  grid-area: sections;
}
.indice {
  background: hotpink;
  grid-area: index;
}</pre></div>

> ⁉️ **Ejercicio:** _En el ejemplo anterior, localiza la "media query" e intenta explicar qué hace._