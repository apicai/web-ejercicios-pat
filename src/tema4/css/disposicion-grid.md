# CSS
## Disposición

### Grid

Para diseños que requieren colocar elementos en ambas dimensiones es más sencillo utilizar [Grid](https://css-tricks.com/snippets/css/complete-guide-grid/). Se trata de colocar los elementos en la cuadrícula definida en el contenedor. El tamaño de las filas y columnas se puede definir proporcionalmente al espacio disponible con la unidad `fr`. Existen muchas formas de definir la cuadrícula, a continuación vemos un ejemplo que utiliza nombres de áreas.

<div class="codepen" data-prefill data-height="350" data-theme-id="light" data-default-tab="css,result" data-editable="true" style="opacity:0">
  <pre data-lang="html">&lt;body>
  &lt;header class="cabecera">Cabecera&lt;/header>
  &lt;article class="contenido">Contenido&lt;/article>
  &lt;aside class="secciones">Secciones del sitio web&lt;/aside>
  &lt;aside class="indice">Índice del contenido&lt;/aside>
  &lt;footer class="pie">Pié de página&lt;/footer>
&lt;/body></pre>
  <pre data-lang="css" data-option-autoprefixer="true">body {
  display: grid;
  grid-template-columns: 2fr 3fr 1fr;
  grid-template-areas:
    "header   header header"
    "sections main   main"
    "footer   footer footer";
  gap: 7px;
  padding: 12px;
  text-align: center;
  font: 12px sans-serif;
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
  display: none;
}</pre></div>

> ⁉️ **Ejercicio:** _Estudia la CSS y el diseño para añadir un índice a la derecha del contenido._
