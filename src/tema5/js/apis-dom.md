# JavaScript
## Web APIs

### <abbr title="Document Object Model">DOM</abbr>

Es una de las APIs del BOM, y permite interactuar con el documento HTML cargado en la ventana actual del navegador. Utiliza una estructura jerárquica de nodos representando los elementos que componen el documento.

```js
console.log('Elementos que hay dentro del elemento body:', document.body.childNodes);

console.log('Elemento 4to del body:', document.body.childNodes[3]);

console.log('Tipo del 4to elemento del body:', document.body.childNodes[3].nodeName);

console.log('HTML del 1er elemento del 4to elemento del body:', 
            document.body.childNodes[3].childNodes[0].innerHTML);
```

> ⁉️ **Ejercicio:** _En el siguiente Codepen, muestra el elemento del DOM del "Menú 2" usando una alerta. Ojo, que el DOM también considera como elementos los comentarios, los textos y retornos de carro que hay entre los elementos._

<div class="codepen" data-prefill data-height="350" data-theme-id="light" data-default-tab="js,html" data-editable="true" style="opacity:0">
  <pre data-lang="html">&lt;body>
&lt;header>&lt;h1>Cabecera&lt;/h1>&lt;/header>
&lt;nav>
  &lt;ul>
    &lt;li>&lt;a href="#">Menú 1&lt;/a>&lt;/li>
    &lt;!-- Muestra el hijo de este elemento de abajo --> 
    &lt;li>&lt;a href="#">Menú 2&lt;/a>&lt;/li>
  &lt;/ul>
&lt;/nav>
&lt;footer>&lt;p>Pie de página&lt;/p>&lt;/footer>
&lt;body></pre>
  <pre data-lang="js">// Usa un alert para mostrar el HTML del elemento
</pre></div>