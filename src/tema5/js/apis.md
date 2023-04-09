# JavaScript
## Web APIs

Javascript, como el resto de lenguajes, tiene una [librería estándar](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects) de funciones y objetos que nos facilitan escribir aplicaciones. Aparte de ella, hay APIs o librerías adicionales dependiendo de su entorno de ejecución: navegadores, servidores, aplicaciones nativas móviles o de escritorio, etc. De la lista de [APIs disponibles en un navegador web](https://developer.mozilla.org/en-US/docs/Learn/JavaScript/Client-side_web_APIs/Introduction), vamos a ver las siguientes:

- BOM
- DOM
- Eventos
- HTTP
- Almacenamiento
- Webcam
- Web components

Para que una página web cargue código JavaScript, existen dos posibilidades:

1. Incluyendo el código JS en el propio HTML:

   ```html
   <!DOCTYPE html>
   <html lang="es">
   <head>
     <title>Codificado junto al HTML</title>
     <script>
       console.log("Se ejecuta antes de cargar el HTML");
     </script>
   </head>
   <body>
     <!-- Contenido -->
     <script>
       console.log("Se ejecuta después de cargar el HTML");
     </script>
   </body>
   </html>
   ```

1. Referenciando a ficheros JS externos:

   ```html
   <!DOCTYPE html>
   <html lang="es">
   <head>
     <title>Importado como librería</title>
     <script src="URL (absoluta o relativa) al fichero JS"></script>
   </head>
   <body>
     <!-- Contenido -->
     <script src="URL a otro fichero JS"></script>
   </body>
   </html>
   ```

> 🔍 **Nota:** _Para depurar el código JS: botón derecho `➜` "Inspeccionar" `➜` "Depurador" o "Sources". Selecciona el fichero con el código JS en el árbol de ficheros de la izquierda. Para añadir un punto de ruptura y que la ejecución se pare, marca uno de los números de línea del fichero abierto. Recarga la página si esa línea se ejecutó al cargar la página._