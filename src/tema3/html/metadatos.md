# HTML
## Metadatos

El elemento `head` contiene información para procesar el documento: la codificación de caracteres usada, los estilos asociados[^1], los scripts necesarios[^2], las palabras claves para indexar el documento por los buscadores[^3], instrucciones para controlar las dimensiones y escala de la página, etc.

- Si no se especifica la codificación de caracteres el navegador puede utilizar una que no corresponde con la usada en el documento:

  | Doc. 1 | Doc. 2 |
  |:------:|:------:|
  | <iframe src="./files/encoding-1.html" width="100%" height="50" style="background:white;"></iframe> | <iframe src="./files/encoding-2.html" width="100%" height="50" style="background:white;"></iframe> |

  > ⁉️ **Pregunta:** _Los dos documentos HTML están escritos con la misma codificación ¿cuál es y cuál está usando el navegador al leer cada uno de ellos?_

  > 🔍 **Nota:** _Intenta ver el código fuente de cada uno de los marcos haciendo click derecho sobre ellos._

- Para que la experiencia de usuario sea buena en todos los tamaños y densidades de pantalla para el mismo documento[^4], es necesario decirle al navegador que ajuste su contenido al ancho de la pantalla del dispositivo en el que se está presentando[^5].

  1. Abre la página [A](./files/viewport-a.html) y la página [B](./files/viewport-b.html) en dos pestañas y comprueba que se ven idénticas.

  1. En cada una de ellas, abre las herramientas para desarrolladores pulsando en el botón derecho `➜` Inspeccionar `➜` Diseño adaptable o Barra de herramientas de dispositivos (icono de móvil/tablet).

  1. Comprueba que para el mismo dispositivo móvil la página A y la página B se ven distinto.

  > ⁉️ **Pregunta:** _¿Cuál de las dos páginas es más legible? ¿Cuál es la diferencia de comportamiento y qué etiqueta HTML lo activa?_

[^1]: Mediante la etiqueta `<link>` o `<style>`.

[^2]: Mediante la etiqueta `<script>`.

[^3]: Mediante las etiquetas `<title>` y `<meta>` con la descripción y la configuración para los robots indexadores.

[^4]: El "diseño web responsive" se apoya en el uso de CSS y en la definición de elementos con ancho adaptable para evitar el scroll horizontal.

[^5]: Los anchos del contenido se definen en píxeles abstractos, los cuales se traducen en diferente cantidad de píxeles reales dependiendo de la densidad de pantalla de cada dispositivo. Así una pantalla de alta densidad tendrá más píxeles reales por cada píxel abstracto que una de menos densidad, pero en ambas se presentará el contenido igual.