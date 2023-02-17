# CSS
## Maquetación

### Flexbox

Con [Flexbox](https://css-tricks.com/snippets/css/a-guide-to-flexbox/) podemos colocar los elementos con respecto a una de las dimensiones (la horizontal o la vertical), y a lo largo de esa dimensión controlar la proporción que ocupa cada elemento[^1]. Para ello se utiliza la propiedad `flex: flex-grow flex-shrink flex-basis;` en los elementos de un contenedor con `display: flex`:

- `flex-grow`: indica en qué proporción crecerá el elemento respecto del resto cuando sobre espacio.
- `flex-shrink`: indica en qué proporción encogerá el elemento respecto del resto cuando falte espacio.
- `flex-basis`: indica el tamaño inicial para el elemento antes de redistribuir el espacio.

<div class="codepen" data-prefill data-height="350" data-theme-id="light" data-default-tab="css,result" data-editable="true" style="opacity:0">
<pre data-lang="html">&lt;body>
&lt;nav>
 &lt;ul class="contenedor">
  &lt;li>&lt;a href="#">Inicio&lt;/a>&lt;/li>
  &lt;li>&lt;a href="#">Nosotros&lt;/a>&lt;/li>
  &lt;li>&lt;a href="#">Productos&lt;/a>&lt;/li>
  &lt;li>&lt;a href="#">Contacto&lt;/a>&lt;/li>
 &lt;/ul>
&lt;/nav>
&lt;/body></pre>
<pre data-lang="css">.contenedor {
  display: flex;
  list-style: none;
  margin: 0;
  background: dodgerblue;
  padding: 0;
}
.contenedor li {
  flex: 0 1 0;
}
.contenedor li:first-child {
}
.contenedor a {
  font: 9px sans-serif;
  text-align: center;
  text-decoration: none;
  display: block;
  padding: 9px;
  color: white;
  user-select: none;
}
.contenedor li:hover {
  background: royalblue;
}
</pre></div>

1. Añade `justify-content: center;` al contenedor para centrar los elementos.

1. Los elementos no están ocupando todo el espacio disponible en la dimensión horizontal[^2] porque tienen un valor de `flex-grow` igual a 0. Cambia el valor a 1 en la propiedad `flex` para que crezcan todos con la misma proporción.

1. Si, por ejemplo, quisiéramos que ocupara 4 veces más "Inicio" usaríamos `flex: 4 1 0;`. Añade esa propiedad al primer elemento.

1. Para simular una situación en la que se encoge el elemento, podemos poner un tamaño inicial grande al resto: usa `flex: 1 4 0;` en el primero y `flex: 1 1 180px;` en el resto.

   > ⁉️ **Ejercicio 1:** _Comprueba visualmente que encoger 4 veces el primer elemento es igual a hacer 4 veces más grande el resto de elementos._

Vamos a combinar los conceptos de [pseudoclase](../../tema4/css/pseudoclases.html), [posición](../../tema4/css/posicion-position.html) y maquetación, que ya hemos visto, para crear un sub-menú desplegable al pasar el ratón por encima de los menús anteriores.

> ⁉️ **Ejercicio 2:** _Coloca el siguiente HTML, que representa un sub-menú, dentro de uno de los menús anteriores (después del `</a>`):_
> <details><summary><em>1. HTML del sub-menú...</em></summary>
>
> ```html
> <ul class="submenu">
>   <li><a href="#">Submenú 1</a></li>
>   <li><a href="#">Submenú 2</a></li>
> </ul>
> ```
> </details>
>
> <details><summary><em>2. Añade y completa las <code>?</code> del siguiente CSS...</em></summary>
>
> ```css
> .submenu {
>   display: none;
>   list-style: none;
>   padding: 0;
>   background: dodgerblue;
>   position: ?
> }
> .submenu > li:? {
>   background: royalblue;
> }
> .contenedor > li:? > .submenu {
>   display: block;
> }
> ```
> </details>
> <br>

[^1]: Usar tamaños fijos no ayuda a adaptar el contenido a diferentes tamaños de pantalla. Usando proporciones podremos encoger o crecer en función del espacio disponible en cada pantalla.

[^2]: Para cambiar la dimensión sobre la que se distribuyen los elementos usa `flex-direction: column;` en el contenedor. Si no se indica, se utiliza por defecto la dimensión horizontal `flex-direction: row;`.