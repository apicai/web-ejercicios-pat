# CSS
## Diseño responsivo

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

[^1]: Otra unidad relativa ampliamente utilizada es `%`: porcentaje relativo a la misma propiedad en el elemento padre. Por ejemplo, un elemento con `font-size: 50%;` tendrá un tamaño de letra la mitad de pequeño que el de su padre.

[^2]: Cada navegador tiene un tamaño de letra razonable para las dimensiones del dispositivo en el que se ejecuta. Además, el usuario puede establecer otro tamaño que se ajuste más a sus necesidades. Utilizar este tamaño como referencia para la página web suele ser lo más adecuado.
