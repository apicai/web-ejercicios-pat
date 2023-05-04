// TODO: añadir lógica particular de esta página

incrementaCreaContador('estadísticas');

console.log("El usuario actualmente logado es:", usuarioLogado);

// Completo el menú de contadores en el HTML

const contador = document.getElementById("contador");
document.querySelectorAll('nav a').forEach(a =>
  contador.innerHTML += `<option value="${a.textContent.toLowerCase()}">${a.textContent}</option>`
);

// Añado lógica a los botones del HTML

const resultado = document.getElementById("resultado-estadisticas");
document.getElementById("consultar").onclick = function() {
  peticionApi(`/api/contadores/${contador.value}`)
    .then(respuesta => respuesta.json())
    .then(json => {
      if (json.valor !== undefined) {
        resultado.textContent = `El valor del contador "${json.nombre}" es: ${json.valor}.`;
      } else if (json.status === 404) {
        resultado.textContent = `El contador "${contador.value}" no existe todavía.`;
      } else if (json.status === 401) {
        resultado.textContent = `Tienes que estar logado para consultar contadores`;
      } else {
        throw json;
      }
    })
    .catch(error => {
      resultado.textContent = `Error inesperado al consultar contador "${contador.value}".`;
      console.error(resultado.textContent, error);
    });
};

document.getElementById("borrar").onclick = function() {
  peticionApi(`/api/contadores/${contador.value}`, 'DELETE')
    .then(respuesta => {
      if (respuesta.status === 200) {
        resultado.textContent = `El contador "${contador.value}" ha sido borrado.`;
      } else if (respuesta.status === 401) {
        resultado.textContent = `Tienes que estar logado para borrar contadores`;
      } else if (respuesta.status === 403) {
        resultado.textContent = `No tienes permisos para borrar contadores`;
      } else {
        throw respuesta;
      }
    })
    .catch(error => {
      resultado.textContent = `Error inesperado al borrar contador "${contador.value}".`;
      console.error(resultado.textContent, error);
    });
};