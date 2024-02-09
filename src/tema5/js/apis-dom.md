# JavaScript
## Web APIs

### <abbr title="Document Object Model">DOM</abbr>

Es una de las APIs del BOM, y permite interactuar con el documento HTML cargado en la ventana actual del navegador. Utiliza una estructura jerárquica de nodos representando los elementos que componen el documento.

```js
console.log('Elementos que hay dentro del elemento body:', document.body.children);

console.log('Elemento 1ro del body:', document.body.children[0]);

console.log('Tipo del 6to elemento del 1er elemento del body:', 
            document.body.children[0].children[5].nodeName);

console.log('HTML del anterior elemento:', 
            document.body.children[0].children[5].innerHTML);
```

> **❓ Ejercicio:** _En el siguiente Codepen, muestra el elemento del DOM del "Menú 2" usando una alerta e identifícalo en el siguiente diagrama._
> <details><summary><em>Árbol DOM...</em></summary><br>
> <object type="image/svg+xml" data="./files/dom.svg" width="100%"></object>
> </details>

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