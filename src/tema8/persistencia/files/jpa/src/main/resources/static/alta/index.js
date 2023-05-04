// TODO: añadir lógica particular de esta página

incrementaCreaContador('alta');

console.log('El usuario actualmente logado es:', usuarioLogado);

document.getElementById("alta").onclick = function() {
  if (!document.getElementById("formulario-alta").reportValidity()) return;
  const resultado = document.getElementById("resultado-alta");
  const email = document.getElementById("email-alta");
  const clave = document.getElementById("clave-alta");
  const claveConf = document.getElementById("clave-conf-alta");
  if (clave.value !== claveConf.value) {
    clave.value = '';
    claveConf.value = '';
    resultado.textContent = 'Las claves no coinciden, vuelve a introducirlas.';
    return;
  }
  peticionApi(`/api/usuarios`, 'POST', {email: email.value}, email.value, clave.value)
    .then(respuesta => respuesta.json())
    .then(json => {
      if (json.email) {
        email.value = '';
        clave.value = '';
        claveConf.value = '';
        resultado.textContent = `Usuario ${json.email} registrado. Ya puedes logarte con él.`;
      } else if (json.status === 409) {
        resultado.textContent = 'Ya existe un usuario registrado con mismo email.';
      } else {
        throw json;
      }
    }).catch(error => {
      resultado.textContent = 'Error inesperado al hacer el alta.';
      console.error(`Error inesperado al hacer el alta`, error);
    });
};