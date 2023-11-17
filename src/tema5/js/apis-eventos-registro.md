# JavaScript
## Web APIs

### Eventos

#### Registro

Hay 3 formas de escuchar eventos sobre un elemento HTML, todas ellas pasando una función JavaScript que recibirá los datos del evento cuando se produzca:

1. Indicando dicha función en el HTML del elemento, en el atributo asociado al evento:

   ```html
   <button id="boton" type="button" onclick="meHanPulsado()">Botón</button>
   ```

1. O, asignándola a ese atributo pero utilizando el API del DOM:

   ```js
   const boton = document.getElementById('boton');
   const meHanPulsado = (event) => boton.textContent = `Click nº ${event.detail}`;
   boton.onclick = meHanPulsado;
   ```

1. O, utilizando la función `addEventListener` sobre el elemento del DOM:

   ```js
   boton.addEventListener('click', meHanPulsado);
   ```

> **❓ Ejercicio 1:** _Utilizando la consola JavaScript del navegador, haz que al pulsar sobre el título "Registro" de esta página, se ejecute la función `meHanPulsado` anterior._

> **❓ Ejercicio 2:** _Modifica la función, para que cuando el evento indique que se ha pulsado 3 veces, se restaure el título y se quite el handler (si usaste `addEventListener` deberás usar `removeEventListener`)._