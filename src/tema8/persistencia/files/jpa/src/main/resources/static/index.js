// TODO: añadir la lógica común y/o inicial de tu aplicación

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

let usuarioLogado;

document.getElementById("entrar").onclick = function() {
  if (!document.getElementById("formulario-login").reportValidity()) return;
  const email = document.getElementById("email").value;
  const clave = document.getElementById("clave").value;
  peticionApi(`/api/usuarios/${email}/login`, null, null, email, clave)
    .then(respuesta => respuesta.json())
    .then(json => {
      document.getElementById("login").hidden = true;
      document.getElementById("estado").hidden = false;
      if (json.email) {
        document.getElementById("accion").value = 'Salir';
        document.getElementById("mensaje").textContent = json.email;
        document.getElementById("clave").value = '';
        usuarioLogado = json;
      } else if (json.status === 401) {
        document.getElementById("accion").value = 'Volver';
        document.getElementById("mensaje").textContent = 'Credenciales incorrectas';
      } else {
        throw json;
      }
    }).catch(error => {
      document.getElementById("login").hidden = true;
      document.getElementById("estado").hidden = false;
      document.getElementById("accion").value = 'Reintentar';
      document.getElementById("mensaje").textContent = 'Error inesperado';
      console.error(`Error inesperado al hacer login`, error);
    });
};

document.getElementById("accion").onclick = function() {
  document.getElementById("login").hidden = false;
  document.getElementById("estado").hidden = true;
  usuarioLogado && peticionApi(`/api/usuarios/${usuarioLogado.email}/logout`).finally(_ => {});
  usuarioLogado = null;
};

document.getElementById("email").addEventListener("keyup", function(event) {
  if(event.key === 'Enter') {
    event.preventDefault();
    document.getElementById("clave").focus();
  }
});

document.getElementById("clave").addEventListener("keyup", function(event) {
  if(event.key === 'Enter') {
    event.preventDefault();
    document.getElementById("entrar").click();
  }
});

const peticionApiSinLogout = peticionApi;
peticionApi = function peticionApi(...args) {
  return peticionApiSinLogout(...args).then(response => {
    response.status === 401 && usuarioLogado && document.getElementById("accion").click();
    return response;
  });
}