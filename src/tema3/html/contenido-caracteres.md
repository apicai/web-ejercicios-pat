# HTML
## Contenido

### Caracteres reservados

Los textos no pueden contener directamente los caracteres `<` y `>` porque podrían interpretarse como código HTML. Para usarlos se han de escribir como [entidades HTML](https://developer.mozilla.org/en-US/docs/Glossary/Entity).

<div class="codepen" data-prefill data-height="200" data-theme-id="light" data-default-tab="html,result" data-editable="true" style="opacity:0">
<pre data-lang="html">
&amp;lt;
&amp;gt;
&amp;amp;
&amp;quot;
</pre>
</div>

Además, HTML ignora los retornos de carro normales introducidos en el código con la tecla <kbd>↲</kbd>. También, ignora varios espacios consecutivos e interpreta uno solo. En su lugar se usa [`<br>`](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/br) y `&nbsp;` respectivamente.

> 🔍 **Nota:** _Ni `<br>` ni `&nbsp;` deben usarse para crear márgenes, ya que eso es estilo/maquetación, y debe realizarse con CSS como veremos en el siguiente tema._

> **❓ Ejercicio:** _Separa en dos líneas el texto `< > & "` anterior. Prueba a introducir varios espacios normales entre caracteres, y comprueba como se visualiza._