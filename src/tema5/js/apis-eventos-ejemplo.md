# JavaScript
## Web APIs

### Eventos

#### Ejemplo

El siguiente ejemplo necesita que se añadan eventos a los elementos del formulario para completar su correcto funcionamiento:

1. Mostrar el número de caracteres restantes que quedan al escribir el cuerpo.
1. Previsualizar la imagen seleccionada, bien mediante fichero, o bien mediante URL.
1. Antes de enviar el formulario, validar que se ha proporcionado una imagen válida.

<div class="codepen" data-height="400" data-theme-id="light" data-default-tab="js,result" data-editable="true" style="opacity:0" data-prefill='{"stylesheets":["https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css","https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css"]}'>
  <pre data-lang="html">&lt;form id="formulario" action="/form" class="row g-3" method="post" enctype="multipart/form-data">
  &lt;div class="col-12">
    &lt;div class="row g-3">
      &lt;div class="col-12">
        &lt;label for="titulo" class="form-label">Título&lt;/label>
        &lt;input type="text" class="form-control" id="titulo" name="titulo" maxlength="40" required>
        &lt;div class="invalid-feedback">
          El título es obligatorio
        &lt;/div>
      &lt;/div>
      &lt;div class="col-12">
        &lt;label for="cuerpo" class="form-label">Cuerpo&lt;/label>
        &lt;textarea class="form-control" placeholder="Máximo 220 caracteres" id="cuerpo" name="cuerpo" rows="3" maxlength="220" required>&lt;/textarea>
        &lt;div class="invalid-feedback">
          El texto del cuerpo es obligatorio
        &lt;/div>
      &lt;/div>
    &lt;/div>
  &lt;/div>
  &lt;div class="col-12">
    &lt;div class="row">
      &lt;div class="col">
        &lt;div class="row g-3">
          &lt;div class="col-12">
            &lt;label for="fichero" class="form-label">Subir imagen de fichero...&lt;/label>
            &lt;input class="form-control" type="file" id="fichero" name="fichero" accept="image/png, image/jpeg, image/svg+xml">
            &lt;div class="invalid-feedback">
              Selecciona un fichero de imagen: png, jpg, svg.
            &lt;/div>
          &lt;/div>
          &lt;div class="col-12">
            &lt;label for="url" class="form-label">Subir imagen de URL...&lt;/label>
            &lt;input type="url" class="form-control" id="url" name="url">
            &lt;div class="invalid-feedback">
              Indica una URL de imagen válida
            &lt;/div>
          &lt;/div>
        &lt;/div>
      &lt;/div>
      &lt;div class="col-auto align-self-center text-center text-muted">
        &lt;figure style="width: 11rem">
          &lt;img id="imagen" class="p-2 border" style="max-width: 100%" alt="Sin imagen" onload="this.ok=true;" onerror="this.ok=false;">
        &lt;/figure>
      &lt;/div>
    &lt;/div>
  &lt;/div>
  &lt;div class="col-12 mt-4">
    &lt;input class="btn btn-primary" type="submit" value="Enviar">
  &lt;/div>
&lt;/form></pre>
  <pre data-lang="css">html { font-size: 60%; padding: 2rem; }</pre>
  <pre data-lang="js">// Elementos a los que añadir eventos:
const cuerpo = document.getElementById('cuerpo');
const fichero = document.getElementById('fichero');
const url = document.getElementById('url');
const formulario = document.getElementById('formulario');
// Funciones a utilizar al capturar los eventos:
// 1. Para presentar el número de caracteres restantes
const caracteresRestantes = () =>
  document.querySelector('label[for="cuerpo"]').textContent = 
    `Cuerpo (${220 - cuerpo.value.length} caracteres restantes)`;
// 2. Para presentar la imagen de URL
const verImagenUrl = () => actualizaImagen(url.value);
const actualizaImagen = (src) => {
  document.getElementById('imagen').src = src;
  url.setCustomValidity('');
}
// 3. Para presentar la imagen de fichero
const verImagenFichero = () => {
  const reader = new FileReader();
  reader.onload = (event) => actualizaImagen(event.target.result);
  fichero.files && fichero.files.length && reader.readAsDataURL(fichero.files[0]);
};
// 4. Para saber si la imagen es correcta
const validaImagen = () => {
  const imagen = document.getElementById('imagen');
  const valida = imagen.getAttribute('src') || imagen.ok || false;
  url.setCustomValidity(valida ? '' : 'Imagen incorrecta');
  formulario.classList.add('was-validated');
  return valida;
};
// Tarea 1: actualiza el número de caracteres restantes a medida que se escribe el cuerpo
// Tarea 2: actualiza la imagen cuando cambie el campo de fichero o URL
// Tarea 3: comprueba que la imagen es válida antes de enviar el formulario
</pre></div>

> **❓ Ejercicio 1:** _Escucha al evento `keyup` en el elemento `cuerpo` para que al introducir un caracter en él se actualice el número de caracteres restantes (llamando a la función `caracteresRestantes`)._

> **❓ Ejercicio 2:** _Escucha al evento `change` en los elementos `fichero` y `url` para que cuando cambien su valor, se previsualice la imagen a su derecha (llamando a las funciones `verImagenFichero` y `verImagenUrl`, respectivamente)._

> **❓ Ejercicio 3:** _Escucha al evento `submit` en el elemento `formulario` para validar que la imagen es correcta antes del envío (llamando a la función `validaImagen`). En caso de no ser válida, tendrás que parar el envío devolviendo `false`._

> **❓ Ejercicio 4:** _Si el usuario rellenara los dos campos para proporcionar la imagen, ambos se enviarían al servidor. Para evitar eso, cuando se seleccione una imagen por uno de ellos habría que resetear el otro campo. Añade al código del ejercicio 2: `url.value = ''` o `fichero.value = ''`._

