# HTML
## Navegación

La etiqueta [`<a href="{URL}">texto o bloque</a>`](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/a) permite navegar a: 
- Otra web, con una **URL absoluta**
- Otra página dentro de la web actual, con una **URL relativa**
- Un elemento de la página actual, indicando el `#fragmento`

> **❓ Ejercicio 1:** _Crea los 3 enlaces indicados en los comentarios del siguiente HTML:_
> <div class="codepen" data-prefill="{}" data-height="350" data-theme-id="light" data-default-tab="html,result" data-editable="true" style="opacity:0">
> <pre data-lang="css">
> #contenido { margin:120px 0 120px 0; }
> </pre>
> <pre data-lang="html">
> &lt;body>
> &lt;h1>Navegación&lt;/h1>
> &lt;!-- 1. Enlace al elemento cuyo id es "contenido" -->
> &lt;a>Contenido&lt;/a>
> &lt;!-- 2. Enlace absoluto a https://en.wikipedia.org/wiki/Hyperlink -->
> &lt;a>Externo&lt;/a>
> &lt;!-- 3. Enlace relativo a ./dir/file.html -->
> &lt;a>Interno&lt;/a>
> 
> &lt;p id="contenido">Este elemento puede enlazarse utilizando su id en el fragmento de la URL: #contenido&lt;/p>
> &lt;a href="#">Volver arriba&lt;/a>
> &lt;/body>
> </pre>
> </div>

> 🔍 **Nota:** _Para volver tras pulsar tus enlaces, dale al botón "Rerun"._

Los **enlaces relativos** pueden ser al dominio[^1] o al path actual:

<iframe src="./files/relative-link-a.html" width="100%" height="100" style="background:white;"></iframe>

Para que un enlace se **abra en una nueva pestaña o ventana** del navegador se utiliza el atributo `target="_blank"`. 

Algunos enlaces pueden tener un **protocolo diferente** a HTTP. Al pulsarlo, se abrirá la aplicación del SO asociada a dicho protocolo[^2] si la hubiera. Por ejemplo, este abrirá el programa de correo electrónico:
```html
href="mailto:usuario@email.com?subject=Asunto&body=Contenido"
```

> **❓ Ejercicio 2:** _Modifica uno de los enlaces anteriores para que se abra en una ventana/pestaña nueva, y otro para que al pulsar se redacte un correo._

[^1]: El enlace relativo del primer ejercicio lo es al dominio en el que se encuentra alojado que es Codepen.io, donde probablemente no exista el fichero `./dir/file.html`.

[^2]: Existen muchos otros protocolos o [esquemas URI](https://en.wikipedia.org/wiki/List_of_URI_schemes) que podrían potencialmente utilizarse en un enlace.