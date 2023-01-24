# HTML
## Metadatos

El elemento `head` contiene información para procesar el documento: la codificación de caracteres usada, los estilos asociados[^1], los scripts necesarios[^2], las palabras claves para indexar el documento por los buscadores[^3], configuración de la ventana gráfica del navegador, etc. A continuación vemos un par de ejemplos de metadatos.

### Codificación

Si no se especifica la codificación de caracteres el navegador puede utilizar una que no corresponde con la usada en el documento:

| Doc. 1 | Doc. 2 |
|:------:|:------:|
| <iframe src="./files/encoding-1.html" width="100%" height="50" style="background:white;"></iframe> | <iframe src="./files/encoding-2.html" width="100%" height="50" style="background:white;"></iframe> |

> ⁉️ **Pregunta:** _Los ficheros anteriores están guardados con diferente codificación, que está convenientemente declarada como metainformación en el HTML ¿cuáles son sus codificaciones? ¿por qué solo uno de ellos se ve correctamente?_

> 🔍 **Nota:** _Intenta ver el código fuente de cada uno de los marcos haciendo click derecho sobre ellos._

### Configuración ventana gráfica

Para que la experiencia de usuario sea buena en todos los tamaños y densidades de pantalla para el mismo documento[^4], es necesario decirle al navegador que ajuste su contenido al ancho de la pantalla del dispositivo en el que se está presentando[^5].

1. Abre la página [A](./files/viewport-a.html) y la página [B](./files/viewport-b.html) en dos pestañas y comprueba que se ven idénticas en un navegador de ordenador.

1. Ábrelas en tu móvil o, si no, abre las herramientas para desarrolladores del navegador del ordenador pulsando en el botón derecho `➜` Inspeccionar `➜` Diseño adaptable o Barra de herramientas de dispositivos (icono de móvil/tablet) sobre cada pestaña.

1. Comprueba que para el mismo dispositivo móvil la página A y la página B se ven distinto.

> ⁉️ **Pregunta:** _¿Cuál es la diferencia de comportamiento y qué etiqueta HTML lo activa?_

[^1]: Mediante la etiqueta `<link>` o `<style>`.

[^2]: Mediante la etiqueta `<script>`.

[^3]: Mediante las etiquetas `<title>` y `<meta>` con la descripción y la configuración para los robots indexadores.

[^4]: El "diseño web responsivo" se apoya en el uso de CSS y en la definición de elementos con ancho adaptable para evitar el scroll horizontal.

[^5]: Los anchos del contenido se definen en píxeles abstractos, los cuales se traducen en diferente cantidad de píxeles reales dependiendo de la densidad de pantalla de cada dispositivo. Así una pantalla de alta densidad tendrá más píxeles reales por cada píxel abstracto que una de menos densidad, pero en ambas se presentará el contenido igual.