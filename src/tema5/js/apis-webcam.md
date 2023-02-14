# JavaScript
## Web APIs

### Webcam

Por explorar otras de las muchas [APIs Web](https://developer.mozilla.org/en-US/docs/Web/API) disponibles, vamos a utilizar las de la [Webcam](https://developer.mozilla.org/en-US/docs/Web/API/MediaDevices/getUserMedia) y [Canvas](https://developer.mozilla.org/en-US/docs/Web/API/CanvasRenderingContext2D) para hacernos una foto.

<div class="codepen" data-height="460" data-theme-id="light" data-default-tab="js,result" data-editable="true" style="opacity:0" data-prefill='{"stylesheets":["https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css","https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css"]}' data-allow="camera; display-capture; geolocation; microphone">
  <pre data-lang="html">&lt;body>
&lt;div class="card">
  &lt;div class="card-body row">
    &lt;div class="col-12">
      &lt;video id="video">Cámara no disponible&lt;/video>
      &lt;canvas id="canvas" hidden>&lt;/canvas>
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
video, canvas { width: 30em; border-radius: 1em; padding: 0.5em; border: 1px dashed; }
canvas { border-color: black; }
video { border-color: transparent; }
.card { width: 32.2rem;}</pre>
  <pre data-lang="js">// El elemento vídeo muestra el stream de la cámara
const video = document.getElementById("video");
// El elemento canvas pinta una instantánea del stream
const canvas = document.getElementById("canvas");
const foto = document.getElementById("foto");
// API de la webcam para obtener su stream
navigator.mediaDevices
  .getUserMedia({ video: true, audio: false })
  .then((stream) => {
    video.srcObject = stream;
    video.play();
  }).catch((err) => {
    foto.disabled = true;
    foto.innerHTML = 
      '&lt;i class="bi bi-exclamation-triangle-fill">&lt;/i> Pulsa en "Edit on Codepen"';
  });
// API del canvas que pinta la imagen actual del vídeo
const hazFoto = function() {
  canvas.width = video.videoWidth;
  canvas.height = video.videoHeight;
  const context = canvas.getContext("2d");
  context.drawImage(video, 0, 0, video.videoWidth, video.videoHeight);
}
// Para descargar la imagen capturada
const descargar = function() {
  const link = document.createElement('a');
  link.download = 'foto.png';
  link.href = canvas.toDataURL();
  link.click();
}
// Para alternar el botón entre foto y descarga
foto.onclick = function() {
  const modoFoto = foto.textContent.indexOf('Foto') > -1;
  modoFoto ? hazFoto() : descargar();
  video.hidden = modoFoto;
  canvas.hidden = !modoFoto;
  foto.innerHTML = modoFoto ? 
    '&lt;i class="bi bi-file-earmark-arrow-down-fill">&lt;/i> Descargar' : 
    '&lt;i class="bi bi-camera-fill">&lt;/i> Foto';
};</pre></div>