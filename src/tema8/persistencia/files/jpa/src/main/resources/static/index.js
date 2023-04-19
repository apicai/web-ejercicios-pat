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