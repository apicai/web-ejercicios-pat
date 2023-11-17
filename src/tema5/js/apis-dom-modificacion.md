# JavaScript
## Web APIs

### DOM

#### Modificación

Puedes modificar las propiedades de los elementos del DOM con JavaScript. Pega el siguiente código en la consola JavaScript del navegador y observa el comportamiento.

```js
const webApis = document.getElementById('web-apis');
console.log('Antes de manipular:', webApis);

webApis.style = 'color:green';
webApis.textContent = 'Modificado desde JS';
webApis.classList.add('boring');
console.log('Después de manipular:', webApis);
```

> **❓ Ejercicio:** _En el siguiente Codepen, modifica el código de la función JS `actualizar` para que modifique los elementos `titulo` y `mensaje` del HTML via DOM con el contenido del mensaje `nuevoMensaje`._

<div class="codepen" data-height="360" data-theme-id="light" data-default-tab="js,result" data-editable="true" style="opacity:0" data-prefill='{"stylesheets":["https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css","https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css"]}'>
  <pre data-lang="html">&lt;body>
&lt;div class="card">
  &lt;div class="card-header">Mensajes&lt;/div>
  &lt;div class="card-body row">
    &lt;div class="col text-center">
      &lt;h5 id="titulo" class="card-title">No tienes mensajes&lt;/h5>
      &lt;p id="mensaje" class="card-text">&lt;i class="bi bi-chat" style="font-size: 4rem; color:gray;">&lt;/i>&lt;/p>
      &lt;button type="button" class="btn btn-primary" onclick="actualizar()">Actualizar&lt;/button>
    &lt;/div>
  &lt;/div>
  &lt;div id="estado" class="card-footer text-muted">Sin actualizar&lt;/div>
&lt;/div>
&lt;/body></pre>
<pre data-lang="js">const nuevoMensaje = {
  titulo: 'Aprendiendo DOM',
  mensaje:
    'Estoy actualizando un elemento del HTML con un contenido en JS. Ese contenido es fijo en este ejemplo, pero podría venir de una respuesta del servidor de mensajes.'
};
// Actualiza la tarjeta con el contenido del mensaje
const actualizar = function actualizar() {
  const estado = document.getElementById('estado');
  estado.textContent = `Actualizado a las ${new Date().toLocaleTimeString()}`;
};
</pre><pre data-lang="css">html { font-size: 75%; padding: 2rem; }</pre></div>