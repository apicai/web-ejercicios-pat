# CSS
## Diseño responsivo

### Unidades relativas

Utilizar dimensiones fijas/absolutas (píxeles) para definir los tamaños de la letra, los márgenes, paddings, anchos y/o altos de los elementos no es lo más adecuado si quieres ser capaz de reconfigurar fácilmente las proporciones en función del tamaño de pantalla. Es mejor usar unidades relativas. Las más utilizadas[^1] son las relativas al tamaño de la tipografía del navegador[^2]: 

- `rem`, relativa al tamaño de la letra inicial de la página, y 
- `em`, relativa al tamaño de la letra en el elemento.

<div class="codepen" data-prefill data-height="450" data-default-tab="css,result" data-theme-id="light" data-editable="true" style="opacity:0">
  <pre data-lang="html">&lt;body>
&lt;section class="relativas">
  &lt;aside class="flota">&lt;/aside>
  &lt;p>Este contenedor está utilizando unidades &lt;strong>rem&lt;/strong> para definir los tamaños de letras, márgenes, paddings, altos y anchos.&lt;/p>
  &lt;p>Si reconfiguramos el tamaño de la fuente, este contenedor modifica sus tamaños en la misma proporción. Cuando esta página se vea en pantallas o muy grandes o muy pequeñas, puede ser interesante cambiar esas proporciones para mejorar la legibilidad y el uso. Por ejemplo, aumentar el tamaño de un botón para que sea más fácil pulsarlo.&lt;/p>
&lt;/section>
&lt;section class="pixels">
  &lt;aside class="flota">&lt;/aside>
  &lt;p>Este contenedor está utilizando unidades de &lt;strong>píxeles&lt;/strong> para definir los tamaños de letras, márgenes, paddings, altos y anchos.&lt;/p>
  &lt;p>Si reconfiguramos el tamaño de la fuente, este contenedor permanece igual con las mismas dimensiones. Eso puede ser interesante cuando se diseña la página para una resolución fija. Pero si esta página se viera en una pantalla pequeña puede que el los botones no sean lo suficientemente grandes para pulsarlos con facilidad.&lt;/p>
&lt;/section>
&lt;/body></pre>
  <pre data-lang="css">html {
  font-family: sans-serif;
  font-size: 100%;
}
.relativas .flota {
  float: left;
  width: 5rem;
  height: 9rem;
  background-color: green;
  margin-right: 1rem;
  margin-bottom: 1rem;
}
.relativas {
  width: 20rem;
  border: 5px solid gray;
  padding: 1rem;
  margin: 1rem;
}
.relativas p {
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

1. La propiedad `font-size` nos permite reconfigurar las proporciones del primer contenedor fácilmente, pero no del segundo. Ahora está al 100%, lo que indica que se está usando el valor por defecto de este navegador (o el configurado por el usuario). Manualmente, vamos a ponerlo a `font-size: 75%;` simulando lo que haría una media query en determinadas condiciones.

2. Para ver cómo funciona la unidad `em` vamos a poner en el contenedor `relativas` un tamaño de fuente diferente: `font-size: 0.5rem;`. Como los elementos hijos usan `rem` siguen con las mismas dimensiones, pero sus textos han heredado el nuevo tamaño de fuente definido en el padre. Para que el diseño mantenga la proporción correcta, cambia los `rem` por `em` en todos sus elementos hijos.

[^1]: Otra unidad relativa ampliamente utilizada es `%`: porcentaje relativo a la misma propiedad en el elemento padre. Por ejemplo, un elemento con `font-size: 50%;` tendrá un tamaño de letra la mitad de pequeño que el de su padre.

[^2]: Cada navegador tiene un tamaño de letra razonable para las dimensiones del dispositivo en el que se ejecuta. Además, el usuario puede establecer otro tamaño que se ajuste más a sus necesidades. Utilizar este tamaño como referencia para la página web suele ser lo más adecuado.
