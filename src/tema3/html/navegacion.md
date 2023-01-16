# HTML
## Navegación

La etiqueta `<a href="{URL}">texto o bloque</a>` permite: navegar a otra web (con una URL absoluta), a otra página dentro de la web actual (con una URL relativa) o a un elemento de la página actual (indicando el `#fragmento`).

- Crea los 3 enlaces indicados en los comentarios del siguiente HTML:

  <div class="codepen" data-prefill data-height="350" data-theme-id="light" data-default-tab="html,result" data-editable="true" style="opacity:0">
  <pre data-lang="css">
  #contenido { margin:120px 0 120px 0; }
  </pre>
  <pre data-lang="html">
  &lt;h1>Navegación&lt;/h1>
  &lt;!-- 1. Enlace al elemento cuyo id es "contenido" -->
  &lt;a>Contenido&lt;/a>
  &lt;!-- 2. Enlace absoluto a https://en.wikipedia.org/wiki/Hyperlink -->
  &lt;a>Externo&lt;/a>
  &lt;!-- 3. Enlace relativo a ./dir/file.html -->
  &lt;a>Interno&lt;/a>

  &lt;p id="contenido">Este elemento puede enlazarse utilizando su id en el fragmento de la URL: #contenido&lt;/p>
  &lt;a href="#">Volver arriba&lt;/a>
  </pre>
  </div>

  > 🔍 **Notas:** ❶ _Para volver tras pulsar tus enlaces, dale al botón "Rerun"._ ❷ _El enlace relativo lo es al dominio en el que se encuentra alojado que es Codepen.io._

- Los enlaces relativos pueden ser al dominio o al path actual:

  <iframe src="./files/relative-link-a.html" width="100%" height="70" style="background:white;"></iframe>

- Añade el siguiente atributo a los enlaces anteriores `target="_blank"` y observa el comportamiento.

- Utiliza esta URL en alguno de los enlaces anteriores `mailto:usuario@email.com?subject=Asunto&body=Contenido` y comprueba el comportamiento.

  > 🔍 **Nota:** _`mailto` es una URL con un protocolo diferente a HTTP, y que el SO operativo puede reconocer para abrir la aplicación que es capaz de entender dicho protocolo. Existen muchos otros protocolos o [esquemas URI](https://en.wikipedia.org/wiki/List_of_URI_schemes) que podrían utilizarse potencialmente en un enlace._