// TODO: añadir la lógica JS para cada página de tu aplicación

function login() {
  incrementaCreaContador('login');
}

function alta() {
  incrementaCreaContador('alta');
}

function perfil() {
  incrementaCreaContador('perfil');
}

function inicio() {
  incrementaCreaContador('inicio');
}

function buscador() {
  incrementaCreaContador('buscador');
}

function detalle() {
  incrementaCreaContador('detalle');
}

function comentarios() {
  incrementaCreaContador('comentarios');
}

function editor() {
  incrementaCreaContador('editor');
}

function ayuda() {
  incrementaCreaContador('ayuda');
}

function contacto() {
  incrementaCreaContador('contacto');
}

function estadisticas() {
  incrementaCreaContador('estadísticas');
  // Completo el menú del HTML
  const contador = document.getElementById("contador");
  !contador.options.length && document.querySelectorAll('nav a').forEach(a =>
    contador.innerHTML += `<option value="${a.textContent.toLowerCase()}">${a.textContent}</option>`
  );
  // Añado lógica a los botones del HTML
  const resultado = document.getElementById("resultado-api-contador");
  document.getElementById("consultar").onclick = function() {
    peticionApi(`/api/contadores/${contador.value}`)
      .then(respuesta => respuesta.json())
      .then(json => {
        if (json.valor !== undefined) {
          resultado.textContent = `El valor del contador "${json.nombre}" es: ${json.valor}.`;
        } else if (json.status === 404) {
          resultado.textContent = `El contador "${contador.value}" no existe todavía.`;
        } else {
          throw json;
        }
      })
      .catch(error => {
        resultado.textContent = `Error inesperado al consultar contador "${contador.value}".`;
        console.error(`Error inesperado al consultar contador "${contador.value}".`, error);
      });
  };
  document.getElementById("borrar").onclick = function() {
    peticionApi(`/api/contadores/${contador.value}`, 'DELETE')
      .then(respuesta => {
        if (respuesta.status === 200) {
          resultado.textContent = `El contador "${contador.value}" ha sido borrado.`;
        } else {
          throw respuesta;
        }
      })
      .catch(error => {
        resultado.textContent = `Error inesperado al borrar contador "${contador.value}".`;
        console.error(`Error inesperado al borrar contador "${contador.value}".`, error);
      });
  }
}

function incrementaCreaContador(contador) {
  peticionApi(`/api/contadores/${contador}/incremento/1`, 'PUT')
    .then(respuesta => respuesta.json())
    .then(json => {
      if (json.status === 404) {
        return peticionApi(`/api/contadores`, 'POST', {nombre: contador, valor: 1});
      } else if (json.valor === undefined) {
        throw json;
      }
    }).then(respuesta => {
      if (respuesta && respuesta.status !== 201) { throw respuesta; }
    }).catch(error => {
      console.error(`Error inesperado al incrementar contador "${contador}".`, error);
    });
}