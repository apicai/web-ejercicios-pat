// TODO: añadir la lógica común e inicial de tu aplicación

function incrementaCreaContador(contador) {
  peticionApi(`/api/contadores/${contador}/incremento/1`, 'PUT')
    .then(respuesta => respuesta.json())
    .then(json => {
      if (json.status === 404) {
        return peticionApi(`/api/contadores`, 'POST', {nombre: contador, valor: 1});
      } else if (json.status) {
        throw json;
      }
    }).then(respuesta => {
      if (respuesta && respuesta.status !== 201) { throw respuesta; }
    }).catch(error => {
      console.error(`Error inesperado al incrementar contador "${contador}".`, error);
    });
}

// NO BORRAR: estas funciones permiten crear una SPA

// Puedes usar esta función para llamar al API REST de tu aplicación
function peticionApi(ruta, metodo, cuerpo, usuario, clave) {
  return fetch(ruta, {
    method: metodo,
    headers: {
      'Authorization': 'Basic ' + btoa(usuario + ":" + clave),
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: cuerpo && JSON.stringify(cuerpo) || null
  });
}

// Puedes usar esta función para mostrar una página concreta usando JS, ejemplo: muestraPagina('editor')
function muestraPagina(id) {
  const paginaInicial = window.location.hash || document.querySelector('nav a').getAttribute('href');
  descargaPagina(id || paginaInicial.substring(1), document.querySelector('main'));
}

function descargaPagina(id, padre) {
  fetch(`${id}/index.html`)
    .then(respuesta => {
      if (respuesta.ok) return respuesta.text();
      else throw respuesta;
    }).then(html => {
      padre.innerHTML = `<link rel="stylesheet" href="${id}/index.css">${html}`;
      descargaScript(id, padre);
    }).catch(error => {
      console.warn('Error al descargar la página', id, error);
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
      script.text = `(function() { ${js} })();`;
      padre.appendChild(script);
    }).catch(error => {
      console.warn('Error al descargar el script', id, error);
    });
}

window.addEventListener('hashchange', () => muestraPagina());
window.addEventListener('load', () => muestraPagina());