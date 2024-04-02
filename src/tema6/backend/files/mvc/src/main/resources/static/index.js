window.addEventListener('load', e => { if(!location.hash) location.hash = 'inicio'; });
window.addEventListener('hashchange', () => {
  // Código de inicialización de cada sección
  switch(location.hash) {
    case '#inicio':
      incrementaContador('inicio');
      break;
    case '#nosotros':
      incrementaContador('nosotros');
      break;
    case '#productos':
      incrementaContador('productos');
      break;
    case '#contacto':
      incrementaContador('contacto');
      break;
    case '#estadisticas':
      incrementaContador('estadisticas');
      break;
    default:
      break;
  }
});

function incrementaContador(contador) {
  fetch(peticion(`/api/contadores/${contador}/incremento/1`, 'PUT'))
    .then(respuesta => {
      if (respuesta.status === 404) creaContador(contador);
      else if (!respuesta.ok) throw respuesta.status;
    }).catch(error => {
      console.error(`Error inesperado al incrementar contador "${contador}".`, error);
    });
}

function creaContador(contador) {
  fetch(peticion(`/api/contadores`, 'POST', {nombre: contador, valor: 1}))
    .then(respuesta => {
      if (!respuesta.ok) throw respuesta.status;
    }).catch(error => {
      console.error(`Error inesperado al crear contador "${contador}".`, error);
    });
}

function valorContador(contador) {
  contador = contador || document.getElementById('input-contador').value;
  if (!contador) return;
  fetch(peticion(`/api/contadores/${contador}`))
    .then(respuesta => {
      if (respuesta.ok) return respuesta.json();
      else throw respuesta.status;
    }).then(json => {
      document.getElementById('estadisticas-resultado').textContent = `El valor de "${contador}" es: ${json.valor}.`;
    }).catch(error => {
      document.getElementById('estadisticas-resultado').textContent = `Error al leer "${contador}": ${error}`;
    });
}

function borraContador(contador) {
  contador = contador || document.getElementById('input-contador').value;
  if (!contador) return;
  fetch(peticion(`/api/contadores/${contador}`, 'DELETE'))
    .then(respuesta => {
      if (!respuesta.ok) throw respuesta.status;
      else document.getElementById('estadisticas-resultado').textContent = `Contador "${contador}" borrado.`;
    }).catch(error => {
      document.getElementById('estadisticas-resultado').textContent = `Error al borrar "${contador}": ${error}`;
    });
}

function peticion(url, method, body) {
  const headers = {
    'Authorization': 'Basic ' + btoa('administrador' + ':' + 'clave-prd'),
    'Content-Type': 'application/json'
  }
  return new Request(url, {
    method: method || 'GET',
    body: body ? JSON.stringify(body) : undefined,
    headers
  });
}