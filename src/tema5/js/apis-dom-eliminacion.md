# JavaScript
## Web APIs

### DOM

#### Eliminación

Los elementos del DOM se puede eliminar de varias formas:

```js
// Eliminar un solo elemento:
const tituloEliminacion = document.getElementById('eliminación');
tituloEliminacion.remove();

// Eliminar todos los elementos hijos:
const barraLateral = document.getElementById('sidebar');
barraLateral.innerHTML = '';
```

En vez de eliminarlos del DOM, otra opción es ocultarlos modificando sus propiedades/estilos:

```js
const tituloWebApis = document.getElementById('web-apis');
tituloWebApis.hidden = true;

// Mismo comportamiento que el anterior:
// tituloWebApis.style = 'display:none';

// El elemento se hace invisible y sigue ocupando su espacio:
// tituloWebApis.style = 'visibility:hidden';
```