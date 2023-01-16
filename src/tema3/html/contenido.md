# HTML
## Contenido

La etiqueta `<body>` contiene los elementos visibles. Existen diferentes tipos, aquí vamos a ver algunos relacionados con bloques de texto.

> ⚠️ **Importante**: _Los siguientes ejercicios se hacen sobre la plataforma Codepen.io. Si los haces desde aquí, al navegar a la siguiente página, tus cambios se pierden. Si los quieres guardar, pulsa en "Edit on Codepen" `➜` "Save" (requiere registrarse)._

- Crea una lista usando `<ul>`, y `<li>` para sus elementos, con el siguiente contenido. Luego prueba con `<ol>` en lugar de `<ul>`.

  <div class="codepen" data-prefill data-height="250" data-theme-id="light" data-default-tab="html,result" data-editable="true" style="opacity:0">
  <pre data-lang="html">
  * Bloques de texto
    - Títulos
    - Párrafos
    - Listas
    - Tablas
  * Otros
    - Separadores
  </pre>
  </div>

- Crea una tabla usando `<table>`, `<tr>` para las filas, y `<td>` para las celdas, con el siguiente contenido. Luego separa la cabecera con `<thead>` del resto con `<tbody>`.

  <div class="codepen" data-prefill data-height="250" data-theme-id="light" data-default-tab="html,result" data-editable="true" style="opacity:0">
  <pre data-lang="html">
  | Tipo       | Elementos     |
  |------------|---------------|
  | Título     | h1, ... , h6  |
  | Párrafo    | p             |
  | Listas     | ul, ol, li    |
  | Tablas     | table, tr, td |
  | Separador  | hr            |
  </pre>
  </div>

- Hay otras etiquetas que solo deben ir dentro de bloques de texto. Un ejemplo es `<br>` que permite añadir un retorno de carro[^1]. Además, los textos no pueden contener directamente los caracteres `<` y `>` porque podrían interpretarse como código HTML. Para usarlos se han de escribir como [entidades HTML](https://developer.mozilla.org/en-US/docs/Glossary/Entity):

  <div class="codepen" data-prefill data-height="200" data-theme-id="light" data-default-tab="html,result" data-editable="true" style="opacity:0">
  <pre data-lang="html">
  &amp;lt;
  &amp;gt;
  &lt;br>
  &amp;amp;
  &amp;quot;
  </pre>
  </div>

[^1]: HTML ignora los retornos de carro normales introducidos en código con la tecla <kbd>↲</kbd>.
