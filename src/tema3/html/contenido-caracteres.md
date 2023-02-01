# HTML
## Contenido

### Caracteres reservados

Hay otras etiquetas que solo deben ir dentro de bloques de texto. Un ejemplo es `<br>` que permite añadir un retorno de carro[^1]. Además, los textos no pueden contener directamente los caracteres `<` y `>` porque podrían interpretarse como código HTML. Para usarlos se han de escribir como [entidades HTML](https://developer.mozilla.org/en-US/docs/Glossary/Entity):

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
