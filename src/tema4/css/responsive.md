# CSS
## Diseño responsivo

Su objetivo es hacer que la misma página se vea bien en todos los tamaños de pantalla. Flexbox y Grid permiten hacer diseños con proporciones de modo que los contenidos se adapten al espacio disponible en cada pantalla. Además de esas técnicas, hay otras recomendaciones para el diseño de webs responsivas.

### Configuración de la ventana gráfica

La siguiente etiqueta [`meta`](/tema3/html/metadatos.html#configuraci%C3%B3n-ventana-gr%C3%A1fica) es **imprescindible** para que el contenido de la página se ajuste al ancho de la pantalla en los navegadores de todos los dispositivos:

```html
<meta name="viewport" content="width=device-width, initial-scale=1">
```

### Unidades relativas

Utilizar dimensiones fijas (píxeles) no suele ser conveniente cuando la página pueda verse en pantallas de muy diferente resolución. En su lugar se recomienda usar unidades relativas para definir los tamaños de la letra, los márgenes, paddings, anchos y/o altos del elemento. Las más utilizadas[^1] son las relativas al tamaño de la tipografía del navegador[^2]: `rem`, relativa al tamaño de la letra inicial de la página, y `em`, relativa al tamaño de la letra en el elemento.

<div class="codepen" data-prefill data-height="450" data-default-tab="css,result" data-theme-id="light" data-editable="true" style="opacity:0">
  <pre data-lang="html">&lt;body>
&lt;section class="container">
  &lt;aside class="flota">&lt;/aside>
  &lt;p>Este contenedor está utilizando unidades &lt;strong>rem&lt;/strong> para definir los tamaños de letras, márgenes, paddings, altos y anchos.&lt;/p>
  &lt;p>Si cambiamos el tamaño de la fuente, este contenedor modifica sus tamaños en la misma proporción. Cuando esta página se vea en pantallas grandes seguirá el tamaño de fuente configurado en el dispositivo que tendrá un valor razonable para su legibilidad. Lo mismo ocurrirá con pantallas más pequeñas que la actual.&lt;/p>
&lt;/section>
&lt;section class="pixels">
  &lt;aside class="flota">&lt;/aside>
  &lt;p>Este contenedor está utilizando unidades de &lt;strong>píxeles&lt;/strong> para definir los tamaños de letras, márgenes, paddings, altos y anchos.&lt;/p>
  &lt;p>Si cambiamos el tamaño de la fuente, este contenedor permanece igual con las mismas dimensiones. Eso puede ser interesante cuando se diseña la página para una resolución fija. Pero si esta página se viera en una TV 4K este texto casi no se vería. Y si la página se viera en una pantalla pequeña puede que el texto fuera muy grande y fuera necesario scroll horizontal.&lt;/p>
&lt;/section>
&lt;/body></pre>
  <pre data-lang="css" data-option-autoprefixer="true">html {
  font-family: sans-serif;
  font-size: 100%;
}
.container .flota {
  float: left;
  width: 5rem;
  height: 9rem;
  background-color: green;
  margin-right: 1rem;
  margin-bottom: 1rem;
}
.container {
  width: 20rem;
  border: 5px solid gray;
  padding: 1rem;
  margin: 1rem;
}
.container p {
  margin: 0 0 1rem 0;
}
.pixels .flota {
  float: left;
  width: 80px;
  height: 144px;
  background-color: green;
  margin-right: 16px;
  margin-bottom: 16px;
}
.pixels {
  width: 320px;
  border: 5px solid gray;
  padding: 16px;
  margin: 16px;
}
.pixels p {
  margin: 0 0 16px 0;
  font-size: 16px;
}</pre></div>

1. Para simular los diferentes tamaños de fuente que puedan tener los navegadores de diferentes dispositivos, podemos cambiar el `font-size` del HTML. Ahora está al 100%, lo que indica que se está usando el valor por defecto de este navegador (o el configurado por el usuario). Vamos a ponerlo a `font-size: 75%;` para simular un dispositivo con pantalla más pequeña (que usará una letra más pequeña).

2. Para ver cómo funciona la unidad `em` vamos a poner en el contenedor padre un tamaño de fuente diferente: `font-size: 0.5rem;`. Como los elementos hijos usan `rem` siguen con las mismas dimensiones, pero sus textos han heredado el nuevo tamaño de fuente definido en el padre. Para que el diseño mantenga la proporción correcta, cambia los `rem` por `em` en todos sus elementos hijos.

### Imágenes

Las imágenes normalmente no van a tener las dimensiones exactas para que encajen en el diseño, el cual además puede tener dimensiones variables si es responsivo. Para asegurar que las imágenes grandes no desbordan o creen barras de scroll, se añade la siguiente regla CSS para todos los `img`:

<div class="codepen" data-prefill data-height="350" data-default-tab="css,result" data-theme-id="light" data-editable="true" style="opacity:0">
  <pre data-lang="html">&lt;body>
  &lt;figure>
    &lt;img alt="Imagen grande" src="https://upload.wikimedia.org/wikipedia/commons/c/cf/1_6E9A4589.jpg">
    &lt;figcaption>Imagen más grande que el contenedor&lt;/figcaption>
  &lt;/figure>
&lt;/body></pre>
  <pre data-lang="css" data-option-autoprefixer="true">img {
  max-width: 100%;
  display: block;
}
figure {
  border: 10px solid green;
  width: 15rem;
  text-align: center;
  font-family: sans-serif;
}</pre></div>

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
  <pre data-lang="css" data-option-autoprefixer="true">body {
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

[^1]: Otra unidad relativa ampliamente utilizada es `%`: porcentaje relativo a la misma propiedad en el elemento padre. Por ejemplo, un elemento con `font-size: 50%;` tendrá un tamaño de letra la mitad de pequeño que el de su padre.

[^2]: Cada navegador tiene un tamaño de letra razonable para las dimensiones del dispositivo en el que se ejecuta. Además, el usuario puede establecer otro tamaño que se ajuste más a sus necesidades. Utilizar este tamaño como referencia para la página web suele ser lo más adecuado.

