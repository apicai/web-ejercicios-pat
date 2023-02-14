# JavaScript
## Web APIs

### Web Components

Son un conjunto de APIs que nos permiten crear nuevas etiquetas HTML con su propia funcionalidad. Por ejemplo, podemos crear la etiqueta `<snap-shot>` que encapsule la funcionalidad del ejemplo anterior con la webcam. Luego, esta etiqueta se podrá utilizar como cualquier otra del HTML estándar en aquellas páginas que lo necesiten[^1].

A continuación, se muestra el ejemplo anterior de la webcam pero implementado con [este Web Component](https://apicai.github.io/web-ejercicios-pat-2023/tema5/js/files/snap-shot.js).

<div class="codepen" data-height="460" data-theme-id="light" data-default-tab="html,result" data-editable="true" style="opacity:0" data-prefill='{"stylesheets":["https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css","https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css"],"scripts":["https://apicai.github.io/web-ejercicios-pat-2023/tema5/js/files/snap-shot.js"]}' data-allow="camera; display-capture; geolocation; microphone">
  <pre data-lang="html">&lt;body>
&lt;div class="card">
  &lt;div class="card-body row">
    &lt;div class="col-12">
      &lt;snap-shot id="snapshot">Cámara no disponible&lt;/snapshot>
    &lt;/div>
    &lt;div class="col-12 text-center mt-3">
      &lt;button id="foto" type="button" class="btn btn-outline-secondary">
        &lt;i class="bi bi-camera-fill">&lt;/i> Foto
      &lt;/button>
    &lt;/div>
  &lt;/div>
&lt;/div>
&lt;/body></pre>
  <pre data-lang="css">html { font-size: 50%; padding: 2rem; }
.card { width: 32.2rem;}</pre>
  <pre data-lang="js">// El elemento del web component
const snapshot = document.getElementById("snapshot");
const foto = document.getElementById("foto");
// Para alternar el botón entre foto y descarga
foto.onclick = function() {
  try {
    const modoFoto = foto.textContent.indexOf('Foto') > -1;
    modoFoto ? snapshot.capturePhoto() : snapshot.downloadPhoto();
    foto.innerHTML = modoFoto ? 
      '&lt;i class="bi bi-file-earmark-arrow-down-fill">&lt;/i> Descargar' : 
      '&lt;i class="bi bi-camera-fill">&lt;/i> Foto';
  } catch(err) {
    foto.disabled = true;
    foto.innerHTML = 
      '&lt;i class="bi bi-exclamation-triangle-fill">&lt;/i> Pulsa en "Edit on Codepen"';
  }
};</pre></div>

[^1]: Por ejemplo, en páginas que quieran hacer un login de usuarios basado en reconocimiento facial.