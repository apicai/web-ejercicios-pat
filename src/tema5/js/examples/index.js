// Paso 1: obtener los elementos del HTML a manipular

const figura = document.getElementById('figura');
const foto = document.getElementById('foto');
const edad = document.getElementById('edad');
const genero = document.getElementById('genero');
const pais = document.getElementById('pais');
const nombre = document.getElementById('nombre');

// Paso 2: modificar los elementos de la UI para dar feedback al usuario de cuando se está en reposo o cargando datos

const muestraVacio = function() {
  figura.classList.remove('animate-pulse', 'bg-gray-300', 'hidden');
  foto.src = '';
  foto.hidden = true;
  edad.innerHTML = '';
  genero.innerHTML = '';
  pais.innerHTML = '';
}

const muestraCargando = function() {
  figura.classList.remove('hidden');
  figura.classList.add('animate-pulse', 'bg-gray-300');
  foto.src = '';
  foto.hidden = true;
  edad.innerHTML = '<div class="animate-pulse h-2.5 ms-2 bg-gray-200 rounded-full w-24"></div>';
  genero.innerHTML = edad.innerHTML;
  pais.innerHTML = edad.innerHTML;
}

// Paso 3: para actualizar los elementos de la UI con los datos recibidos

const muestraFoto = function(url) {
  foto.src = url;
  foto.onload = function() {
    foto.hidden = false;
    figura.classList.add('hidden');
  }
  foto.onerror = function() {
    foto.hidden = true;
    figura.classList.remove('animate-pulse', 'bg-gray-300', 'hidden');
  }
}

const muestraEdad = function(valor) {
  edad.textContent = valor || 'Desconocida';
}

const muestraGenero = function(valor) {
  genero.textContent = valor || 'Desconocido';
}

const muestraPais = function(valor) {
  pais.textContent = valor || 'Desconocido';
}

// Paso 4: peticiones a las APIs para recuperar los datos

const obtenEdad = function(nombre) {
  fetch(`https://api.agify.io/?name=${nombre}`).then(respuesta => {
    if (respuesta.ok) {
      return respuesta.json();
    }
  }).then(objeto => {
    muestraEdad(objeto && objeto.age);
  }).catch(error => muestraEdad('Error'));
}

const obtenGenero = function(nombre) {
  fetch(`https://api.genderize.io/?name=${nombre}`).then(respuesta => {
    if (respuesta.ok) {
      return respuesta.json();
    }
  }).then(objeto => {
    muestraGenero(objeto && objeto.gender);
  }).catch(error => muestraGenero('Error'));
}

const obtenCodigoPais = function(nombre) {
  fetch(`https://api.nationalize.io/?name=${nombre}`).then(respuesta => {
    if (respuesta.ok) {
      return respuesta.json();
    }
  }).then(objeto => {
    obtenPais(objeto && objeto.country.length && objeto.country[0].country_id);
  }).catch(error => muestraPais('Error'));
}

const obtenPais = function(codigo) {
  fetch(`https://restcountries.com/v3.1/alpha/${codigo}?fields=name,flag`).then(respuesta => {
    if (respuesta.ok) {
      return respuesta.json();
    }
  }).then(objeto => {
    muestraPais(objeto && (objeto.flag + " " + objeto.name.common));
  }).catch(error => muestraPais('Error'));
}

const obtenFoto = function(nombre) {
  muestraFoto(`https://robohash.org/${nombre}.png`);
}

// Paso 5: añadimos el evento que dispara la obtención de datos

nombre.onkeyup = function() {
  const nombreBuscado = nombre.value;
  if (nombreBuscado.length > 2) {
    muestraCargando();
    // Para no lanzar peticiones innecesarias si el usuario está tecleando todavía
    setTimeout(() => {
      if (nombreBuscado !== nombre.value) return;
      obtenEdad(nombreBuscado);
      obtenGenero(nombreBuscado);
      obtenCodigoPais(nombreBuscado);
      obtenFoto(nombreBuscado);
    }, 1000);
  } else  {
    muestraVacio();
  }
}

// Paso 6: ejecutamos al cargar la página con el valor que ya tuviera el campo antes de teclear

nombre.onkeyup();