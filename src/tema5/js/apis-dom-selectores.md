# JavaScript
## Web APIs

### DOM

#### Selectores

Para obtener un elemento o lista de elementos concreta del DOM. Pega el siguiente código en la consola JavaScript del navegador y observa el comportamiento.

```js
console.log('Obtiene el elemento con id "sidebar":', 
            document.getElementById('sidebar'));
            
console.log('Obtiene los elementos cuya etiqueta es "button":', 
            document.getElementsByTagName('button'));

console.log('Obtiene el 1er elemento que satisface el selector CSS pasado:',
            document.querySelector('*[title]'));

console.log('Obtiene todos los elementos que satisfacen el selector CSS pasado:',
            document.querySelectorAll('.header'));
```

> **❓ Ejercicio:** _En el siguiente Codepen, obtén el elemento con id "pie", los elementos `li`, los enlaces cuya URL sea "#" y los elementos que tenga la clase "prueba"._

<div class="codepen" data-prefill data-height="300" data-theme-id="light" data-default-tab="js,html" data-editable="true" style="opacity:0">
  <pre data-lang="html">&lt;body>
&lt;header>&lt;h1>Cabecera&lt;/h1>&lt;/header>
&lt;nav>
  &lt;ul>
    &lt;li>&lt;a href="#">Menú 1&lt;/a>&lt;/li>
    &lt;li>&lt;a href="#">Menú 2&lt;/a>&lt;/li>
  &lt;/ul>
&lt;/nav>
&lt;footer>&lt;p id="pie">Pie de página&lt;/p>&lt;/footer>
&lt;body></pre>
  <pre data-lang="js">// Elemento id "pie"
// Elementos "li"
// Enlaces a "#"
// Elementos con clase "prueba"
</pre></div>