# JavaScript
## Web APIs

### HTTP

#### XmlHttpRequest

El objeto [`XmlHttpRequest`](https://developer.mozilla.org/en-US/docs/Web/API/XMLHttpRequest) nos permite hacer una llamada HTTP con JavaScript:

<div class="codepen" data-height="460" data-theme-id="light" data-default-tab="js" data-editable="true" style="opacity:0" data-prefill='{"stylesheets":["https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css","https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css"]}'>
  <pre data-lang="html">&lt;body>
&lt;div class="card">
  &lt;div class="card-header">Mensajes&lt;/div>
  &lt;div class="card-body row">
    &lt;div class="col text-center">
      &lt;h5 id="titulo" class="card-title">No tienes mensajes&lt;/h5>
      &lt;p id="mensaje" class="card-text">&lt;i class="bi bi-chat" style="font-size: 4rem; color:gray;">&lt;/i>&lt;/p>
      &lt;button id="boton" type="button" class="btn btn-primary" onclick="actualizar()">Actualizar&lt;/button>
    &lt;/div>
  &lt;/div>
  &lt;div id="estado" class="card-footer text-muted">Sin actualizar&lt;/div>
&lt;/div>
&lt;/body></pre>
<pre data-lang="js">const peticion = function() {
  const xhr = new XMLHttpRequest();
  // Configuramos la petición que queremos hacer
  xhr.open('POST', 'https://httpstat.us/200?' + new URLSearchParams({sleep: 4000}));
  xhr.setRequestHeader('Accept', 'application/json');
  xhr.setRequestHeader('Content-Type', 'application/json');
  // Configuramos una función para tratar la respuesta cuando llegue
  xhr.onload = () => {
    if (xhr.status === 200) {
      mostrarMensajes(JSON.parse(xhr.responseText));
    } else {
      mostrarError(xhr.status, xhr.responseText);
    }
  }
  // Ahora hacemos la petición, de forma asíncrona y en segundo plano:
  xhr.send(JSON.stringify({cuerpo: 'peticion'}));
  console.log('Este log se escribe inmediatamente sin esperar a que llegue la respuesta a la peticion anterior');
}
// Lógica para cambiar la interfaz de usuario en función
// de la respuesta recibida:
const boton = document.getElementById('boton');
const estado = document.getElementById('estado');
const mostrarMensajes = function(mensajes) {
  cambiaEstadoBoton('enabled');
  estado.textContent = `0 mensajes - Actualizado a las ${new Date().toLocaleTimeString()}`;
}
const mostrarError = function(error, mensaje) {
  cambiaEstadoBoton('enabled');
  estado.innerHTML = `&lt;i class="bi bi-exclamation-triangle-fill">&lt;/i> Error al actualizar (${error})`;
}
const mostrarActualizando = function() {
  cambiaEstadoBoton('disabled');
  estado.innerHTML = '&lt;div class="spinner-border spinner-border-sm">&lt;/div> Actualizando...';
}
const cambiaEstadoBoton = function(estado) {
  boton.disabled = estado === 'disabled';
}
const actualizar = function() {
  mostrarActualizando();
  peticion();
}
</pre><pre data-lang="css">html { font-size: 75%; padding: 2rem; }</pre></div>

> ⁉️ **Pregunta:** _¿Para qué crees que vale el `URLSearchParams` de la query de la URL? ¿Y las cabeceras HTTP? ([pista](../../tema2/http/peticiones.html))._

> ⁉️ **Ejercicio:** _El evento `onload` nos permite procesar la respuesta cuando llega, ya venga con un [código HTTP de éxito o de fallo](../../tema2/http/respuestas.html). Pero si la conexión TCP fallara o se produjera un timeout, no se notificaría por el evento `onload`. Cambia el dominio de la URL a uno que no exista, y comprueba el comportamiento. Para arreglar el problema, utiliza el evento `onerror`._