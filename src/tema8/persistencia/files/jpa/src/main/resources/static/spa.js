// Puedes usar esta función para llamar al API REST de tu aplicación
function peticionApi(ruta, metodo, cuerpo, usuario, clave) {
  return fetch(ruta, {
    method: metodo || 'GET',
    headers: {
      'Authorization': 'Basic ' + btoa((usuario || '') + ':' + (clave || '')),
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: cuerpo && JSON.stringify(cuerpo) || null
  });
}

// Puedes usar esta función para mostrar una seccion concreta usando JS, ejemplo: muestraSeccion('editor')
function muestraSeccion(id) {
  if (id) return window.location.hash = id;
  const paginaInicial = window.location.hash || document.querySelector('nav a').getAttribute('href');
  descargaPagina(paginaInicial.substring(1), document.querySelector('main'));
}

// Puedes usar esta función para crear elementos del DOM a partir de un html:
// const fila = creaElemento('<tr><td>celda</td></tr>');
// fila.onclick = e => console.log(e.target);
// document.getElementById('tabla').appendChild(fila);
function creaElemento(html) {
  var template = document.createElement('template');
  template.innerHTML = html.trim();
  return template.content.firstChild;
}

// Funciones privadas sin uso externo
function descargaPagina(id, padre) {
  fetch(`${id}/index.html`)
    .then(respuesta => {
      if (respuesta.ok) return respuesta.text();
      else throw respuesta;
    }).then(html => {
      padre.innerHTML = `<link rel="stylesheet" href="${id}/index.css">${html}`;
      descargaScript(id, padre);
    }).catch(error => {
      console.warn('No se puede descargar la página', id, error);
      isNaN(id) && descargaPagina(error.status || 500, padre);
    });
}

function descargaScript(id, padre) {
  fetch(`${id}/index.js`)
    .then(respuesta => {
      if (respuesta.ok) return respuesta.text();
      else throw respuesta;
    }).then(js => {
      const script = document.createElement("script");
      script.text = `(function() { ${js} })();//# sourceURL=${id}/index.js`;
      padre.appendChild(script);
    }).catch(error => {
      console.warn('No se puede descargar el script', id, error);
    });
}

window.addEventListener('hashchange', () => muestraSeccion());
window.addEventListener('load', () => muestraSeccion());