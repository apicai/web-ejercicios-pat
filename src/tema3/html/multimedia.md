# HTML
## Multimedia

Además de textos, en una página se pueden incluir imágenes, audios, vídeos, otras páginas web, etc.

### Imagen

Realiza de una en una las siguientes modificaciones sobre la etiqueta `<img>` del siguiente HTML:

<div class="codepen" data-prefill data-height="300" data-theme-id="light" data-default-tab="html,result" data-editable="true" style="opacity:0">
<pre data-lang="html">&lt;body>
&lt;p>
Texto antes &lt;img src="URL imagen (absoluta o relativa)"/> Texto después 
&lt;/p>
&lt;/body>
</pre>
</div>

1. Añade el atributo `alt="Este texto aparece cuando la imagen no se puede cargar"`.

1. Cambia el valor del atributo `src` a `"https://upload.wikimedia.org/wikipedia/commons/b/bb/Wikipedia_wordmark.svg"`.

1. Añade el atributo `width="100"`[^1].

1. Añade el atributo `height="100"`[^2].

### Vídeo

Realiza de una en una las siguientes modificaciones sobre la etiqueta `<video>` del siguiente HTML:

<div class="codepen" data-prefill data-height="300" data-theme-id="light" data-default-tab="html,result" data-editable="true" style="opacity:0">
<pre data-lang="html">&lt;body>
&lt;p>
Texto antes
&lt;video src="URL vídeo (absoluta o relativa)" controls>&lt;/video>
Texto después
&lt;/p>
&lt;/body>
</pre>
</div>

1. Cambia el valor del atributo `src` a `"https://dl8.webmfiles.org/big-buck-bunny_trailer.webm"`.

1. Añade el atributo `width="200"`[^1].

1. Añade el atributo `height="300"`[^3].

1. Cambia la etiqueta `video` por `audio`[^4].

### Iframe

A veces es interesante embeber otra página web dentro de la actual para proporcionar funcionalidad desarrollada en otros servicios. Realiza de una en una las siguientes modificaciones sobre la etiqueta `<iframe>` del siguiente HTML:

<div class="codepen" data-prefill data-height="300" data-theme-id="light" data-default-tab="html,result" data-editable="true" style="opacity:0">
<pre data-lang="html">&lt;body>
&lt;p>
Texto antes
&lt;iframe src="URL (absoluta o relativa)" >&lt;/iframe>
Texto después
&lt;/p>
&lt;/body>
</pre>
</div>

1. Cambia el valor del atributo `src` a: 
   ```url
   https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3037.043120802949!2d-3.71490468429349!3d40.430044062753005!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd4228662ebd8eeb%3A0xd7c09eaa5e0b0c59!2sEscuela%20T%C3%A9cnica%20Superior%20de%20Ingenier%C3%ADa%20(ICAI)!5e0!3m2!1ses!2ses!4v1673823476079!5m2!1ses!2ses
   ```

1. Añade el atributo `width="200"`[^5].

1. Añade el atributo `height="300"`[^5].

1. Cambia el valor del atributo `src` a `"https://developer.mozilla.org/en-US/docs/Web/HTML/Element/iframe"`[^6].

[^1]: Reducción proporcional, los textos flotan alrededor.

[^2]: La imagen se distorsiona al no mantenerse su relación de aspecto.

[^3]: El vídeo mantiene sus proporciones, mientras el reproductor cambia sus dimensiones.

[^4]: El reproductor de audio ignora las dimensiones.

[^5]: Se ajusta el tamaño del marco, los textos flotan alrededor.

[^6]: Las webs pueden impedir que otras intenten embeberlas usando la cabecera HTTP `X-Frame-Options: deny` por temas de seguridad o robo de contenido.