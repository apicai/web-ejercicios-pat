function muestraPagina(id) {
  const paginaInicial = document.querySelector('nav a').getAttribute('href');
  const paginas = document.querySelectorAll('article');
  paginas.forEach(pagina => pagina.hidden = true);
  const nuevaPagina = document.getElementById(id || (window.location.hash || paginaInicial).substring(1)) ||
                      document.getElementById('404');
  nuevaPagina.hidden = false;
  window[nuevaPagina.id] instanceof Function && window[nuevaPagina.id]();
}

window.addEventListener('hashchange', () => muestraPagina());
window.addEventListener('load', () => muestraPagina());

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