# HTML
## Metadatos

### Configuración ventana gráfica

Para que la experiencia de usuario sea buena en todos los tamaños y densidades de pantalla para el mismo documento[^1], es necesario decirle al navegador que ajuste su contenido al ancho de la pantalla del dispositivo en el que se está presentando[^2].

1. Abre la página [A](./files/viewport-a.html) y la página [B](./files/viewport-b.html) en dos pestañas y comprueba que se ven idénticas en un navegador de ordenador.

1. Ábrelas en tu móvil o, si no, abre las herramientas para desarrolladores del navegador del ordenador pulsando en el botón derecho `➜` Inspeccionar `➜` Diseño adaptable o Barra de herramientas de dispositivos (icono de móvil/tablet) sobre cada pestaña.

1. Comprueba que para el mismo dispositivo móvil la página A y la página B se ven distinto.

> ⁉️ **Pregunta:** _¿Cuál es la diferencia de comportamiento y qué etiqueta HTML lo activa?_

[^1]: El "diseño web responsivo" se apoya en el uso de CSS y en la definición de elementos con ancho adaptable para evitar el scroll horizontal.

[^2]: Los anchos del contenido se definen en píxeles abstractos, los cuales se traducen en diferente cantidad de píxeles reales dependiendo de la densidad de pantalla de cada dispositivo. Así una pantalla de alta densidad tendrá más píxeles reales por cada píxel abstracto que una de menos densidad, pero en ambas se presentará el contenido igual.