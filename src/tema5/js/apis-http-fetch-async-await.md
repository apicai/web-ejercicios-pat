# JavaScript
## Web APIs
### HTTP
#### Fetch
##### `async` / `await`

Con `await` esperamos a que la operación asíncrona termine (la promesa), y con `async` marcamos aquellas funciones que en su interior tienen operaciones asíncronas (tienen `await` y/o retornan promesas). Con este sistema se consigue un código sin [funciones anidadas](https://stackoverflow.com/questions/70777325/how-to-escape-this-callback-hell) más sencillo de seguir:

  ```js
  const peticion = async function() {
    try {
      const respuesta = await fetch('URL', {
        method: 'POST',
        mode: 'cors',
        headers: {'Accept': 'application/json', 'Content-Type': 'application/json'},
        body: JSON.stringify({cuerpo: 'peticion'}),
      });
      if (respuesta.ok) {
        const objeto = await respuesta.json();
        console.log('Respuesta OK:', objeto);
        return objeto;
      } else {
        console.log('Respuesta KO:', respuesta.status);
        throw respuesta;
      }
    } catch (error) {
      console.error('Error inexperado:', error);
      throw error;
    }
  }
  const objetoRespuesta = await peticion();
  ```

> **❓ Ejercicio:** _Cambia el código del ejemplo anterior para que en utilice `async` y `await`._
> <div class="codepen" data-height="460" data-theme-id="light" data-default-tab="js" data-editable="true" style="opacity:0" data-prefill='{"stylesheets":["https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css","https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css"]}'>
>  <pre data-lang="html">&lt;body>
> &lt;div class="card">
>   &lt;div class="card-header">Mensajes&lt;/div>
>   &lt;div class="card-body row">
>     &lt;div class="col text-center">
>       &lt;h5 id="titulo" class="card-title">No tienes mensajes&lt;/h5>
>       &lt;p id="mensaje" class="card-text">&lt;i class="bi bi-chat" style="font-size: 4rem; color:gray;">&lt;/i>&lt;/p>
>       &lt;button id="boton" type="button" class="btn btn-primary" onclick="actualizar()">Actualizar&lt;/button>
>     &lt;/div>
>   &lt;/div>
>   &lt;div id="estado" class="card-footer text-muted">Sin actualizar&lt;/div>
> &lt;/div>
> &lt;/body></pre>
> <pre data-lang="js">const peticion = async function() {
>   // Completar ...
> }
> // Lógica para cambiar la interfaz de usuario en función
> // de la respuesta recibida:
> const boton = document.getElementById('boton');
> const estado = document.getElementById('estado');
> const mostrarMensajes = function(mensajes) {
>   cambiaEstadoBoton('enabled');
>   estado.textContent = `0 mensajes - Actualizado a las ${new Date().toLocaleTimeString()}`;
> }
> const mostrarError = function(error) {
>   cambiaEstadoBoton('enabled');
>   estado.innerHTML = `&lt;i class="bi bi-exclamation-triangle-fill">&lt;/i> Error al actualizar (${error})`;
> }
> const mostrarActualizando = function() {
>   cambiaEstadoBoton('disabled');
>   estado.innerHTML = '&lt;div class="spinner-border spinner-border-sm">&lt;/div> Actualizando...';
> }
> const cambiaEstadoBoton = function(estado) {
>   boton.disabled = estado === 'disabled';
> }
> const actualizar = function() {
>   mostrarActualizando();
>   peticion();
> }
> </pre><pre data-lang="css">html { font-size: 75%; padding: 2rem; }</pre></div>