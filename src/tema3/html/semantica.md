# HTML
## Semántica

Los elementos HTML deben organizarse en bloques semánticos para: 
- Mejorar el indexado de contenidos por parte de los buscadores
- Mejorar la accesibilidad a la web a personas con discapacidad (lectores de pantalla)
- Organizar el código de forma que sea más mantenible.

> 🔍 **Nota:** _Es importante no confundir la organización del contenido (etiquetas semánticas) con su presentación (CSS). Este error es habitual, y de hecho había etiquetas HTML cuya funcionalidad era dar estilo (`<font>`, `<center>`, etc.) y han sido deprecadas. Otro error es abusar de etiquetas de bloque sin semántica (`<div>`, `<span>`)._

A continuación, se muestran diferentes elementos HTML usando etiquetas no semánticas:

```html
<span>Título principal</span>
<div onclick="">Enviar formulario</div>
<b>Este texto es importante resaltarlo</b>
Párrafo 1<br><br>Párrafo 2
Campo: <input type="text">
Más información sobre accesibilidad <a href="">aquí</a>.
```

> **❓ Pregunta:** _¿Con qué etiquetas semánticas sustituirías los anteriores elementos?_

A continuación, se muestra un ejemplo de organización de una web usando los correspondientes bloques semánticos:

```html
<body>
<header>
  <h1>Cabecera común a toda la web</h1>
</header>
<nav><!-- Menú de navegación por la web --> 
  <ul>
      <li><a href="#">Menu 1</a></li>
      <li><a href="#">Menu 2</a></li>
  </ul>
</nav>
<main> <!-- Contenido principal de la página actual-->
  <article> <!-- Algo autocontenido, distribuible, reusable de forma independiente -->
    <h2>Título del artículo</h2>
    <section>
      <h3>Título de una sección dentro del artículo</h3>
      <p>Contenido de la sección</p>
    </section>
    <aside>
      <h3>Contenido relacionado indirectamente: citas, tabla de contenidos, etc.</h3>
      <figure>
        <img alt="Imagen con leyenda" src="img">
        <figcaption>Leyenda de la imagen</figcaption>
      </figure>
    </aside>
  </article>
</main>
<footer>
  <p>Pie de página para toda la web</p>
</footer>
</body>
```

> **❓ Ejercicio:** _Entra en [esta página web](https://developer.mozilla.org/en-US/docs/Learn/HTML/Introduction_to_HTML/Document_and_website_structure) e identifica cada sección con alguno de los bloques semánticos anteriores._