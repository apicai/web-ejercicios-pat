# JavaScript
## Web APIs
### HTTP
#### Fetch
##### `then` / `catch`

Con `then` configuramos una función que trata la respuesta, y con `catch` configuramos otra función que tratará posibles errores durante la recepción de la misma:

```js
fetch('URL', {
  method: 'POST',
  mode: 'cors',
  headers: {'Accept': 'application/json'},
  body: JSON.stringify({cuerpo: 'peticion'})
}).then(respuesta => {
  if (respuesta.ok) {
    return respuesta.json();
  } else {
    throw respuesta.status;
  }
}).then(json => {
    console.log('Respuesta OK:', json);
    // A continuación viene código que usa objeto del json ...
}).catch(error => {
  console.error('Error inexperado:', error);
  // A continuación viene código que trata el error ...
});
```

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
  fetch('https://httpstat.us/200?' + new URLSearchParams({sleep: 4000}), {
    method: 'GET',
    mode: 'cors',
    headers: {'Accept': 'application/json'}
  }).then(respuesta => {
    if (respuesta.ok) {
      return respuesta.json();
    } else {
      throw respuesta.status;
    }
  }).then(objeto => {
    mostrarMensajes(objeto);
  }).catch(error => {
    mostrarError(error);
  });
}
// Lógica para cambiar la interfaz de usuario en función
// de la respuesta recibida:
const boton = document.getElementById('boton');
const estado = document.getElementById('estado');
const mostrarMensajes = function(mensajes) {
  cambiaEstadoBoton('enabled');
  estado.textContent = `0 mensajes - Actualizado a las ${new Date().toLocaleTimeString()}`;
}
const mostrarError = function(error) {
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

> **❓ Pregunta:** _¿Para qué crees que vale el `URLSearchParams` de la query de la URL? ¿Y las cabeceras HTTP? ([pista](../../tema2/http/peticiones.html))._

> **❓ Ejercicio:** _Añade trazas al código anterior para ver qué se ejecuta cuando la URL de la petición es:_
> 1. `https://httpstat.us/500`
> 1. `https://invalid.us/`
