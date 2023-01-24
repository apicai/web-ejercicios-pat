# CSS
## Posición

Hasta ahora los elementos se han ido colocando en la página empezando desde la esquina superior izquierda en función de su posición en el HTML. Con CSS se puede cambiar la posición por defecto de los elementos con dos de sus propiedades.

### Float

Para que un elemento flote y los adyacentes lo envuelvan se utiliza `float` (y `clear`):
<div class="codepen" data-prefill data-height="350" data-theme-id="light" data-default-tab="css,result" data-editable="true" style="opacity:0">
<pre data-lang="html">&lt;body>
&lt;section class="contenedor">
  &lt;aside class="flota">&lt;/aside>
  &lt;p>Este 1er párrafo está envolviendo al elemento verde que flota a a la izquierda. Si quisiéramos que flotara a la derecha habría que usar &lt;code>float: right;&lt;/code>.&lt;/p>
  &lt;p id="p2">Este 2do párrafo también envuelve al elemento flotante. Si no quisieramos que flotara, habría que poner a este elemento la propiedad CSS &lt;code>clear: both;&lt;/code>.&lt;/p>
&lt;/section>
&lt;/body></pre>
<pre data-lang="css">.flota {
  float: left;
  width: 80px;
  height: 140px;
  background-color: green;
  margin-right: 10px;
  margin-bottom: 10px;
}
.contenedor {
  width: 280px;
  border: 5px solid gray;
  padding: 10px;
  margin: 18px 0 0 10px;
}
#p2 {
  /* clear: both; */
}
p {
  margin: 0 0 10px 0;
  font: 15px sans-serif;
}</pre></div>

### Position

El elemento se puede posicionar estableciendo la distancia a alguno de los lados (`top`, `right`, `bottom` y/o `left`) de la referencia indicada en su propiedad `position`:
<div class="codepen" data-prefill data-height="350" data-theme-id="light" data-default-tab="css,result" data-editable="true" style="opacity:0">
<pre data-lang="html">&lt;body>
&lt;section class="contenedor">
  &lt;aside class="posicionado">&lt;/aside>
  &lt;p>La propiedad &lt;code>position: relative;&lt;/code> permite mover el elemento respecto de la posición en la que hubiera estado originalmente. Los elementos adyacentes no responden a la nueva posición, solo al hueco original en el que hubiera estado el elemento.&lt;/p>
  &lt;p>Por el contrario, usando &lt;code>position: absolute;&lt;/code>, los elementos adyacentes ignoran al elemento por completo colocándose como si no existiera. En este caso, el elemento se posiciona respecto al contenedor (si éste tiene un valor de &lt;code>position: relative;&lt;/code>) o respecto a la ventana.&lt;/p>
  &lt;p>&lt;code>position: fixed;&lt;/code> es similar al anterior pero en este caso lo fijamos a la ventana de modo que siempre permanece visible incluso al hacer scroll.&lt;/p>
&lt;/section>
&lt;/body></pre>
<pre data-lang="css">.posicionado {
  width: 80px;
  height: 140px;
  background-color: green;
  z-index: -1;
  position: relative;
  top: 10px;
  left: 10px;
}
.contenedor {
  width: 280px;
  border: 5px dashed gray;
  padding: 10px;
  margin: 18px 0 0 10px;
}
p {
  margin: 0 0 10px 0;
  font: 15px sans-serif;
}</pre></div>

1. Cambia el CSS del elemento verde para que use una posición absoluta.

1. Cambia el CSS del contenedor para que tenga una posición relativa.

1. Cambia el CSS del elemento verde para que use una posición fija y haz scroll.

1. Quita la propiedad `z-index` del elemento verde.

> ⁉️ **Ejercicio:** _Para cada uno de los casos anteriores, identifica el punto de referencia utilizado para recolocar el elemento verde. Explica qué hace la propiedad eliminada en el último punto._
