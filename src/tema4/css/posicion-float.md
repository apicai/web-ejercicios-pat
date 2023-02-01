# CSS
## Posición

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