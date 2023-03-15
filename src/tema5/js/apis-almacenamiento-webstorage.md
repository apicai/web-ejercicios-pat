# JavaScript
## Web APIs

### Almacenamiento

#### Web Storage

Existen dos tipos:

- `sessionStorage`: los datos se borran al cerrar el navegador.
- `localStorage`: los datos permanecen hasta que el usuario o la aplicación JavaScript los borra.

En ambos casos:

- `setItem('clave', 'valor')`: para guardar.
- `getItem('clave')`: para recuperar lo guardado.
- `clear()` o `removeItem('clave')` para borrar.

> ⁉️ **Ejercicio:** _En el siguiente ejemplo queremos que si el servidor falla al enviar el mensaje, que éste se guarde localmente para no perderlo y reintentar el envío en otro momento. Implementa las funciones `autoGuardado` y `autoRecuperado` para que, respectivamente, guarden y lean el mensaje introducido por el usuario. Usa `localStorage` y el método `mensajeJson` para guardar su valor como JSON._

<div class="codepen" data-height="350" data-theme-id="light" data-default-tab="js,result" data-editable="true" style="opacity:0" data-prefill='{"stylesheets":["https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css","https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css"]}'>
  <pre data-lang="html">&lt;form id="formulario" class="row g-3" novalidate>
  &lt;div class="col-12">
    &lt;label for="titulo" class="form-label">Título&lt;/label>
    &lt;input type="text" class="form-control" id="titulo" name="titulo" required>
    &lt;div class="invalid-feedback">
      El título es obligatorio
    &lt;/div>
  &lt;/div>
  &lt;div class="col-12">
    &lt;label for="cuerpo" class="form-label">Cuerpo&lt;/label>
    &lt;textarea class="form-control" id="cuerpo" name="cuerpo" rows="3" required>&lt;/textarea>
    &lt;div class="invalid-feedback">
      El texto del cuerpo es obligatorio
    &lt;/div>
  &lt;/div>
  &lt;div class="col-auto">
    &lt;button id="enviar" class="btn btn-primary" type="submit">Enviar&lt;/button>
  &lt;/div>
  &lt;div id="estado" class="col-8 align-self-center text-muted">&lt;/div>
&lt;/form></pre>
  <pre data-lang="css">html { font-size: 60%; padding: 2rem; }</pre>
  <pre data-lang="js">// Servidor mensajes (500 falla, 200 funciona):
const servidorUrl = 'https://httpstat.us/500';
// Elementos a manipular
const titulo = document.getElementById('titulo');
const cuerpo = document.getElementById('cuerpo');
// EJERCICIO: funcionalidad de guardado en el local storage
const autoGuardado = () => {};
const autoRecuperado = () => {};
titulo.onchange = autoGuardado;
cuerpo.onchange = autoGuardado;
window.onload = function() {
  const mensaje = autoRecuperado() || {};
  titulo.value = mensaje.titulo || '';
  cuerpo.value = mensaje.cuerpo || '';
}
const mensajeJson = 
  () => `{"titulo":"${titulo.value}","cuerpo":"${cuerpo.value}"}`;
// Funcionalidad de envío
const enviar = document.getElementById('enviar');
const estado = document.getElementById('estado');
const formulario = document.getElementById('formulario');
formulario.onsubmit = function(e) {
  estado.innerHTML = '';
  formulario.classList.add('was-validated');
  formulario.checkValidity() && enviarPeticion();
  return false;
}
const enviarPeticion = async function() {
  enviar.innerHTML = 
    '&lt;div class="spinner-border spinner-border-sm">&lt;/div> Enviando';
  enviar.disabled = true;
  try {
    const respuesta = await fetch(
      servidorUrl + '?' + new URLSearchParams({sleep: 1000}), 
      { method: 'POST', body: mensajeJson() }
    );
    if (respuesta.ok) { exito(); } else { fallo(); }
  } catch(error) {
    fallo();
  } finally {
    enviar.textContent = 'Enviar';
    enviar.disabled = false;
    formulario.classList.remove('was-validated');
  }
}
const exito = function() {
  localStorage.clear();
  formulario.reset();
  estado.innerHTML = 
    '&lt;i class="bi bi-send-check">&lt;/i> ¡Mensaje enviado!';
}
const fallo = function() {
  estado.innerHTML = 
    '&lt;i class="bi bi-send-exclamation">&lt;/i> Fallo al enviar.';
}
</pre></div>

