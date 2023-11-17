# CSS
## Modelo visual

### Comportamiento

Hay tres tipos principales de comportamiento visual del cuadro de un elemento HTML: 

1. Los de tipo **block** empiezan siempre en una nueva línea y tenderán a ocupar todo el ancho de su elemento contenedor. Ejemplos de elementos que por defecto usan este tipo: `p`, `h1`, `li`, `section`, etc.

1. Los de tipo **inline** no empiezan una nueva línea y crecen a lo ancho en función de su contenido (las propiedades `width` y `height` no funcionan en ellos). Ejemplos de elementos que por defecto usan este tipo: `a`, `strong`, `span`, etc.

1. Los de tipo **inline-block** son como los anteriores pero las propiedades `width` y `height` sí funcionan. El elemento `img` tiene por defecto este comportamiento.

El comportamiento por defecto de cada elemento se puede cambiar con la propiedad CSS `display`.

<div class="codepen" data-prefill data-height="410" data-theme-id="light" data-default-tab="result" data-editable="true" style="opacity:0">
<pre data-lang="html">&lt;body>
&lt;div id="e1">Elemento 1&lt;/div>
&lt;div id="e2">Elemento 2&lt;/div>
&lt;div id="e3">Elemento 3&lt;/div>
&lt;div id="e4">Elemento 4&lt;/div>
&lt;div id="e5">Elemento 5&lt;/div>
&lt;/body></pre>
<pre data-lang="css">
div {
  color: white;
  background-color: blueviolet;
  border: 3px solid indigo;
  padding: 10px;
  margin: 10px;
}
#e2 { display: inline-block; height: 95px; width: 150px; }
#e3 { display: inline; height: 95px; width: 150px; }
#e4 { display: inline-block; }
</pre>
</div>

> **❓ Ejercicio:** _Identifica qué tipo de "display" (`block`, `inline` o `inline-block`) está usando cada uno de los anteriores elementos._

> **❓ Ejercicio:** _Modifica el `display: none;` del "Elemento 3", y luego añade la propiedad CSS `visibility: hidden;` al "Elemento 2". Intenta explicar la diferencia entre ambas propiedades._