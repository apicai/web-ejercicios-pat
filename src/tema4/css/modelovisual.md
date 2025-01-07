# CSS
## Modelo visual

Un elemento HTML se pinta como un cuadro compuesto de: contenido, relleno (padding), borde y margen.

<div class="codepen" data-prefill="{}" data-height="410" data-theme-id="light" data-default-tab="result" data-editable="true" style="opacity:0">
  <pre data-lang="html">&lt;body>&lt;p>
El &lt;strong>contenido&lt;/strong> de este elemento HTML es este texto que estás leyendo. El &lt;strong>padding&lt;/strong> es el espacio en color blanco de 35 píxeles que hay desde el cuadro del contenido hasta el recuadro verde (arriba, abajo, a la izquieda y a la derecha). El &lt;strong>borde&lt;/strong> es el recuadro verde que tiene un ancho de 10 píxeles. Por último, el &lt;strong>margen&lt;/strong> es el espacio en gris de 40 píxeles que hay entre el borde verde y el límite de la ventana (arriba, a la izquieda y a la derecha). Si no se indica su ancho y alto, el elemento HTML ocupa todo el ancho de su elemento padre contenedor, que en este caso es el &lt;code>body&lt;/code>. Por eso, cuando cambia el ancho de la ventana, el elemento reajusta el contenido manteniendo las dimensiones del padding, borde y margen.
&lt;/p>&lt;/body></pre>
  <pre data-lang="css">body { background-color: gray; }
p {
  background-color: white;
  border: 10px solid green;
  padding: 25px;
  margin: 40px;
}</pre></div>

1. Añade un `width: 140px;` al elemento en la CSS y comprueba que deja de extenderse a lo ancho de su elemento padre, y su contenido se reajusta hacia abajo.

1. Añade un `height: 140px;` al elemento en la CSS y comprueba que deja de extenderse a lo alto de su elemento padre. Al fijarse todas las dimensiones del elemento, el contenido no tiene por donde crecer y desborda.

1. Añade un `overflow: hidden;` al elemento en la CSS y comprueba deja de desbordar pero no se ve todo el texto.

1. Modifica el `overflow: scroll;` y comprueba que ahora puedes ver todo el texto.
