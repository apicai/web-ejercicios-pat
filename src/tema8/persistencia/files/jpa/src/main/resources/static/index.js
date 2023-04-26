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

document.getElementById("entrar").onclick = function() {
  peticionApi(`/api/usuario`, null, null, document.getElementById("usuario").value, document.getElementById("clave").value)
    .then(respuesta => respuesta.json())
    .then(json => {
      document.getElementById("login").hidden = true;
      document.getElementById("estado").hidden = false;
      if (json.email) {
        document.getElementById("accion").value = 'Salir';
        document.getElementById("mensaje").textContent = json.email;
        json.clave = document.getElementById("clave").value;
        usuario = json;
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
  document.getElementById("usuario").value = '';
  document.getElementById("clave").value = '';
  usuario = null;
};

document.getElementById("usuario").addEventListener("keyup", function(event) {
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