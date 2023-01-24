# CSS
## Selectores

Seleccionan el o los elementos HTML a los que se van a aplicar los estilos[^1] indicados bajo el selector. Hay 4 maneras básicas de selecionar: por identificador (`#id`), por atributo (`elmento[atributo=valor]`), por clase (`.clase`), o por nombre del elemento HTML (`elemento`).

La siguiente tabla no tiene ningún estilo. Vamos a ir dándole estilo utilizando cada tipo de selector:

<div class="codepen" data-prefill data-height="420" data-theme-id="light" data-default-tab="result" data-editable="true" style="opacity:0">
  <pre data-lang="html">&lt;table>
  &lt;caption id="leyenda">Resumen de tipos de selectores&lt;/caption>
  &lt;thead>
    &lt;tr>
      &lt;th>&lt;/th>
      &lt;th>Tipo&lt;/th>
      &lt;th>Regla CSS&lt;/th>
      &lt;th>Elemento HTML seleccionado&lt;/th>
    &lt;/tr>
  &lt;/thead>
  &lt;tbody>
    &lt;tr class="separador">
      &lt;th rowspan="4">Básicos&lt;/th>
      &lt;td>Id&lt;/td>
      &lt;td>&lt;code>#id1 { color: gray; }&lt;/code>&lt;/td>
      &lt;td>&lt;code>&amp;lt;p id="id1">Párrafo&amp;lt;/p>&lt;/code>&lt;/td>
    &lt;/tr>
    &lt;tr>
      &lt;td>Atributo&lt;/td>
      &lt;td>&lt;code>p[title] { color: gray; }&lt;/code>&lt;/td>
      &lt;td>&lt;code>&amp;lt;p title="Título">Párrafo&amp;lt;/p>&lt;/code>&lt;/td>
    &lt;/tr>
    &lt;tr>
      &lt;td>Clase&lt;/td>
      &lt;td>&lt;code>.clase1 { color: gray; }&lt;/code>&lt;/td>
      &lt;td>&lt;code>&amp;lt;p class="clase1">Párrafo&amp;lt;/p>&lt;/code>&lt;/td>
    &lt;/tr>
    &lt;tr>
      &lt;td>Nombre&lt;/td>
      &lt;td>&lt;code>p { color: gray; }&lt;/code>&lt;/td>
      &lt;td>&lt;code>&amp;lt;p>Párrafo&amp;lt;/p>&lt;/code>&lt;/td>
    &lt;/tr>
    &lt;tr class="separador">
      &lt;th rowspan="2">Pseudo&lt;/th>
      &lt;td>Clase&lt;/td>
      &lt;td>&lt;code>a:hover { color: blue; }&lt;/code>&lt;/td>
      &lt;td>&lt;code>&amp;lt;a href="">Enlace&amp;lt;/a>&lt;/code>&lt;/td>
    &lt;/tr>
    &lt;tr>
      &lt;td>Elemento&lt;/td>
      &lt;td>&lt;code>a::before { content: '🔗 '; }&lt;/code>&lt;/td>
      &lt;td>&lt;code>&amp;lt;a href="">Enlace&amp;lt;/a>&lt;/code>&lt;/td>
    &lt;/tr>
    &lt;tr class="separador">
      &lt;th rowspan="3">Otros&lt;/th>
      &lt;td>Universal&lt;/td>
      &lt;td>&lt;code>* { color: blue; }&lt;/code>&lt;/td>
      &lt;td>Aplica a todos los elementos del HTML&lt;/td>
    &lt;/tr>
    &lt;tr>
      &lt;td>Grupos&lt;/td>
      &lt;td>&lt;code>#id1, #id2 { color: gray; }&lt;/code>&lt;/td>
      &lt;td>&lt;code>&amp;lt;p id="id1">Párrafo 1&amp;lt;/p>&amp;lt;p id="id2">Párrafo 2&amp;lt;/p>&lt;/code>&lt;/td>
    &lt;/tr>
    &lt;tr>
      &lt;td>Combinados&lt;/td>
      &lt;td>&lt;code>p > span { color: red; }&lt;/code>&lt;/td>
      &lt;td>&lt;code>&amp;lt;p>Párrafo &amp;lt;span>importante&amp;lt;span>&amp;lt;/p>&lt;/code>&lt;/td>
    &lt;/tr>
  &lt;/tbody>
&lt;/table></pre>
  <pre data-lang="css">/* Añade aquí las reglas CSS */
</pre></div>

Pulsa en el botón CSS y añade, de una en una, las siguientes reglas, y observa los cambios:

1. Selector por id del elemento HTML:
    ```css
    #leyenda {
      color: #222;
      font-family: Georgia, Times, serif;
      font-size: 20px;
      font-style: italic;
      padding-bottom: 10px;
      border-bottom: 1px solid #bfbfbf;
      margin-bottom: 20px;
    }
    ```
   > ⁉️ **Ejercicio:** _Identifica en el HTML a qué elemento se le está aplicando el estilo._

1. Selector por atributo del elemento HTML:
    ```css
    th[rowspan] {
      font-family: Georgia, Times, serif;
      font-size: 11px;
      writing-mode: sideways-lr;
      padding-right: 15px;
    }
    ```
   > ⁉️ **Pregunta:** _Si hubieras utilizado `th[rowspan="4"]` ¿qué celda de la tabla hubiera cambiado?._

1. Selector por clase del elemento HTML:
    ```css
    .separador > td {
      border-top: 1px solid #bfbfbf;
    }
    ```
   > ⁉️ **Pregunta:** _En este caso se está utilizando un selector combinado de clase y elemento hijo ¿Qué elementos de nuestro HTML se están seleccionando en este caso?_

1. Selectores por nombre del elemento HTML:
    ```css
    table {
      margin: 0 auto;
      border-collapse: collapse;
      border-spacing: 0;
    }
    th {
      font-size: 15px;
      text-align: left;
    }
    td {
      padding-right: 20px;
      font-size: 10px;
      line-height: 2;
    }
    tr:nth-child(2n+1) > td {
      background: #eee;
    }
    ```

    > ⁉️ **Ejercicio:** _La última regla CSS utiliza una pseudo-clase que veremos en la siguiente sección. Intenta modificar ese selector para que aplique a las líneas pares en vez de las impares._

> 🔍 **Nota:** _Desde el navegador puedes inspeccionar cada elemento, modificar sus estilos y ver los cambios directamente reflejados: Botón derecho sobre el elemento `➜` Inspeccionar `➜` Inspector (CSS). Para obtener el selector CSS de un elemento: Inspector (HTML) `➜` botón derecho sobre el código HTML del elemento `➜` Copiar `➜` Selector CSS._

[^1]: Lista completa de [propiedades de estilo](https://developer.mozilla.org/en-US/docs/Web/CSS/Reference#index) disponibles en CSS.