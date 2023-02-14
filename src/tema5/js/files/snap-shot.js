customElements.define('snap-shot', class extends HTMLElement {
  constructor() {
    super();
    this.attachShadow({mode: 'open'});
    this.video = document.createElement('video');
    this.canvas = document.createElement('canvas');
    this.canvas.hidden = true;
    const style = document.createElement('style');
    // Estos estilos solo afectan a este componente aislado del resto del DOM
    // Para cambiar las dimensiones modificar el font-size del <snap-shot>
    style.textContent =
      'video, canvas {width: 30em; border-radius: 1em; padding: 0.5em; border: 1px dashed; box-sizing: border-box;}' +
      'canvas {border-color: black;}' +
      'video  {border-color: transparent;}';
    this.shadowRoot.append(style, this.video, this.canvas);
  }
  // Inicializamos el stream de video cuando se añade el <snap-shot> al DOM
  connectedCallback() {
    this.showMessage('⚠️', 'Grant camera access permissions');
    navigator.mediaDevices
      .getUserMedia({ video: true, audio: false })
      .then((stream) => {
        this.closePhoto();
        this.video.srcObject = stream;
        this.video.play();
      }).catch((err) => {
        this.capturePhoto = this.downloadPhoto = this.photoData = this.closePhoto = function() { throw err };
        console.error('Video stream error:', err);
        this.showMessage('⚠️', this.textContent || 'Video stream error');
      });
  }
  // Métodos del elemento HTML, para ser usados externamente
  capturePhoto() {
    this.canvas.width = this.video.videoWidth;
    this.canvas.height = this.video.videoHeight;
    const context = this.canvas.getContext("2d");
    context.drawImage(this.video, 0, 0, this.video.videoWidth, this.video.videoHeight);
    this.video.hidden = true;
    this.canvas.hidden = false;
  }
  downloadPhoto() {
    const link = document.createElement('a');
    link.download = 'photo.png';
    link.href = this.photoData();
    link.click();
    this.closePhoto();
  }
  photoData() {
    return this.canvas.toDataURL();
  }
  closePhoto() {
    this.video.hidden = false;
    this.canvas.hidden = true;
  }
  showMessage(icon, msg) {
    this.canvas.width = this.canvas.width * 4;
    this.canvas.height = this.canvas.height * 4;
    const context = this.canvas.getContext("2d");
    context.font = '10em sans-serif';
    context.textAlign = "center";
    context.fillText(icon, this.canvas.width / 2, this.canvas.height / 2);
    context.font = '4em sans-serif';
    context.fillText(msg, this.canvas.width / 2, this.canvas.height / 2 + 100);
    this.video.hidden = true;
    this.canvas.hidden = false;
  }
});
